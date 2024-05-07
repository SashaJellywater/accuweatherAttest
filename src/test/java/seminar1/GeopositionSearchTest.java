package seminar1;

import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar1.LocationsAPI.TopCities.PostalCodeSearch;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GeopositionSearchTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GeopositionSearchTest - поиск объекта geoposition" )
    @Description("Тест GeopositionSearchTest - поиск объекта geoposition по ключу 55.79, 37.53")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта geoposition по ключу 55.79, 37.53")
    @Owner("Киселева Александра")
    void FindMoscowOnGeoposition() {
        String result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "55.79, 37.53")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/geoposition/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .asString();
        JsonPath jsonPath = new JsonPath(result);

        Assertions.assertEquals(jsonPath.getString("City.LocalizedName"), "Moscow");
        Assertions.assertEquals(jsonPath.getString("Country.ID"), "RU");
    }
}
