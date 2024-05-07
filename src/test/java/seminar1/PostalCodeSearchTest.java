package seminar1;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar1.LocationsAPI.TopCities.AdministrativeArea;
import seminar1.LocationsAPI.TopCities.PostalCodeSearch;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class PostalCodeSearchTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест PostalCodeSearchTest - поиск объекта Location" )
    @Description("Тест PostalCodeSearchTest - поиск объекта Location по ключу 101000")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта Location для 101000")
    @Owner("Киселева Александра")
    void FindCitiesForPostalCode() {
        List<PostalCodeSearch> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "101000")
                .when()
                .get(getBaseUrl() + "/locations/v1/postalcodes/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".",PostalCodeSearch.class);
        boolean cityCountryFound = false;
        String expectedCityName = "Moscow";
        String expectedCountryID = "RU";
        String postalCodeToSearch = "101000";

        for (PostalCodeSearch cityData : result) {
            if (cityData.getPrimaryPostalCode().equals(postalCodeToSearch)) {
                Assertions.assertEquals(expectedCityName, cityData.getAdministrativeArea().getEnglishName(), "City name mismatch");
                Assertions.assertEquals(expectedCountryID, cityData.getCountry().getId(), "Country ID mismatch");
                cityCountryFound = true;
                break;
            }
        }
    }
}
