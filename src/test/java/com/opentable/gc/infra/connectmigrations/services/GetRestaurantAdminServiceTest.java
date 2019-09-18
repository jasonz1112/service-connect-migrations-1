package com.opentable.gc.infra.connectmigrations.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.gc.infra.connectmigrations.Main;
import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetRestaurantAdminServiceTest {


    @MockBean(name = "rasClient")
    private RestaurantAdminServiceClient rasClient;


    /**
     * Test for /restaurant/1 path
     */
    @Test
    public void testRestaurantPathMockClient() throws IOException {

        GetRestaurantAdminServiceResponse expectedGetRestaurantAdminServiceResponse = new GetRestaurantAdminServiceResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");
        SourceResponse sourceResponseRAS = new SourceResponse("190624", "C", "Guest Center Restaurant", "US", "Guest Center - Keivan Bagheri", "1", "Active");
        GetRestaurantAdminService getRestaurantAdminService = new GetRestaurantAdminServiceImpl(rasClient);
        Mockito.when(rasClient.getRestaurant("1")).thenReturn(sourceResponseRAS);
        GetRestaurantAdminServiceResponse actualResponse = getRestaurantAdminService.getGetRestaurantAggregatorResponse("1");
        assertThat(actualResponse).isEqualTo(expectedGetRestaurantAdminServiceResponse);
    }
}
