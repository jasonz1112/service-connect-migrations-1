package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Confirmation{

    @JsonProperty("en-US")
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
            "Confirmation{" +
            "en-US = '" + enUS + '\'' +
            "}";
        }
}
