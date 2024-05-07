package seminar1.sem;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminar1.AccuweatherAbstractTest;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class TenDaysTest extends AccuweatherAbstractTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 333, 15})
    @DisplayName("Тест TenDaysTest - поиск погоды за 10 дней" )
    @Description("Тест TenDaysTest - получение данных о погоде за 10 дней")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за 10 дней")
    @Owner("Киселева Александра")
    void getTenDays_shouldReturn401(int code){
        given()
                .queryParam("apikey", getApiKey())
                .pathParams("version", "v1")
                .pathParams("location", code)
                .when()
                .get(getBaseUrl() + "/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}