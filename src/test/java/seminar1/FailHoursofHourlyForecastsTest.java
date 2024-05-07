package seminar1;

import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class FailHoursofHourlyForecastsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест FailHoursofHourlyForecastsTest - поиск погоды за прошедшие 120 часов" )
    @Description("Тест FailHoursofHourlyForecastsTest - получение данных о погоде за прошедшие 120 часов")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за прошедшие 120 часов")
    @Owner("Киселева Александра")
    void testErrorResponses() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/forecasts/v1/hourly/120hour/294021")
                .then()
                .statusCode(401) // Проверка кода ответа 401
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        Assertions.assertEquals("Unauthorized", jsonPath.getString("Code"));

        Assertions.assertEquals("Api Authorization failed", jsonPath.getString("Message"));
    }
}
