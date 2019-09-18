package com.opentable.gc.infra.connectmigrations.clients;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;

public interface RestaurantAdminServiceClient {

    RasResponse getRestaurant(String restaurantId) throws IOException;

    void updateRestaurant(String restaurantId, RasPatchRequest rasPatchRequest) throws JsonProcessingException;

}
