package http.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Login extends BaseRequest {

    public static Response postLogin(Map<String, String> payload){
        return given()
                .contentType(ContentType.URLENC)
                .header("Referer", baseUrl)
                .formParams(payload)
                .when()
                .post(baseUrl + "index.cgi");
    }
}
