package com.opentable.gc.infra.connectmigrations.clients;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;
import com.opentable.gc.infra.connectmigrations.clients.config.SourceConfiguration;

public class RestaurantAdminServiceClientRAS implements RestaurantAdminServiceClient {

    private static final String path = "/restaurant-admin/v2/restaurants/";
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantAdminServiceClientRAS.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final SourceConfiguration config;
    private final RestTemplate restTemplate;

    public RestaurantAdminServiceClientRAS(SourceConfiguration config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    @Override
    public RasResponse getRestaurant(String restaurantId) throws IOException {
        StringBuilder queryUrl = new StringBuilder(config.getUrl());
        queryUrl.append(path);
        queryUrl.append(restaurantId);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(queryUrl.toString(), String.class);
            String responseStr = result.getBody();
            return objectMapper.readValue(responseStr, RasResponse.class);
        } catch (HttpClientErrorException | IOException exception) {
            LOG.error(exception.getMessage());
            throw exception;
        }
    }

    @Override
    public void updateRestaurant(String restaurantId, RasPatchRequest rasPatchRequest) throws JsonProcessingException {
        StringBuilder queryUrl = new StringBuilder(config.getUrl());
        queryUrl.append(path);
        queryUrl.append(restaurantId);
        String serializedRequest = objectMapper.writeValueAsString(rasPatchRequest);

        RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
                .handle(HttpStatusCodeException.class)
                .withBackoff(config.getDelay(), config.getMaxDelay(), ChronoUnit.SECONDS)
                .withMaxRetries(config.getMaxRetries())
                .onFailure(e -> LOG.error("Failed to update restaurant info", e.getFailure()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Failsafe.with(retryPolicy).run(() -> {
            HttpEntity<String> httpSourceRequest = new HttpEntity<String>(serializedRequest, headers);

            restTemplate.exchange(queryUrl.toString(), HttpMethod.PATCH, httpSourceRequest, String.class);
        });


    }
}
