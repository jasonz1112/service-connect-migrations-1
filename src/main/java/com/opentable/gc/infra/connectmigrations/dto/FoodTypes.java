package com.opentable.gc.infra.connectmigrations.dto;

import java.util.List;

public class FoodTypes{
    private String primaryCuisineId;
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
