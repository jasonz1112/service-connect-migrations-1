package com.opentable.gc.infra.connectmigrations.model.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CustomMessages{

    @JsonProperty("RestaurantDescription")
    private RestaurantDescription restaurantDescription;

    @JsonProperty("PublicTransit")
    private PublicTransit publicTransit;

    @JsonProperty("Confirmation")
    private Confirmation confirmation;

    @JsonProperty("ParkingDescription")
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
