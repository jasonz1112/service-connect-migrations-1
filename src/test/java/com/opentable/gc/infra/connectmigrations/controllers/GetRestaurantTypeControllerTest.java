package com.opentable.gc.infra.connectmigrations.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.opentable.gc.infra.connectmigrations.Main;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantTypeResponse;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetRestaurantTypeControllerTest {

    @Inject
    private TestRestTemplate testRestTemplate;

    @MockBean
    private GetRestaurantTypeService getRestaurantTypeService;

    /**
     * Test for /restaurant/rid path
     */
    @Test
    public void testRestaurantPathMockService() throws IOException {

        GetRestaurantTypeResponse expectedGetRestaurantTypeResponse = new GetRestaurantTypeResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");

        Mockito.when(getRestaurantTypeService.getGetRestaurantAggregatorResponse("1")).thenReturn(expectedGetRestaurantTypeResponse);
        ResponseEntity<GetRestaurantTypeResponse> actualResponse = testRestTemplate.getForEntity("/restaurants/1", GetRestaurantTypeResponse.class);
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isEqualTo(expectedGetRestaurantTypeResponse);
    }


}
