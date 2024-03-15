import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Map;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAgent {

    String device;
    String browser;
    String platform;

    @ParameterizedTest
    @CsvSource(value = {"'Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30', Android, No, Mobile",
            "'Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1',iOS, Chrome, Mobile",
            "'Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)', Unknown, Unknown, Googlebot",
            "'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0', No, Chrome, Web",
            "'Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1', iPhone, No, Mobile"})


    public void getUserAgentData(String userAgent, String device1, String browser1, String platform1) {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", userAgent);

        JsonPath response = RestAssured
                .given()
                .headers(headers)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();

        this.device = response.getJsonObject("device");
        System.out.println(device);
        this.browser = response.getString("browser");
        System.out.println(browser);
        this.platform = response.getString("platform");
        System.out.println(platform);

        assertEquals(device1, this.device, "unexpected response  " + device + "  " + headers);
        assertEquals(browser1, this.browser, "unexpected response  " + browser + " " + headers);
        assertEquals(platform1, this.platform, "unexpected response  " + platform + " " + headers);


    }


}
