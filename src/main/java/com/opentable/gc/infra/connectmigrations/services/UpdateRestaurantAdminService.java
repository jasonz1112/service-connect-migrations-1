package com.opentable.gc.infra.connectmigrations.services;

import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;

public interface UpdateRestaurantAdminService {
    void updateRestaurantService(String restaurantId, RasPatchRequest rasPatchRequest);
}
