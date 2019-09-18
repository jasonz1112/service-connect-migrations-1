package com.opentable.gc.infra.connectmigrations.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import com.google.common.collect.ImmutableSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.gc.infra.connectmigrations.Main;
import com.opentable.gc.infra.connectmigrations.clients.RestaurantTypeClient;
import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantTypeResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetRestaurantTypeServiceTest {


    @MockBean(name = "venueClient")
    private RestaurantTypeClient venueClient;


    /**
     * Test for /restaurant/1 path
     */
    @Test
    public void testRestaurantPathMockClient() throws IOException {

        GetRestaurantTypeResponse expectedGetRestaurantTypeResponse = new GetRestaurantTypeResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");
        SourceResponse sourceResponseVenue = new SourceResponse("190624", "C", "Guest Center Restaurant", "US", "Guest Center - Keivan Bagheri", "1", "Active");
        GetRestaurantTypeService getRestaurantTypeService = new GetRestaurantTypeServiceImpl(venueClient);
        Mockito.when(venueClient.getRestaurant("1")).thenReturn(sourceResponseVenue);
        GetRestaurantTypeResponse actualResponse = getRestaurantTypeService.getGetRestaurantAggregatorResponse("1");
        assertThat(actualResponse).isEqualTo(expectedGetRestaurantTypeResponse);
    }
}
