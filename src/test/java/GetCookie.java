import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetCookie {

    @Test

    public void GetCookie1(){

        Response GetAllCookies = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String,String> cookies = GetAllCookies.getCookies();

        System.out.println("\nCookie:");
        System.out.println(cookies);

        assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have 'Homework' cookies");

    }
}
