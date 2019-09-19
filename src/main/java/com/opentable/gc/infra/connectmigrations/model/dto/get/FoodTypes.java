package com.opentable.gc.infra.connectmigrations.model.dto.get;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;



public class FoodTypes{

    @JsonProperty("primaryCuisineId")
    private String primaryCuisineId;

    @JsonProperty("otherCuisines")
    private List<Object> otherCuisines;

    public void setPrimaryCuisineId(String primaryCuisineId){
        this.primaryCuisineId = primaryCuisineId;
    }

    public String getPrimaryCuisineId(){
        return primaryCuisineId;
    }

    public void setOtherCuisines(List<Object> otherCuisines){
        this.otherCuisines = otherCuisines;
    }

    public List<Object> getOtherCuisines(){
        return otherCuisines;
    }

    @Override
    public String toString(){
        return
            "FoodTypes{" +
            "primaryCuisineId = '" + primaryCuisineId + '\'' +
            ",otherCuisines = '" + otherCuisines + '\'' +
            "}";
        }
}
