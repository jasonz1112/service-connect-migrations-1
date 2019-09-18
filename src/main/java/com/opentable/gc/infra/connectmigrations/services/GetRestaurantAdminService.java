package com.opentable.gc.infra.connectmigrations.services;

import java.io.IOException;

import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;

public interface GetRestaurantAdminService {
    GetRestaurantAdminServiceResponse getGetRestaurantResponse(String restaurantId) throws IOException;
}
