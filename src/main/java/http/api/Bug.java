package http.api;

import http.payloads.request.BugPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Bug extends BaseRequest {

    public static Response postBug(BugPayload payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(baseUrl + "rest/bug?login=admin@bugzilla.org&password=password");
    }

}
