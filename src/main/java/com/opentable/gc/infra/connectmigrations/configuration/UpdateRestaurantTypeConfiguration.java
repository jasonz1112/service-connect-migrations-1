package com.opentable.gc.infra.connectmigrations.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.config.RestaurantTypeSourceClientConfiguration;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantTypeService;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantTypeServiceImpl;

@Import({
        RestaurantTypeSourceClientConfiguration.class
})
@Configuration
public class UpdateRestaurantTypeConfiguration {

    @Bean("update-agg1")
    public UpdateRestaurantTypeService updateRestaurantAggregatorService(@Qualifier("venueRestaurantTypeSourceClient") RestaurantTypeClient venueClient) {
        return new UpdateRestaurantTypeServiceImpl(venueClient);
    }


}
