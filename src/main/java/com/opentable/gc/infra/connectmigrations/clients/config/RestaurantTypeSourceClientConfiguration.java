package com.opentable.gc.infra.connectmigrations.clients.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClientVenue;
import com.opentable.gc.infra.connectmigrations.clients.extractors.SourceResponseExtractorVenue;

import com.opentable.resttemplate.RestTemplateConfiguration;
import com.opentable.resttemplate.RestTemplateFactory;

@Import({
        RestTemplateConfiguration.class
})
public class RestaurantTypeSourceClientConfiguration {


    @Value("${restaurant.sources.venue.url}")
    private String venueUrl;

    @Value("${restaurant.sources.venue.delay}")
    private int venueRetryDelay;

    @Value("${restaurant.sources.venue.maxDelay}")
    private int venueRetryMaxDelay;

    @Value("${restaurant.sources.venue.maxRetries}")
    private int venueMaxRetries;


    public SourceConfiguration venueSourceConfiguration() {
        return new SourceConfiguration(
                venueUrl,
                new SourceResponseExtractorVenue(),
                venueRetryDelay,
                venueRetryMaxDelay,
                venueMaxRetries
        );
    }

    @Bean("venueRestaurantTypeSourceClient")
    public RestaurantTypeClient venueClient(RestTemplateFactory factory) {
        return new RestaurantTypeClientVenue(venueSourceConfiguration(), factory.newTemplate());
    }


}
