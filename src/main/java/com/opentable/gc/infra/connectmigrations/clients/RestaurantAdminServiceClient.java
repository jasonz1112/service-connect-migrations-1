package com.opentable.gc.infra.connectmigrations.clients;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RestaurantAdminServiceClient {

    SourceResponse getRestaurant(String restaurantId) throws IOException;

    void updateRestaurant(String restaurantId, SourceRequest request) throws JsonProcessingException;

}
