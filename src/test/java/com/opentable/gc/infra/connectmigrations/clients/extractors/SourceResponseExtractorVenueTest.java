package com.opentable.gc.infra.connectmigrations.clients.extractors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.opentable.gc.infra.connectmigrations.Main;
import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SourceResponseExtractorVenueTest {

    /**
     * Test for venue source response extraction
     */
    @Test
    public void testVenueSourceResponseExtractor() throws IOException {
        String testValidResponse = "{\"content\":{\"restaurantLocal\":{\"en-US\":{\"address1\":\"\",\"address2\":\"\",\"city\":\"san francisco\",\"state\":\"CA\",\"executiveChef\":\"\",\"crossStreet\":\"1250 WALKER AVE\",\"restaurantName\":\"Guest Center - Keivan Bagheri\",\"sortableRestaurantName\":\"\",\"isActive\":true}},\"customMessages\":{\"RestaurantDescription\":{\"en-US\":{\"messageSource\":\"\",\"version\":1,\"locked\":false,\"message\":\"Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777\"}},\"PublicTransit\":{\"en-US\":{\"version\":1,\"locked\":false}},\"Confirmation\":{\"en-US\":{\"version\":1,\"locked\":false,\"message\":\"Thank you for choosing Guest Center - Keivan Bagheri. Should your plans change, please let us know. We look forward to serving you.\"}},\"ParkingDescription\":{\"en-US\":{\"version\":1,\"locked\":false}}}},\"core\":{\"restaurant\":{\"domainName\":\"opentable.com\",\"email\":\"\",\"url\":\"\",\"facebookUrl\":\"\",\"twitterAccountName\":\"\",\"menuUrl\":\"\",\"phoneNumber\":\"\",\"restaurantFax\":\"\",\"maxAdvanceDaysId\":33,\"minCCPartySize\":20,\"minOnlineOptionId\":1,\"minPartySize\":1,\"maxLargePartyID\":20,\"neighborhoodId\":10331,\"metroAreaId\":1,\"priceBandId\":2,\"restaurantId\":190624,\"restaurantType\":\"C\",\"showThirdPartyMenu\":1,\"postCode\":\"94067\",\"countryCode\":\"US\",\"latitude\":\"37.6915030\",\"longitude\":\"-122.4582610\",\"diningStyleId\":2,\"dressCodeId\":3,\"smokingId\":0,\"acceptsWalkins\":true,\"restaurantStateId\":1,\"hasPrivateParty\":false,\"enablePrivateDining\":false,\"publishPrivateDining\":false,\"privatePartyEmail\":\"\",\"primaryLanguage\":\"en-US\",\"ccAccountStatusID\":1,\"currencyCode\":\"USD\"},\"amenities\":[\"PARK-1\"],\"foodTypes\":{\"primaryCuisineId\":\"8AFC7ADC-DE3B-439D-91F2-CE568C1A653B\",\"otherCuisines\":[]},\"restaurantFeatures\":[{\"featureSet\":\"Operations\",\"feature\":\"PermanentlyClosed\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"bar\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"counter\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"highTop\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"outdoor\",\"valueBool\":false},{\"featureSet\":\"Ticketing\",\"feature\":\"TicketingEnabled\",\"valueBool\":false},{\"featureSet\":\"Waitlist\",\"feature\":\"WaitlistV2Enabled\",\"valueBool\":false}]}}";

        SourceResponseExtractorVenue sourceResponseExtractorVenue = new SourceResponseExtractorVenue();

        SourceResponse sr = sourceResponseExtractorVenue.extract(testValidResponse);
        assertThat(sr.getRid()).isEqualTo("190624");
        assertThat(sr.getRestaurantType()).isEqualTo("C");
        assertThat(sr.getTypeDesc()).isEqualTo("Guest Center Restaurant");
        assertThat(sr.getCountry()).isEqualTo("US");
        assertThat(sr.getRestaurantName()).isEqualTo("Guest Center - Keivan Bagheri");
        assertThat(sr.getStateId()).isEqualTo("1");
        assertThat(sr.getStateDesc()).isEqualTo("Active");
    }

    /**
     * Test for guestShare source response extraction
     */
    @Test
    public void testVenueSourceResponseExtractorInvalidResponse() {
        String testValidResponse = "{\"content\"{\"restaurantLocal\":{\"en-US\":{\"address1\":\"\",\"address2\":\"\",\"city\":\"san francisco\",\"state\":\"CA\",\"executiveChef\":\"\",\"crossStreet\":\"1250 WALKER AVE\",\"restaurantName\":\"Guest Center - Keivan Bagheri\",\"sortableRestaurantName\":\"\",\"isActive\":true}},\"customMessages\":{\"RestaurantDescription\":{\"en-US\":{\"messageSource\":\"\",\"version\":1,\"locked\":false,\"message\":\"Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777Coming Soon 12345777\"}},\"PublicTransit\":{\"en-US\":{\"version\":1,\"locked\":false}},\"Confirmation\":{\"en-US\":{\"version\":1,\"locked\":false,\"message\":\"Thank you for choosing Guest Center - Keivan Bagheri. Should your plans change, please let us know. We look forward to serving you.\"}},\"ParkingDescription\":{\"en-US\":{\"version\":1,\"locked\":false}}}},\"core\":{\"restaurant\":{\"domainName\":\"opentable.com\",\"email\":\"\",\"url\":\"\",\"facebookUrl\":\"\",\"twitterAccountName\":\"\",\"menuUrl\":\"\",\"phoneNumber\":\"\",\"restaurantFax\":\"\",\"maxAdvanceDaysId\":33,\"minCCPartySize\":20,\"minOnlineOptionId\":1,\"minPartySize\":1,\"maxLargePartyID\":20,\"neighborhoodId\":10331,\"metroAreaId\":1,\"priceBandId\":2,\"restaurantId\":190624,\"restaurantType\":\"C\",\"showThirdPartyMenu\":1,\"postCode\":\"94067\",\"countryCode\":\"US\",\"latitude\":\"37.6915030\",\"longitude\":\"-122.4582610\",\"diningStyleId\":2,\"dressCodeId\":3,\"smokingId\":0,\"acceptsWalkins\":true,\"restaurantStateId\":1,\"hasPrivateParty\":false,\"enablePrivateDining\":false,\"publishPrivateDining\":false,\"privatePartyEmail\":\"\",\"primaryLanguage\":\"en-US\",\"ccAccountStatusID\":1,\"currencyCode\":\"USD\"},\"amenities\":[\"PARK-1\"],\"foodTypes\":{\"primaryCuisineId\":\"8AFC7ADC-DE3B-439D-91F2-CE568C1A653B\",\"otherCuisines\":[]},\"restaurantFeatures\":[{\"featureSet\":\"Operations\",\"feature\":\"PermanentlyClosed\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"bar\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"counter\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"highTop\",\"valueBool\":false},{\"featureSet\":\"TableCategories\",\"feature\":\"outdoor\",\"valueBool\":false},{\"featureSet\":\"Ticketing\",\"feature\":\"TicketingEnabled\",\"valueBool\":false},{\"featureSet\":\"Waitlist\",\"feature\":\"WaitlistV2Enabled\",\"valueBool\":false}]}}";

        SourceResponseExtractor sourceResponseExtractorVenue = new SourceResponseExtractorVenue();

        try {
            SourceResponse sr = sourceResponseExtractorVenue.extract(testValidResponse);
            fail("SourceResponseExtractorVenue failed to throw exception on invalid JSON");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IOException.class);
        }
    }


}
