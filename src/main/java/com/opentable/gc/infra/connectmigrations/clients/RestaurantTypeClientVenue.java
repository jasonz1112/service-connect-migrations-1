package com.opentable.gc.infra.connectmigrations.clients;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.opentable.gc.infra.connectmigrations.clients.config.SourceConfiguration;

public class RestaurantTypeClientVenue implements RestaurantTypeClient {

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantTypeClientVenue.class);
    private final SourceConfiguration config;
    private final RestTemplate restTemplate;

    public RestaurantTypeClientVenue(SourceConfiguration config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    @Override
    public SourceResponse getRestaurant(String restaurantId) throws IOException {
        StringBuilder queryUrl = new StringBuilder(config.getUrl());
        queryUrl.append('/');
        queryUrl.append(restaurantId);
        try {
            return config.getExtractor().extract(restTemplate.getForEntity(queryUrl.toString(), String.class).getBody());
        } catch (HttpClientErrorException | IOException exception) {
            LOG.error(exception.getMessage());
            throw exception;
        }
    }

    @Override
    public void updateRestaurant(String restaurantId, SourceRequest request) throws JsonProcessingException {
        StringBuilder queryUrl = new StringBuilder(config.getUrl());
        queryUrl.append('/');
        queryUrl.append(restaurantId);

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedRequest = objectMapper.writeValueAsString(request);

        RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
                .handle(HttpStatusCodeException.class)
                .withBackoff(config.getDelay(), config.getMaxDelay(), ChronoUnit.SECONDS)
                .withMaxRetries(config.getMaxRetries())
                .onFailure(e -> LOG.error("Failed to update restaurant info", e.getFailure()));

        Failsafe.with(retryPolicy).run(() -> {
            HttpEntity<String> httpSourceRequest = new HttpEntity<String>(serializedRequest);
            restTemplate
                    .exchange(queryUrl.toString(), HttpMethod.PUT, httpSourceRequest, String.class);
        });
    }
}
