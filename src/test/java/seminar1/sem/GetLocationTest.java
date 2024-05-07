package seminar1.sem;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar1.AccuweatherAbstractTest;
import seminar1.LocationsAPI.TopCities.AdministrativeArea;

import java.util.List;

import static io.restassured.RestAssured.given;
@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetLocationTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetLocationTest - поиск объекта Location" )
    @Description("Тест GetLocationTest - поиск объекта Location по ключу Samara")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта Location для Samara")
    @Owner("Киселева Александра")
    void getLocation(){

        List<AdministrativeArea.Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Samara")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", AdministrativeArea.Location.class);

        Assertions.assertEquals(10, result.size());
        Assertions.assertEquals("Samara", result.get(0).getLocalizedName());
    }
}



























