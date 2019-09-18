package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RasResponse{

    @JsonProperty("core")
    private Core core;

    @JsonProperty("content")
    private Content content;

    public void setCore(Core core){
        this.core = core;
    }

    public Core getCore(){
        return core;
    }

    public void setContent(Content content){
        this.content = content;
    }

    public Content getContent(){
        return content;
    }

    @Override
    public String toString(){
        return
            "RasResponse{" +
            "core = '" + core + '\'' +
            ",content = '" + content + '\'' +
            "}";
        }
}
