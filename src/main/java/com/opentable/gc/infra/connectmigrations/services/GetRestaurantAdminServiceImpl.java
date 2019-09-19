package com.opentable.gc.infra.connectmigrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpStatusCodeException;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;
import com.opentable.gc.infra.connectmigrations.util.Converter;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;

import java.util.Optional;

@SuppressWarnings({"PMD.AvoidInstanceofChecksInCatchClause", "PMD.PreserveStackTrace"})
public class GetRestaurantAdminServiceImpl implements GetRestaurantAdminService {

    private final RestaurantAdminServiceClient ras;
    private static final Logger LOG = LoggerFactory.getLogger(GetRestaurantAdminServiceImpl.class);


    public GetRestaurantAdminServiceImpl(RestaurantAdminServiceClient ras) {
        this.ras = ras;
    }


    @Override
    public GetRestaurantAdminServiceResponse getGetRestaurantResponse(String restaurantId) {
        try {
            RasResponse rasResponse = ras.getRestaurant(restaurantId);


            Optional<RasResponse> rasResponseOptional = Optional.ofNullable(rasResponse);

            return GetRestaurantAdminServiceResponse.GetRestaurantTypeResponseBuilder.aGetRestaurantTypeResponse()
                    .withRids(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getRestaurantId()).orElse(0))
                    .withRestaurantTypes(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getRestaurantType()).orElse(null))
                    .withTypeDescs(Converter.getTypeDescription(String.valueOf(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getRestaurantType()).orElse(null))))
                    .withCountries(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getCountryCode()).orElse(null))
                    .withRestaurantNames(rasResponseOptional.map(x -> x.getContent()).map(x -> x.getRestaurantLocal()).map(x -> x.getEnUS()).map(x -> x.getRestaurantName()).orElse(null))
                    .withState(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getRestaurantStateId()).orElse(0))
                    .withStateDescription(Converter.getStateDescription(String.valueOf(rasResponseOptional.map(x -> x.getCore()).map(x -> x.getRestaurant()).map(x -> x.getRestaurantStateId()).orElse(0))))
                    .build();

        }
        catch (HttpStatusCodeException exception) {
            LOG.error(exception.getMessage());
            throw exception;
        }

    }
}
