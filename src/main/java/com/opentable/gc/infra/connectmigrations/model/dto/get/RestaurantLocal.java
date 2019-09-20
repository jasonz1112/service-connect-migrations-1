package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonAlias;

public class RestaurantLocal{

    @JsonAlias({"en-US", "ja-JP"})
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
