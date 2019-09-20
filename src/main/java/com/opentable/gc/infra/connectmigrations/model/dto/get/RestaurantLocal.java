package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonAlias;

public class RestaurantLocal{

    @JsonAlias({"en-GB",
            "en-US",
            "de-DE",
            "en-AU",
            "en-CA",
            "en-GB",
            "en-IE",
            "en-US",
            "es-MX",
            "fr-CA",
            "ja-JP",
            "de-DE",
            "fr-FR"})
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
