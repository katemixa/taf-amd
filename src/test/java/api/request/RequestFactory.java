package api.request;

import api.client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {
    RestClient restClient;

    public RequestFactory() {
        restClient = new RestClient();
    }

    public Response doLogin(Object payloadRequest) {
        return restClient.sendPostRequest("https://www.amd.by/login/", payloadRequest);
    }
}
