package com.opentable.gc.infra.connectmigrations.dto;

public class RestaurantLocal{
    private EnUS enUS;

    public void setEnUS(EnUS enUS){
        this.enUS = enUS;
    }

    public EnUS getEnUS(){
        return enUS;
    }

    @Override
    public String toString(){
        return
            "RestaurantLocal{" +
            "en-US = '" + enUS + '\'' +
            "}";
        }
}
