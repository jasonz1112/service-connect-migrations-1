package com.opentable.gc.infra.connectmigrations.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRestaurantAdminServiceResponse {

    public final int rids;
    public final String restaurantTypes;
    public final String typeDescs;
    public final String countries;
    public final String restaurantNames;
    public final String version;
    public final int state;
    public final String stateDescription;


    @JsonCreator
    public GetRestaurantAdminServiceResponse(
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
        return "GetRestaurantAdminServiceResponse{" +
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

        GetRestaurantAdminServiceResponse that = (GetRestaurantAdminServiceResponse) o;
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


    public static final class GetRestaurantTypeResponseBuilder {
        public int rids;
        public String restaurantTypes;
        public String typeDescs;
        public String countries;
        public String restaurantNames;
        public String version;
        public int state;
        public String stateDescription;

        private GetRestaurantTypeResponseBuilder() {
        }

        public static GetRestaurantTypeResponseBuilder aGetRestaurantTypeResponse() {
            return new GetRestaurantTypeResponseBuilder();
        }

        public GetRestaurantTypeResponseBuilder withRids(int rids) {
            this.rids = rids;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withRestaurantTypes(String restaurantTypes) {
            this.restaurantTypes = restaurantTypes;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withTypeDescs(String typeDescs) {
            this.typeDescs = typeDescs;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withCountries(String countries) {
            this.countries = countries;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withRestaurantNames(String restaurantNames) {
            this.restaurantNames = restaurantNames;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withVersion(String version) {
            this.version = version;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withState(int state) {
            this.state = state;
            return this;
        }

        public GetRestaurantTypeResponseBuilder withStateDescription(String stateDescription) {
            this.stateDescription = stateDescription;
            return this;
        }

        public GetRestaurantAdminServiceResponse build() {
            return new GetRestaurantAdminServiceResponse(rids, restaurantTypes, typeDescs, version, countries, restaurantNames, state, stateDescription);
        }
    }
}
