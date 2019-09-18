package com.opentable.gc.infra.connectmigrations.services;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;
import com.opentable.gc.infra.connectmigrations.util.Converter;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class GetRestaurantAdminServiceImpl implements GetRestaurantAdminService {

    private final RestaurantAdminServiceClient ras;
    private static final Logger LOG = LoggerFactory.getLogger(GetRestaurantAdminServiceImpl.class);


    public GetRestaurantAdminServiceImpl(RestaurantAdminServiceClient ras) {
        this.ras = ras;
    }


    @Override
    public GetRestaurantAdminServiceResponse getGetRestaurantResponse(String restaurantId) throws IOException {

        RestaurantAdminServiceClient restaurantAdminServiceClient = ras;
            try {
                RasResponse rasResponse = restaurantAdminServiceClient.getRestaurant(restaurantId);

                return GetRestaurantAdminServiceResponse.GetRestaurantTypeResponseBuilder.aGetRestaurantTypeResponse()
                        .withRids(rasResponse.getCore().getRestaurant().getRestaurantId())
                        .withRestaurantTypes(rasResponse.getCore().getRestaurant().getRestaurantType())
                        .withTypeDescs(Converter.getTypeDescription(String.valueOf(rasResponse.getCore().getRestaurant().getRestaurantType())))
                        .withCountries(rasResponse.getCore().getRestaurant().getCountryCode())
                        .withRestaurantNames(rasResponse.getContent().getRestaurantLocal().getEnUS().getRestaurantName())
                        .withState(rasResponse.getCore().getRestaurant().getRestaurantStateId())
                        .withStateDescription(Converter.getStateDescription(String.valueOf(rasResponse.getCore().getRestaurant().getRestaurantStateId())))
                        .build();

            } catch (IOException io) {
                LOG.error(io.getMessage());
                throw io;
            }
    }
}
