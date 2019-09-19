package com.opentable.gc.infra.connectmigrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.opentable.gc.infra.connectmigrations.clients.config.ClientConfiguration;
import com.opentable.gc.infra.connectmigrations.configuration.GetRestaurantServiceConfiguration;
import com.opentable.gc.infra.connectmigrations.configuration.UpdateRestaurantServiceConfiguration;
import com.opentable.gc.infra.connectmigrations.controllers.GetRestaurantAdminServiceController;
import com.opentable.gc.infra.connectmigrations.controllers.UpdateRestaurantAdminServiceController;

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
        GetRestaurantAdminServiceController.class,
        GetRestaurantServiceConfiguration.class,
        ClientConfiguration.class,
        UpdateRestaurantAdminServiceController.class,
        UpdateRestaurantServiceConfiguration.class})
public class Main {
    public static void main(final String[] args) {
        OTApplication.run(Main.class, args);
    }

    @Value("${connect.migrations.service.name}")
    private String serviceName;

    @Bean
    public ServiceInfo serviceInfo() {
        return new ServiceInfo() {
            @Override
            public String getName() {
                return serviceName;
            }
        };
    }

    @Bean
    public RestTemplate curlClient(RestTemplateFactory restTemplateFactory) {
        return restTemplateFactory.newTemplate();
    }
}
