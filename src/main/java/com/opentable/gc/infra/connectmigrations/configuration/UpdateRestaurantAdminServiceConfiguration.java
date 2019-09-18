package com.opentable.gc.infra.connectmigrations.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.config.RestaurantAdminServiceSourceClientConfiguration;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantAdminService;
import com.opentable.gc.infra.connectmigrations.services.UpdateRestaurantAdminServiceImpl;

@Import({
        RestaurantAdminServiceSourceClientConfiguration.class
})
@Configuration
public class UpdateRestaurantAdminServiceConfiguration {

    @Bean("update-agg1")
    public UpdateRestaurantAdminService updateRestaurantService(@Qualifier("rasRestaurantTypeSourceClient") RestaurantAdminServiceClient rasClient) {
        return new UpdateRestaurantAdminServiceImpl(rasClient);
    }


}
