package com.opentable.gc.infra.connectmigrations.services;

import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;

public interface GetRestaurantAdminService {
    GetRestaurantAdminServiceResponse getGetRestaurantResponse(String restaurantId);
}
