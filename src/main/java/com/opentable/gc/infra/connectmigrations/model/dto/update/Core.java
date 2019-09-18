package com.opentable.gc.infra.connectmigrations.model.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Core{

    @JsonProperty("restaurant")
    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }

    @Override
    public String toString(){
        return
            "Core{" +
            "restaurant = '" + restaurant + '\'' +
            "}";
        }
}
