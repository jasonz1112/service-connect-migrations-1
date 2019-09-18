package com.opentable.gc.infra.connectmigrations.services;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class GetRestaurantAdminServiceImpl implements GetRestaurantAdminService {

    private final RestaurantAdminServiceClient ras;
    private static final Logger LOG = LoggerFactory.getLogger(GetRestaurantAdminServiceImpl.class);


    public GetRestaurantAdminServiceImpl(RestaurantAdminServiceClient ras) {
        this.ras = ras;
    }


    @Override
    public GetRestaurantAdminServiceResponse getGetRestaurantAggregatorResponse(String restaurantId) throws IOException {

        RestaurantAdminServiceClient restaurantAdminServiceClient = ras;
            try {
                SourceResponse rasResponse = restaurantAdminServiceClient.getRestaurant(restaurantId);

                return GetRestaurantAdminServiceResponse.GetRestaurantTypeResponseBuilder.aGetRestaurantTypeResponse()
                        .withRids(Integer.valueOf(rasResponse.getRid()))
                        .withRestaurantTypes(rasResponse.getRestaurantType())
                        .withTypeDescs(rasResponse.getTypeDesc())
                        .withCountries(rasResponse.getCountry())
                        .withRestaurantNames(rasResponse.getRestaurantName())
                        .withState(Integer.valueOf(rasResponse.getStateId()))
                        .withStateDescription(rasResponse.getStateDesc())
                        .build();

            } catch (IOException io) {
                LOG.error(io.getMessage());
                throw io;
            }
    }
}
