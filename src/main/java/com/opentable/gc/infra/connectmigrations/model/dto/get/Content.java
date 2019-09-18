package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Content{

    @JsonProperty("customMessages")
    private CustomMessages customMessages;

    @JsonProperty("restaurantLocal")
    private RestaurantLocal restaurantLocal;

    public void setCustomMessages(CustomMessages customMessages){
        this.customMessages = customMessages;
    }

    public CustomMessages getCustomMessages(){
        return customMessages;
    }

    public void setRestaurantLocal(RestaurantLocal restaurantLocal){
        this.restaurantLocal = restaurantLocal;
    }

    public RestaurantLocal getRestaurantLocal(){
        return restaurantLocal;
    }

    @Override
    public String toString(){
        return
            "Content{" +
            "customMessages = '" + customMessages + '\'' +
            ",restaurantLocal = '" + restaurantLocal + '\'' +
            "}";
        }
}
