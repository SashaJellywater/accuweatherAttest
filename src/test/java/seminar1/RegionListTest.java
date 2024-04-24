package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar1.LocationsAPI.Region;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class RegionListTest extends AccuweatherAbstractTest{
        @Test
        void getRegions(){

            List<Region> result = given()
                    .queryParam("apikey", getApiKey())
                    .when()
                    .get(getBaseUrl() + "/locations/v1/regions")
                    .then()
                    .statusCode(200)
                    .time(Matchers.lessThan(2000l))
                    .extract()
                    .body().jsonPath().getList(".", Region.class);

            Assertions.assertEquals(10, result.size());;
        }
    @Test
    void testCheckEuropeRegionID() {
        List<Region> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/regions")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Region.class);

        Region europe = null;
        for (Region region : result) {
            if ("Europe".equals(region.getLocalizedName())) {
                europe = region;
                break;
            }
        }

        Assertions.assertNotNull(europe, "Europe region not found in the response.");
        Assertions.assertEquals("EUR", europe.getId(), "Expected ID for Europe region is not 'EUR'.");
    }
}
