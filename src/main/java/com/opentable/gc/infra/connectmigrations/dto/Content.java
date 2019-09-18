package com.opentable.gc.infra.connectmigrations.dto;

public class Content{
    private CustomMessages customMessages;
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
