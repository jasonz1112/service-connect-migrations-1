package com.opentable.gc.infra.connectmigrations.controllers;


import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminService;


@RequestMapping("/restaurants")
@RestController
public class GetRestaurantAdminServiceController {

    private final GetRestaurantAdminService getRestaurantAdminService;

    public GetRestaurantAdminServiceController(@Qualifier("agg1") GetRestaurantAdminService getRestaurantAdminService) {
        this.getRestaurantAdminService = getRestaurantAdminService;
    }

    @GetMapping("/{restaurantId}")
    public GetRestaurantAdminServiceResponse getRestaurant(@PathVariable("restaurantId") String restaurantId) throws IOException {

        if (StringUtils.isEmpty(restaurantId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The 'restaurantId' cannot be null or empty");
        }

        return getRestaurantAdminService.getGetRestaurantResponse(restaurantId);
    }

}
