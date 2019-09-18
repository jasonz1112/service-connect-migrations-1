package com.opentable.gc.infra.connectmigrations.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantTypeResponse;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class GetRestaurantTypeServiceImpl implements GetRestaurantTypeService {

    private final RestaurantTypeClient venue;
    private static final Logger LOG = LoggerFactory.getLogger(GetRestaurantTypeServiceImpl.class);


    public GetRestaurantTypeServiceImpl(RestaurantTypeClient venue) {
        this.venue = venue;
    }


    @Override
    public GetRestaurantTypeResponse getGetRestaurantAggregatorResponse(String restaurantId) throws IOException {


        final List<RestaurantTypeClient> restaurantTypeClientList = Arrays.asList(venue);
        final String rids,
                restaurantTypes,
                typeDescs,
                countries,
                restaurantNames,
                stateIds,
                stateDescs;


        RestaurantTypeClient restaurantTypeClient = restaurantTypeClientList.get(0);
            try {
                SourceResponse sourceResponse = restaurantTypeClient.getRestaurant(restaurantId);
                rids = sourceResponse.getRid();
                restaurantTypes = sourceResponse.getRestaurantType();
                typeDescs = sourceResponse.getTypeDesc();
                countries = sourceResponse.getCountry();
                restaurantNames = sourceResponse.getRestaurantName();
                stateIds = sourceResponse.getStateId();
                stateDescs = sourceResponse.getStateDesc();

            } catch (IOException io) {
                LOG.error(io.getMessage());
                throw io;
            }

        return new GetRestaurantTypeResponse(Integer.valueOf(rids), restaurantTypes, typeDescs, "1.0", countries, restaurantNames, Integer.valueOf(stateIds), stateDescs);
    }
}
