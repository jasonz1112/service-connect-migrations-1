package com.opentable.gc.infra.connectmigrations.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestaurantInfo {

    public final String email;
    public final String phone;

    @JsonCreator
    public RestaurantInfo(@JsonProperty("email") String email, @JsonProperty("phone") String phone) {
        this.email = email;
        this.phone = phone;
    }

    @JsonIgnore
    public boolean isInvalid() {
        return (email == null || email.isEmpty()) && (phone == null || phone.isEmpty());
    }
}
