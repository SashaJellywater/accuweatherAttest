package seminar1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class FiveteenDaysofDailyForecastsTest extends AccuweatherAbstractTest{

    @Test
    void testErrorMessage() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/15day294021")
                .then()
                .statusCode(401) // Предположим, что ошибка авторизации возвращает статус 401
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        String errorMessage = jsonPath.getString("Message");

        Assertions.assertEquals("Api Authorization failed", errorMessage);
    }

   @Test
    void GetFiveteenDayReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .pathParams("version", "v1")
                .pathParams("location", 294021)
                .when()
                .get(getBaseUrl() + "/forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401);
    }
}
