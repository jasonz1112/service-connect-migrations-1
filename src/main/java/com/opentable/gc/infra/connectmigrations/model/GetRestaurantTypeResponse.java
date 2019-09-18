package com.opentable.gc.infra.connectmigrations.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRestaurantTypeResponse {

    public final int rids;
    public final String restaurantTypes;
    public final String typeDescs;
    public final String countries;
    public final String restaurantNames;
    public final String version;
    public final int state;
    public final String stateDescription;


    @JsonCreator
    public GetRestaurantTypeResponse(
            @JsonProperty("rid") int rids,
            @JsonProperty("type") String restaurantTypes,
            @JsonProperty("typeDescription") String typeDescs,
            @JsonProperty("version") String version,
            @JsonProperty("country") String countries,
            @JsonProperty("name") String restaurantNames,
            @JsonProperty("state") int state,
            @JsonProperty("stateDescription") String stateDescription
                                    ) {
        this.rids = rids;
        this.restaurantTypes = restaurantTypes;
        this.typeDescs = typeDescs;
        this.version = version;
        this.countries = countries;
        this.restaurantNames = restaurantNames;
        this.state = state;
        this.stateDescription = stateDescription;
    }

    @Override
    public String toString() {
        return "GetRestaurantTypeResponse{" +
                "rid=" + rids +
                ", type=" + restaurantTypes +
                ", typeDescription=" + typeDescs +
                ", version=" + version +
                ", country=" + countries +
                ", name=" + restaurantNames +
                ", state=" + state +
                ", stateDescription=" + stateDescription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GetRestaurantTypeResponse that = (GetRestaurantTypeResponse) o;
        return rids == that.rids &&
                restaurantTypes.equals(that.restaurantTypes) &&
                typeDescs.equals(that.typeDescs) &&
                countries.equals(that.countries) &&
                restaurantNames.equals(that.restaurantNames) &&
                state == that.state &&
                stateDescription.equals(that.stateDescription)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rids, restaurantTypes, typeDescs, countries, restaurantNames, state, stateDescription);
    }
}
