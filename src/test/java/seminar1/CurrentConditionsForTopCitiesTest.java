package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Currentconditions API")
public class CurrentConditionsForTopCitiesTest extends AccuweatherAbstractTest {
    @Test
    @Owner("Киселева Александра")
    void testLocationTemperatureTopCities() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/currentconditions/v1/topcities/50")
                .then()
                .statusCode(200) // Проверка кода ответа 200
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        Assertions.assertEquals(50, jsonPath.getList("").size());
    }
}
