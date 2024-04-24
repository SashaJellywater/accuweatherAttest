package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Currentconditions API")
public class CurrentConditionsTest extends AccuweatherAbstractTest{
    @Test
    void testWeatherData() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/currentconditions/v1/294021")
                .then()
                .statusCode(200) // Проверка кода ответа 200
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        Assertions.assertEquals(true, jsonPath.get("[0].containsKey('LocalObservationDateTime')"));
        Assertions.assertEquals(true, jsonPath.get("[0].containsKey('WeatherText')"));
        Assertions.assertEquals("C", jsonPath.getString("[0].Temperature.Metric.Unit"));
        Assertions.assertTrue(jsonPath.getBoolean("[0].IsDayTime"));
    }
}
