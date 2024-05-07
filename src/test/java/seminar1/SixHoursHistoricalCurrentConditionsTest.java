package seminar1;

import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class SixHoursHistoricalCurrentConditionsTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест SixHoursHistoricalCurrentConditionsTest - поиск погоды за прошедшие 6 часов" )
    @Description("Тест SixHoursHistoricalCurrentConditionsTest - получение данных о погоде за прошедшие 6 часов")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за прошедшие 6 часов")
    @Owner("Киселева Александра")
     void testResponseData() {
        String response = given()
                .when()
                .get(getBaseUrl() + "/currentconditions/v1/294021/historical")
                .then()
                .statusCode(200) // Проверка кода ответа 200
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        Assertions.assertEquals(6, jsonPath.getList("").size());
    }
}
