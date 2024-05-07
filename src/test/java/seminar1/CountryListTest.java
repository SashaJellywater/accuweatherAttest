package seminar1;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminar1.LocationsAPI.Country;

import javax.swing.plaf.synth.Region;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class CountryListTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест CountryListTest - поиск объекта List<Country>" )
    @Description("Тест CountryListTest - поиск List<Country> по ключу EUR")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение List<Country> по ключу EUR")
    @Owner("Киселева Александра")
    void checkCountryInRegion(){

        List<Country> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/countries/EUR")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Country.class);

        Assertions.assertEquals(52, result.size());
        Country russia = result.stream()
                .filter(countrysem -> "RU".equals(countrysem.getId()))
                .findAny().orElse(null);
        Assertions.assertNotNull(russia);
        Assertions.assertEquals("Russia", russia.getLocalizedName());
        Assertions.assertEquals("Russia", russia.getEnglishName());
    }
    @ParameterizedTest
    @ValueSource(strings = { "Austria", "Belgium", "France", "Latvia", "Serbia" })
    void testCheckSpecificCountries(String countryName) {
        List<Country> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/countries/EUR")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Country.class);

        boolean countryExists = result.stream()
                .anyMatch(countrysem -> countryName.equals(countrysem.getLocalizedName()));

        Assertions.assertTrue(countryExists, countryName + " not found in the response.");
    }
}
