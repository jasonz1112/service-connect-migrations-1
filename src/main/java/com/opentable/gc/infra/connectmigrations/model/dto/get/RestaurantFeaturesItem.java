package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RestaurantFeaturesItem{

    @JsonProperty("feature")
    private String feature;

    @JsonProperty("featureSet")
    private String featureSet;

    @JsonProperty("valueBool")
    private boolean valueBool;

    public void setFeature(String feature){
        this.feature = feature;
    }

    public String getFeature(){
        return feature;
    }

    public void setFeatureSet(String featureSet){
        this.featureSet = featureSet;
    }

    public String getFeatureSet(){
        return featureSet;
    }

    public void setValueBool(boolean valueBool){
        this.valueBool = valueBool;
    }

    public boolean isValueBool(){
        return valueBool;
    }

    @Override
    public String toString(){
        return
            "RestaurantFeaturesItem{" +
            "feature = '" + feature + '\'' +
            ",featureSet = '" + featureSet + '\'' +
            ",valueBool = '" + valueBool + '\'' +
            "}";
        }
}
