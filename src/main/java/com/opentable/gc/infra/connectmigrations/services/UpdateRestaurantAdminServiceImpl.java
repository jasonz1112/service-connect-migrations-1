package com.opentable.gc.infra.connectmigrations.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class UpdateRestaurantAdminServiceImpl implements UpdateRestaurantAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateRestaurantAdminServiceImpl.class);
    private final RestaurantAdminServiceClient ras;

    public UpdateRestaurantAdminServiceImpl(RestaurantAdminServiceClient ras) {
        this.ras = ras;
    }

    @Override
    public void updateRestaurantServ(String restaurantId, RasPatchRequest rasPatchRequest) {
        try {
            ras.updateRestaurant(restaurantId, rasPatchRequest);
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
