import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Token {
   @Test
    public  void Token1()  {
       JsonPath response = RestAssured

               .get("https://playground.learnqa.ru/ajax/api/longtime_job")
               .jsonPath();
       response.prettyPrint();

       String responseToken = response.getString("token");

       Map<String, String> token = new HashMap<>();
       token.put("token", responseToken);

       JsonPath responseForJobIsNotReady = RestAssured
               .given()
               .queryParams(token)
               .when()
               .get("https://playground.learnqa.ru/ajax/api/longtime_job")
               .jsonPath();

       responseForJobIsNotReady.prettyPrint();



       String responseStatus1 = responseForJobIsNotReady.getString("status");
       System.out.println(responseStatus1);
       String check = "Job is NOT ready";
       if (responseStatus1.equals(check)) {
           System.out.println("status is ok");
       }
       else{
           System.out.println("status is not ok");
       }
   }

    @Test
    public  void Token2() throws InterruptedException {

        JsonPath response = RestAssured

                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        Thread.sleep(20000);
        response.prettyPrint();

        String responseToken = response.getString("token");

        Map<String, String> token = new HashMap<>();
        token.put("token", responseToken);

       JsonPath responseForJobIsReady = RestAssured
               .given()
               .queryParams(token)
               .when()
               .get("https://playground.learnqa.ru/ajax/api/longtime_job")
               .jsonPath();

       responseForJobIsReady.prettyPrint();


       String responseStatus2 = responseForJobIsReady.getString("status");
       System.out.println(responseStatus2);
       String check2 = "Job is ready";
        if (responseStatus2.equals(check2)) {
            System.out.println("status is ok");
        }
        else{
            System.out.println("status is not ok");
        }
       String responseResult = responseForJobIsReady.get("result");
       if (responseResult != null) {
           System.out.println("Result is ok");
       }


   }
}



