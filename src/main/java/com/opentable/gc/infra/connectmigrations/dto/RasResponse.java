package com.opentable.gc.infra.connectmigrations.dto;

public class RasResponse{
    private Core core;
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
