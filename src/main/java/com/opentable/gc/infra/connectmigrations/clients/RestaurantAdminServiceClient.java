package com.opentable.gc.infra.connectmigrations.clients;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;

public interface RestaurantAdminServiceClient {

    RasResponse getRestaurant(String restaurantId);

    void updateRestaurant(String restaurantId, RasPatchRequest rasPatchRequest);

}
