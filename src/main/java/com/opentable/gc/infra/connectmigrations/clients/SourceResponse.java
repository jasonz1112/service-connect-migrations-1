package com.opentable.gc.infra.connectmigrations.clients;

public class SourceResponse {

    private final String rid;
    private final String restaurantType;
    private final String typeDesc;
    private final String country;
    private final String restaurantName;
    private final String stateId;
    private final String stateDesc;


    public SourceResponse(String rid, String restaurantType, String typeDesc, String country, String restaurantName, String stateId, String stateDesc) {
        this.rid = rid;
        this.restaurantType = restaurantType;
        this.typeDesc = typeDesc;
        this.country = country;
        this.restaurantName = restaurantName;
        this.stateId = stateId;
        this.stateDesc = stateDesc;
    }

    public String getRid() {
        return rid;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public String getCountry() {
        return country;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getStateId() {
        return stateId;
    }

    public String getStateDesc() {
        return stateDesc;
    }


}
