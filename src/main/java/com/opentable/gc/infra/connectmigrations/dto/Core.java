package com.opentable.gc.infra.connectmigrations.dto;

import java.util.List;

public class Core{
    private List<String> amenities;
    private Restaurant restaurant;
    private FoodTypes foodTypes;
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
