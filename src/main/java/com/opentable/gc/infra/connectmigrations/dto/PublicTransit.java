package com.opentable.gc.infra.connectmigrations.dto;

public class PublicTransit{
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
            "PublicTransit{" +
            "en-US = '" + enUS + '\'' +
            "}";
        }
}
