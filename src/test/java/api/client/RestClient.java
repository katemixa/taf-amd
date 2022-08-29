package api.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient {

    public Response sendPostRequest(String uri, Object requestPayload) {
        return given().contentType(ContentType.JSON).when().body(requestPayload).post(uri);
    }
}
