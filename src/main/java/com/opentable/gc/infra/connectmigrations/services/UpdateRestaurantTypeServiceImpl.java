package com.opentable.gc.infra.connectmigrations.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.SourceRequest;
import com.opentable.gc.infra.connectmigrations.model.RestaurantInfo;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class UpdateRestaurantTypeServiceImpl implements UpdateRestaurantTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateRestaurantTypeServiceImpl.class);
    private final RestaurantTypeClient venue;

    public UpdateRestaurantTypeServiceImpl(RestaurantTypeClient venue) {
        this.venue = venue;
    }

    @Override
    public void updateRestaurantAggregator(String restaurantId, RestaurantInfo restaurantInfo) {
        SourceRequest request = new SourceRequest(restaurantInfo.email, restaurantInfo.phone);
        try {
            venue.updateRestaurant(restaurantId, request);
        } catch (HttpStatusCodeException | JsonProcessingException exception) {
            if (exception instanceof HttpStatusCodeException) {
                HttpStatusCodeException httpStatusCodeException = (HttpStatusCodeException) exception;
                if (httpStatusCodeException.getStatusCode().is4xxClientError()) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad client request");
                } else if (httpStatusCodeException.getStatusCode().is5xxServerError()) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error PUTing Restaurant data to source");
                }
            } else if (exception instanceof JsonProcessingException) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid JSON Body");
            }
        }
        LOGGER.debug("Updated Restaurant info for all sources");
    }
}
