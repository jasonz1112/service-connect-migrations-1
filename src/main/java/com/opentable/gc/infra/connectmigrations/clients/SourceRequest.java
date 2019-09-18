package com.opentable.gc.infra.connectmigrations.clients;

public class SourceRequest {

    public final String restaurantTypes;
    public final String state;

    public SourceRequest(String restaurantTypes, String state) {
        this.restaurantTypes = restaurantTypes;
        this.state = state;
    }

    public String getRestaurantTypes() {
        return restaurantTypes;
    }

    public String getState() {
        return state;
    }
}
