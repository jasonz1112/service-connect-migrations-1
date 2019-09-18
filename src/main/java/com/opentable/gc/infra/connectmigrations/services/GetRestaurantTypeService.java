package com.opentable.gc.infra.connectmigrations.services;

import java.io.IOException;

import com.opentable.gc.infra.connectmigrations.model.GetRestaurantTypeResponse;

public interface GetRestaurantTypeService  {
    GetRestaurantTypeResponse getGetRestaurantAggregatorResponse(String restaurantId) throws IOException;
}
