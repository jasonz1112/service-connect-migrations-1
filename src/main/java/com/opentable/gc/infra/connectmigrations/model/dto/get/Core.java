package com.opentable.gc.infra.connectmigrations.model.dto.get;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Core{

    @JsonProperty("amenities")
    private List<String> amenities;

    @JsonProperty("restaurant")
    private Restaurant restaurant;

    @JsonProperty("foodTypes")
    private FoodTypes foodTypes;

    @JsonProperty("restaurantFeatures")
    private List<RestaurantFeaturesItem> restaurantFeatures;

    public void setAmenities(List<String> amenities){
        this.amenities = amenities;
    }

    public List<String> getAmenities(){
        return amenities;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }

    public void setFoodTypes(FoodTypes foodTypes){
        this.foodTypes = foodTypes;
    }

    public FoodTypes getFoodTypes(){
        return foodTypes;
    }

    public void setRestaurantFeatures(List<RestaurantFeaturesItem> restaurantFeatures){
        this.restaurantFeatures = restaurantFeatures;
    }

    public List<RestaurantFeaturesItem> getRestaurantFeatures(){
        return restaurantFeatures;
    }

    @Override
    public String toString(){
        return
            "Core{" +
            "amenities = '" + amenities + '\'' +
            ",restaurant = '" + restaurant + '\'' +
            ",foodTypes = '" + foodTypes + '\'' +
            ",restaurantFeatures = '" + restaurantFeatures + '\'' +
            "}";
        }
}
