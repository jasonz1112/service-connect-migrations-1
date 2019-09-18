package com.opentable.gc.infra.connectmigrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.opentable.gc.infra.connectmigrations.clients.config.RestaurantTypeSourceClientConfiguration;
import com.opentable.gc.infra.connectmigrations.configuration.GetRestaurantTypeConfiguration;
import com.opentable.gc.infra.connectmigrations.configuration.UpdateRestaurantTypeConfiguration;
import com.opentable.gc.infra.connectmigrations.controllers.GetRestaurantTypeController;
import com.opentable.gc.infra.connectmigrations.controllers.UpdateRestaurantTypeController;

import com.opentable.resttemplate.RestTemplateConfiguration;
import com.opentable.resttemplate.RestTemplateFactory;
import com.opentable.server.OTApplication;
import com.opentable.server.mvc.MVCServer;
import com.opentable.service.ServiceInfo;
import com.opentable.service.discovery.client.EnableDiscoveryClient;

@Configuration
@MVCServer
@EnableDiscoveryClient
@Import({RestTemplateConfiguration.class,
        GetRestaurantTypeController.class,
        GetRestaurantTypeConfiguration.class,
        RestaurantTypeSourceClientConfiguration.class,
        UpdateRestaurantTypeController.class,
        UpdateRestaurantTypeConfiguration.class})
public class Main {
    public static void main(final String[] args) {
        OTApplication.run(Main.class, args);
    }

    @Bean
    public ServiceInfo serviceInfo() {
        return new ServiceInfo() {
            @Override
            public String getName() {
                return "service connect migrations for restaurants type";
            }
        };
    }

    @Bean
    public RestTemplate curlClient(RestTemplateFactory restTemplateFactory) {
        return restTemplateFactory.newTemplate();
    }
}
