import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetHeader {

    @Test

    public void GetHeader1(){

        Response GetAllHeaders = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = GetAllHeaders.getHeaders();

        System.out.println("\nHeaders:");
        System.out.println(headers);


        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' header");

    }
}
