package seminar1;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar1.weather.DailyForecast;
import seminar1.weather.Weather;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Weather API")
public class FiveDaysofDailyForecastsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест FiveDaysTest - поиск погоды за 5 дней" )
    @Description("Тест FiveDaysTest - получение данных о погоде за 5 дней")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за 5 дней")
    @Owner("Киселева Александра")
    void testFiveDays() {

        Weather weather = given().queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/5day/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());;
        Assertions.assertEquals("F", weather.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit());
        Assertions.assertNotNull(weather.getHeadline());
    }


    @Test
    void FiveDaysContainsParams() {
        String result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/5day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().asString();

        Assertions.assertTrue(result.contains("DailyForecasts"));
        Assertions.assertTrue(result.contains("Headline"));;
    }
}
