package com.opentable.gc.infra.connectmigrations.dto;

public class CustomMessages{
    private RestaurantDescription restaurantDescription;
    private PublicTransit publicTransit;
    private Confirmation confirmation;
    private ParkingDescription parkingDescription;

    public void setRestaurantDescription(RestaurantDescription restaurantDescription){
        this.restaurantDescription = restaurantDescription;
    }

    public RestaurantDescription getRestaurantDescription(){
        return restaurantDescription;
    }

    public void setPublicTransit(PublicTransit publicTransit){
        this.publicTransit = publicTransit;
    }

    public PublicTransit getPublicTransit(){
        return publicTransit;
    }

    public void setConfirmation(Confirmation confirmation){
        this.confirmation = confirmation;
    }

    public Confirmation getConfirmation(){
        return confirmation;
    }

    public void setParkingDescription(ParkingDescription parkingDescription){
        this.parkingDescription = parkingDescription;
    }

    public ParkingDescription getParkingDescription(){
        return parkingDescription;
    }

    @Override
    public String toString(){
        return
            "CustomMessages{" +
            "restaurantDescription = '" + restaurantDescription + '\'' +
            ",publicTransit = '" + publicTransit + '\'' +
            ",confirmation = '" + confirmation + '\'' +
            ",parkingDescription = '" + parkingDescription + '\'' +
            "}";
        }
}
