package com.opentable.gc.infra.connectmigrations.services;


import com.opentable.gc.infra.connectmigrations.model.RestaurantInfo;

public interface UpdateRestaurantAdminService {
    void updateRestaurantAggregator(String restaurantId, RestaurantInfo restaurantInfo);
}
