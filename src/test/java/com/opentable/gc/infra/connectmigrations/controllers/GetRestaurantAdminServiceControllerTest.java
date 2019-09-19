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
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;
import com.opentable.gc.infra.connectmigrations.services.GetRestaurantAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetRestaurantAdminServiceControllerTest {

    @Inject
    private TestRestTemplate testRestTemplate;

    @MockBean
    private GetRestaurantAdminService getRestaurantAdminService;

    /**
     * Test for /restaurant/rid path
     */
    @Test
    public void testRestaurantPathMockService() throws IOException {

        GetRestaurantAdminServiceResponse expectedGetRestaurantAdminServiceResponse = new GetRestaurantAdminServiceResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");

        Mockito.when(getRestaurantAdminService.getGetRestaurantResponse("1")).thenReturn(expectedGetRestaurantAdminServiceResponse);
        ResponseEntity<GetRestaurantAdminServiceResponse> actualResponse = testRestTemplate.getForEntity("/restaurants/1", GetRestaurantAdminServiceResponse.class);
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isEqualTo(expectedGetRestaurantAdminServiceResponse);
    }

    @Test
    public void testRestaurantPathNotFound404() {

        GetRestaurantAdminServiceResponse getRestaurantAdminServiceResponse = new GetRestaurantAdminServiceResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");

        Mockito.when(getRestaurantAdminService.getGetRestaurantResponse("1")).thenReturn(getRestaurantAdminServiceResponse);

        ResponseEntity<GetRestaurantAdminServiceResponse> actualResponse = testRestTemplate.getForEntity("/restaurants/", GetRestaurantAdminServiceResponse.class);
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }


}
