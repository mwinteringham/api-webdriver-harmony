package http;

import http.payloads.BugPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Bug {

    private static String baseUrl = "http://52.17.197.56:8080/bugzilla/";

    public static Response postBug(BugPayload payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(baseUrl + "rest/bug?login=admin@bugzilla.org&password=password");
    }

}
