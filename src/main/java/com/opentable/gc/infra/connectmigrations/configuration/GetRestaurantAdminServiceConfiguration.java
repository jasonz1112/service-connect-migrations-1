package com.opentable.gc.infra.connectmigrations.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.config.RestaurantAdminServiceSourceClientConfiguration;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminService;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminServiceImpl;

@Import({
        RestaurantAdminServiceSourceClientConfiguration.class
})
@Configuration
public class GetRestaurantAdminServiceConfiguration {

    @Bean("agg1")
    public GetRestaurantAdminService getRestaurantService(@Qualifier("rasRestaurantTypeSourceClient") RestaurantAdminServiceClient rasClient) {
        return new GetRestaurantAdminServiceImpl(rasClient);
    }


}
