package com.opentable.gc.infra.connectmigrations.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestaurantInfo {

    public final String restaurantTypes;
    public final String state;

    @JsonCreator
    public RestaurantInfo(@JsonProperty("restaurantStateId") String state, @JsonProperty("restaurantType") String restaurantTypes) {
        this.state = state;
        this.restaurantTypes = restaurantTypes;
    }

    @JsonIgnore
    public boolean isInvalid() {
        return restaurantTypes == null && state == null;
    }
}
