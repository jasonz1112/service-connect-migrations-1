package com.opentable.gc.infra.connectmigrations.model.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Restaurant{

    @JsonProperty("restaurantType")
    private String restaurantType;

    @JsonProperty("restaurantStateId")
    private int restaurantStateId;

    public void setRestaurantType(String restaurantType){
        this.restaurantType = restaurantType;
    }

    public String getRestaurantType(){
        return restaurantType;
    }

    public void setRestaurantStateId(int restaurantStateId){
        this.restaurantStateId = restaurantStateId;
    }

    public int getRestaurantStateId(){
        return restaurantStateId;
    }

    @Override
    public String toString(){
        return
            "Restaurant{" +
            "restaurantType = '" + restaurantType + '\'' +
            ",restaurantStateId = '" + restaurantStateId + '\'' +
            "}";
        }
}
