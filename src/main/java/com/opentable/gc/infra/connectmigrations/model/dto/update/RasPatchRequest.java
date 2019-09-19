package com.opentable.gc.infra.connectmigrations.model.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;



public class RasPatchRequest {

    @JsonProperty("core")
    private Core core;

    public void setCore(Core core){
        this.core = core;
    }

    public Core getCore(){
        return core;
    }

    @Override
    public String toString(){
        return
            "RasPatchRequest{" +
            "core = '" + core + '\'' +
            "}";
        }
}
