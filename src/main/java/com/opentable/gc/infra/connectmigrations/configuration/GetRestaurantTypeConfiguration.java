package com.opentable.gc.infra.connectmigrations.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.config.RestaurantTypeSourceClientConfiguration;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantTypeService;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantTypeServiceImpl;

@Import({
        RestaurantTypeSourceClientConfiguration.class
})
@Configuration
public class GetRestaurantTypeConfiguration {

    @Bean("agg1")
    public GetRestaurantTypeService getRestaurantAggregatorService(@Qualifier("venueRestaurantTypeSourceClient") RestaurantTypeClient venueClient) {
        return new GetRestaurantTypeServiceImpl(venueClient);
    }


}
