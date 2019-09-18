package com.opentable.gc.infra.connectmigrations.clients;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.gc.infra.connectmigrations.Main;

import com.opentable.gc.infra.connectmigrations.model.dto.get.RasResponse;
import com.opentable.gc.infra.connectmigrations.util.Converter;
import com.opentable.service.discovery.client.AnnouncementBuilder;
import com.opentable.service.discovery.client.DiscoveryClient;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RestaurantAdminServiceClientRASTest {
    @ClassRule
    public static WireMockRule mockServer = new WireMockRule(WireMockConfiguration.wireMockConfig().port(11234));
    @Autowired
    @Qualifier("rasRestaurantTypeSourceClient")
    RestaurantAdminServiceClient ras;
    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${restaurant.sources.ras.maxRetries}")
    Integer maxRetries;



    @Before
    public void setUp() throws Exception {
        discoveryClient.getAnnouncementRegistry().createAnnouncement(
                AnnouncementBuilder.announce()
                        .serviceType("restaurant-admin-service-na")
                        .statically(true)
                        .serviceUri(URI.create("http://localhost:11234/")));
    }

    /**
     * Test for ras source response extraction from mockServer response
     */
    @Test
    public void testRASClientGet() throws IOException {
        mockServer.stubFor(WireMock.get(urlEqualTo("/restaurant-admin/v2/restaurants/restaurant1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"content\":{\"restaurantLocal\":{\"en-US\":{\"address1\":\"\",\"address2\":\"\",\"city\":\"san francisco\",\"state\":\"CA\",\"executiveChef\":\"\",\"crossStreet\":\"1250 WALKER AVE\",\"restaurantName\":\"Guest Center - Keivan Bagheri\",\"sortableRestaurantName\":\"\",\"isActive\":true}},\"customMessages\":{\"RestaurantDescription\":{\"en-US\":{\"messageSource\":\"\",\"version\":1,\"locked\":false,\"message\":\"Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777\"}},\"PublicTransit\":{\"en-US\":{\"version\":1,\"locked\":false}},\"Confirmation\":{\"en-US\":{\"version\":1,\"locked\":false,\"message\":\"Thank you for choosing Guest Center - Keivan Bagheri. Should your plans change, please let us know. We look forward to serving you.\"}},\"ParkingDescription\":{\"en-US\":{\"version\":1,\"locked\":false}}}},\"core\":{\"restaurant\":{\"domainName\":\"opentable.com\",\"email\":\"\",\"url\":\"\",\"facebookUrl\":\"\",\"twitterAccountName\":\"\",\"menuUrl\":\"\",\"phoneNumber\":\"\",\"restaurantFax\":\"\",\"maxAdvanceDaysId\":33,\"minCCPartySize\":20,\"minOnlineOptionId\":1,\"minPartySize\":1,\"maxLargePartyID\":20,\"neighborhoodId\":10331,\"metroAreaId\":1,\"priceBandId\":2,\"restaurantId\":190624,\"restaurantType\":\"C\",\"showThirdPartyMenu\":1,\"postCode\":\"94067\",\"countryCode\":\"US\",\"latitude\":\"37.6915030\",\"longitude\":\"-122.4582610\",\"diningStyleId\":2,\"dressCodeId\":3,\"smokingId\":0,\"acceptsWalkins\":true,\"restaurantStateId\":1,\"hasPrivateParty\":false,\"enablePrivateDining\":false,\"publishPrivateDining\":false,\"privatePartyEmail\":\"\",\"primaryLanguage\":\"en-US\",\"ccAccountStatusID\":1,\"currencyCode\":\"USD\"},\"amenities\":[\"PARK-1\"],\"foodTypes\":{\"primaryCuisineId\":\"8AFC7ADC-DE3B-439D-91F2-CE568C1A653B\",\"otherCuisines\":[]},\"restaurantFeatures\":[{\"featureSet\":\"Operations\",\"feature\":\"PermanentlyClosed\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"bar\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"counter\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"highTop\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"outdoor\",\"valueBool\":false},{\"featureSet\":\"Ticketing\",\"feature\":\"TicketingEnabled\",\"valueBool\":false},{\"featureSet\":\"Waitlist\",\"feature\":\"WaitlistV2Enabled\",\"valueBool\":false}]}}")));


        RasResponse rasResponse = ras.getRestaurant("restaurant1");
        assertThat(rasResponse.getCore().getRestaurant().getRestaurantId()).isEqualTo(190624);
        assertThat(rasResponse.getCore().getRestaurant().getRestaurantType()).isEqualTo("C");
        assertThat(Converter.getTypeDescription(String.valueOf(rasResponse.getCore().getRestaurant().getRestaurantType()))).isEqualTo("Guest Center Restaurant");
        assertThat(rasResponse.getCore().getRestaurant().getCountryCode()).isEqualTo("US");
        assertThat(rasResponse.getContent().getRestaurantLocal().getEnUS().getRestaurantName()).isEqualTo("Guest Center - Keivan Bagheri");
        assertThat(rasResponse.getCore().getRestaurant().getRestaurantStateId()).isEqualTo(1);
        assertThat(Converter.getStateDescription(String.valueOf(rasResponse.getCore().getRestaurant().getRestaurantStateId()))).isEqualTo("Active");

    }
}