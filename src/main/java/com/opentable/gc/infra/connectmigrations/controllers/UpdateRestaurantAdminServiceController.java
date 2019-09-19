package com.opentable.gc.infra.connectmigrations.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantAdminService;
import com.opentable.gc.infra.connectmigrations.model.dto.update.RasPatchRequest;


@RequestMapping("/restaurants")
@RestController
public class UpdateRestaurantAdminServiceController {

    private final UpdateRestaurantAdminService updateRestaurantAdminService;

    public UpdateRestaurantAdminServiceController(@Qualifier("update-bean") UpdateRestaurantAdminService updateRestaurantAdminService) {
        this.updateRestaurantAdminService = updateRestaurantAdminService;
    }

    @RequestMapping(value="/{restaurantId}", method=RequestMethod.PATCH)
    public void updateRestaurant(@PathVariable("restaurantId") String restaurantId, @RequestBody RasPatchRequest rasPatchRequest) {
        updateRestaurantAdminService.updateRestaurantService(restaurantId, rasPatchRequest);
    }

}
