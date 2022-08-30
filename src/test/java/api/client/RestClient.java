package api.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.SearchRequest;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient {

    public Response sendPostRequest(String uri, Object requestPayload) {
        return given().contentType(ContentType.JSON).when().body(requestPayload).post(uri);
    }

    public Response sendGetRequest(String uri) {
        SearchRequest searchRequest = new SearchRequest();
        return given().contentType(ContentType.JSON)
                .log().all()
                .when()
                .queryParam("id", searchRequest.getId())
                .queryParam("query", searchRequest.getQuery())
                .get(uri);
    }
}
