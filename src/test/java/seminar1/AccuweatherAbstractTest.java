package seminar1;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AccuweatherAbstractTest {
    static Properties prop = new Properties();
    private static String apiKey;
    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException{
        InputStream configFile = new FileInputStream("src/test/resources/accuweather.properties");
        prop.load(configFile);

        apiKey = prop.getProperty("apikey");
        baseUrl = prop.getProperty("baseUrl");
    }

    public static String getApiKey() {return apiKey;}

    public static String getBaseUrl() {return baseUrl;}
}























