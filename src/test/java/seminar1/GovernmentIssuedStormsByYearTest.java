package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class GovernmentIssuedStormsByYearTest extends AccuweatherAbstractTest{
    @Test
    @Owner("Киселева Александра")
    void testStormErrorResponses() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/tropical/v1/gov/storms/2023")
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
