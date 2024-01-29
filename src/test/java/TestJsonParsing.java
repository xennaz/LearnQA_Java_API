
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;


public class TestJsonParsing {
@Test
    public void TestJsonParsing1(){
    JsonPath response = RestAssured
            .get("https://playground.learnqa.ru/api/get_json_homework")
            .jsonPath();
    response.prettyPrint();
    String result = response.getString("messages[1]");
    System.out.println("\nOutput");
   System.out.println(result);





}
}
