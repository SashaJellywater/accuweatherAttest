package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class OneHourofHourlyForecastsTest extends AccuweatherAbstractTest{
    @Test
    void testOneHourForecasts() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/forecasts/v1/hourly/1hour/294021")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        Map<String, Object> jsonData = jsonPath.get("[0]");

        Assertions.assertEquals("F", jsonPath.getString("[0].Temperature.Unit"));
        Assertions.assertTrue(jsonData.containsKey("DateTime"));
        Assertions.assertTrue(jsonData.containsKey("MobileLink"));
        Assertions.assertTrue(jsonData.containsKey("Link"));
    }
}
