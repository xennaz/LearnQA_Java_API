import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

public class TestGet {
    @Test
    public void TestGetText(){
        Response response1 = RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();
        response1.print();

    }
}
