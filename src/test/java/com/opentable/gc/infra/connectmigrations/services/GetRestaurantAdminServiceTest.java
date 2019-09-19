package com.opentable.gc.infra.connectmigrations.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.gc.infra.connectmigrations.Main;
import com.opentable.gc.infra.connectmigrations.clients.RestaurantAdminServiceClient;
import com.opentable.gc.infra.connectmigrations.model.GetRestaurantAdminServiceResponse;
import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetRestaurantAdminServiceTest {

    @MockBean()
    private RestaurantAdminServiceClient rasClient;

    /**
     * Test for /restaurant/1 path
     */
    @Test
    public void testRestaurantPathMockClient() throws IOException {

        GetRestaurantAdminServiceResponse expectedGetRestaurantAdminServiceResponse = new GetRestaurantAdminServiceResponse(
                190624, "C", "Guest Center Restaurant", "1.0", "US", "Guest Center - Keivan Bagheri", 1, "Active");

        String responseStr = "{\"content\":{\"restaurantLocal\":{\"en-US\":{\"address1\":\"\",\"address2\":\"\",\"city\":\"san francisco\",\"state\":\"CA\",\"executiveChef\":\"\",\"crossStreet\":\"1250 WALKER AVE\",\"restaurantName\":\"Guest Center - Keivan Bagheri\",\"sortableRestaurantName\":\"\",\"isActive\":true}},\"customMessages\":{\"RestaurantDescription\":{\"en-US\":{\"messageSource\":\"\",\"version\":1,\"locked\":false,\"message\":\"Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777\"}},\"PublicTransit\":{\"en-US\":{\"version\":1,\"locked\":false}},\"Confirmation\":{\"en-US\":{\"version\":1,\"locked\":false,\"message\":\"Thank you for choosing Guest Center - Keivan Bagheri. Should your plans change, please let us know. We look forward to serving you.\"}},\"ParkingDescription\":{\"en-US\":{\"version\":1,\"locked\":false}}}},\"core\":{\"restaurant\":{\"domainName\":\"opentable.com\",\"email\":\"\",\"url\":\"\",\"facebookUrl\":\"\",\"twitterAccountName\":\"\",\"menuUrl\":\"\",\"phoneNumber\":\"\",\"restaurantFax\":\"\",\"maxAdvanceDaysId\":33,\"minCCPartySize\":20,\"minOnlineOptionId\":1,\"minPartySize\":1,\"maxLargePartyID\":20,\"neighborhoodId\":10331,\"metroAreaId\":1,\"priceBandId\":2,\"restaurantId\":190624,\"restaurantType\":\"C\",\"showThirdPartyMenu\":1,\"postCode\":\"94067\",\"countryCode\":\"US\",\"latitude\":\"37.6915030\",\"longitude\":\"-122.4582610\",\"diningStyleId\":2,\"dressCodeId\":3,\"smokingId\":0,\"acceptsWalkins\":true,\"restaurantStateId\":1,\"hasPrivateParty\":false,\"enablePrivateDining\":false,\"publishPrivateDining\":false,\"privatePartyEmail\":\"\",\"primaryLanguage\":\"en-US\",\"ccAccountStatusID\":1,\"currencyCode\":\"USD\"},\"amenities\":[\"PARK-1\"],\"foodTypes\":{\"primaryCuisineId\":\"8AFC7ADC-DE3B-439D-91F2-CE568C1A653B\",\"otherCuisines\":[]},\"restaurantFeatures\":[{\"featureSet\":\"Operations\",\"feature\":\"PermanentlyClosed\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"bar\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"counter\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"highTop\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"outdoor\",\"valueBool\":false},{\"featureSet\":\"Ticketing\",\"feature\":\"TicketingEnabled\",\"valueBool\":false},{\"featureSet\":\"Waitlist\",\"feature\":\"WaitlistV2Enabled\",\"valueBool\":false}]}}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        RasResponse rasResponse = objectMapper.readValue(responseStr, RasResponse.class);
        GetRestaurantAdminService getRestaurantAdminService = new GetRestaurantAdminServiceImpl(rasClient);
        Mockito.when(rasClient.getRestaurant("1")).thenReturn(rasResponse);
        GetRestaurantAdminServiceResponse actualResponse = getRestaurantAdminService.getGetRestaurantResponse("1");
        assertThat(actualResponse).isEqualTo(expectedGetRestaurantAdminServiceResponse);

    }
}
