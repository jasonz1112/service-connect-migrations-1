package com.opentable.gc.infra.connectmigrations.clients;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;
import com.opentable.gc.infra.connectmigrations.clients.config.Configuration;

public class RestaurantAdminServiceClientRAS implements RestaurantAdminServiceClient {

    @Autowired
    private ObjectMapper objectMapper;

    private static final String path = "/restaurant-admin/v2/restaurants/";
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantAdminServiceClientRAS.class);
    private static final HttpHeaders headers = new HttpHeaders();
    private final Configuration config;
    private final RestTemplate restTemplate;

    public RestaurantAdminServiceClientRAS(Configuration config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    @Override
    public RasResponse getRestaurant(String restaurantId) {
        RasResponse rasResponse = new RasResponse();
        UriComponents uri = UriComponentsBuilder.fromUriString(config.getUrl())
                .path(path + restaurantId)
                .build();
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri.toString(), String.class);

            while(result.getHeaders().getLocation() != null && result.getStatusCode() == HttpStatus.TEMPORARY_REDIRECT) {
                result = restTemplate.getForEntity(result.getHeaders().getLocation().toString(), String.class);
            }

            String responseStr = result.getBody();
            rasResponse = objectMapper.readValue(responseStr, RasResponse.class);
            return rasResponse;
        }
        catch (HttpStatusCodeException exception) {
            LOG.error(exception.getMessage());
            throw exception;
        }
        catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }
        return rasResponse;
    }

    @Override
    public void updateRestaurant(String restaurantId, RasPatchRequest rasPatchRequest) {
        UriComponents uri = UriComponentsBuilder.fromUriString(config.getUrl())
                .path(path + restaurantId)
                .build();

        try {
            String serializedRequest = objectMapper.writeValueAsString(rasPatchRequest);

            RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
                    .handle(HttpStatusCodeException.class)
                    .withBackoff(config.getDelay(), config.getMaxDelay(), ChronoUnit.SECONDS)
                    .withMaxRetries(config.getMaxRetries())
                    .onFailure(e -> LOG.error("Failed to update restaurant info", e.getFailure()));

            headers.setContentType(MediaType.APPLICATION_JSON);

            Failsafe.with(retryPolicy).run(() -> {
                HttpEntity<String> httpSourceRequest = new HttpEntity<String>(serializedRequest, headers);

                restTemplate.exchange(uri.toString(), HttpMethod.PATCH, httpSourceRequest, String.class);
            });
        }

        catch (HttpStatusCodeException exception) {
            LOG.error(exception.getMessage());
            throw exception;
        }
        catch (IOException ioException) {
            LOG.error(ioException.getMessage());
        }



    }
}
