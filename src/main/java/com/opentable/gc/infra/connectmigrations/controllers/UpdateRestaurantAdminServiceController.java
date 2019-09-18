package com.opentable.gc.infra.connectmigrations.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opentable.gc.infra.connectmigrations.model.RestaurantInfo;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantAdminService;


@RequestMapping("/restaurants")
@RestController
public class UpdateRestaurantAdminServiceController {

    private final UpdateRestaurantAdminService updateRestaurantAdminService;

    public UpdateRestaurantAdminServiceController(@Qualifier("update-agg1") UpdateRestaurantAdminService updateRestaurantAdminService) {
        this.updateRestaurantAdminService = updateRestaurantAdminService;
    }

    @RequestMapping(value="/{restaurantId}", method=RequestMethod.PATCH)
    public void updateRestaurant(@PathVariable("restaurantId") String restaurantId, @RequestBody RestaurantInfo restaurantInfo) {

        //RestaurantInfo restaurantInfo = new RestaurantInfo("1", "C");
        /**
        if (restaurantInfo.isInvalid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The update should include a valid email or phone");
        }
         **/

        updateRestaurantAdminService.updateRestaurantAggregator(restaurantId, restaurantInfo);
    }

}
