package com.opentable.gc.infra.connectmigrations.clients.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClientRAS;

import com.opentable.resttemplate.RestTemplateConfiguration;
import com.opentable.resttemplate.RestTemplateFactory;

@Import({
        RestTemplateConfiguration.class
})
public class ClientConfiguration {


    @Value("${restaurant.sources.ras.url}")
    private String rasUrl;

    @Value("${restaurant.sources.ras.delay}")
    private int rasRetryDelay;

    @Value("${restaurant.sources.ras.maxDelay}")
    private int rasRetryMaxDelay;

    @Value("${restaurant.sources.ras.maxRetries}")
    private int rasMaxRetries;


    public Configuration rasSourceConfiguration() {
        return new Configuration(
                rasUrl,
                rasRetryDelay,
                rasRetryMaxDelay,
                rasMaxRetries
        );
    }

    @Bean("RestaurantAdminServiceClient")
    public RestaurantAdminServiceClient rasClient(RestTemplateFactory factory) {
        return new RestaurantAdminServiceClientRAS(rasSourceConfiguration(), factory.newTemplate());
    }


}
