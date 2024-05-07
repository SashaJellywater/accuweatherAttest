package seminar1.sem;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar1.AccuweatherAbstractTest;

import javax.swing.plaf.synth.Region;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetRegionListTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetRegionListTest - поиск объекта Region" )
    @Description("Тест GetRegionListTest - получение списка регионов")
    @Link("https://developer.accuweather.com/accuweather-location-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение List<Region>")
    @Owner("Киселева Александра")
    void getRegions(){

        List<Region> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/regions")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Region.class);

        Assertions.assertEquals(10, result.size());;
    }

}
