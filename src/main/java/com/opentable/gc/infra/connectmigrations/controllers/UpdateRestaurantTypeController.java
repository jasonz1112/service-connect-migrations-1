package com.opentable.gc.infra.connectmigrations.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opentable.gc.infra.connectmigrations.model.RestaurantInfo;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantTypeService;


@RequestMapping("/restaurants")
@RestController
public class UpdateRestaurantTypeController {

    private final UpdateRestaurantTypeService updateRestaurantTypeService;

    public UpdateRestaurantTypeController(@Qualifier("update-agg1") UpdateRestaurantTypeService updateRestaurantTypeService) {
        this.updateRestaurantTypeService = updateRestaurantTypeService;
    }

    @PutMapping("/{restaurantId}")
    public void updateRestaurant(@PathVariable("restaurantId") String restaurantId, @RequestBody RestaurantInfo restaurantInfo) {

        if (restaurantInfo.isInvalid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The update should include a valid email or phone");
        }

        updateRestaurantTypeService.updateRestaurantAggregator(restaurantId, restaurantInfo);
    }

}
