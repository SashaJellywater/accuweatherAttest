package seminar1;

import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class TvelveHoursofHourlyForecastsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест TvelveHoursofHourlyForecastsTest - поиск погоды на 12 часов" )
    @Description("Тест TvelveHoursofHourlyForecastsTest - получение данных о погоде на 12 часов")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды на 12 часов")
    @Owner("Киселева Александра")
    void testTvelveHoursForecasts() {
        String response = given()
                .when()
                .get(getBaseUrl() + "forecasts/v1/hourly/12hour/294021")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        List<Map<String, Object>> jsonDataList = jsonPath.getList("$");

        Assertions.assertEquals(12, jsonDataList.size());

        for (Map<String, Object> data : jsonDataList) {
            Assertions.assertTrue(data.containsKey("EpochDateTime"));
        }
    }
}
