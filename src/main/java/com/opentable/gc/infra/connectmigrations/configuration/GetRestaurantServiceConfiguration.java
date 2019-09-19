package com.opentable.gc.infra.connectmigrations.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.config.ClientConfiguration;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminService;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminServiceImpl;

@Import({
        ClientConfiguration.class
})
@Configuration
public class GetRestaurantServiceConfiguration {

    @Bean("get-bean")
    public GetRestaurantAdminService getRestaurantService(@Qualifier("RestaurantAdminServiceClient") RestaurantAdminServiceClient rasClient) {
        return new GetRestaurantAdminServiceImpl(rasClient);
    }


}
