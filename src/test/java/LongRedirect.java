import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class LongRedirect {

    @Test

    public void TestLongRedirect() {
        
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = response.getStatusCode();
        String LocationHeader = response.getHeader("Location");
        if (LocationHeader == null) {
            System.out.println(statusCode);
            System.out.println ("end of redirection");}
        else{
            System.out.println(statusCode);
            System.out.println(LocationHeader);
        }

        Response response2 = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(LocationHeader)
                .andReturn();

        int statusCode2 = response2.getStatusCode();
        String LocationHeader2 = response2.getHeader("Location");
        if (LocationHeader2 == null) {
            System.out.println(statusCode2);
            System.out.println ("end of redirection");}
        else{
            System.out.println(statusCode2);
            System.out.println(LocationHeader2);
        }

        Response response3 = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(LocationHeader2)
                .andReturn();

        int statusCode3 = response3.getStatusCode();
        String LocationHeader3 = response3.getHeader("Location");
        if (LocationHeader3 == null) {
            System.out.println(statusCode3);
            System.out.println ("end of redirection");}
        else{
            System.out.println(statusCode3);
            System.out.println(LocationHeader3);
        }

        Response response4 = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(LocationHeader3)
                .andReturn();

        int statusCode4 = response4.getStatusCode();
        String LocationHeader4 = response4.getHeader("Location");
        if (LocationHeader4 == null) {
            System.out.println(statusCode4);
            System.out.println ("end of redirection");}
        else{
            System.out.println(statusCode4);
            System.out.println(LocationHeader4);
        }


    }
}