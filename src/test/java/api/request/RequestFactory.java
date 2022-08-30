package api.request;

import api.client.RestClient;
import io.restassured.response.Response;
import model.UserRequest;
import utils.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class RequestFactory {
    RestClient restClient;

    public RequestFactory() {
        restClient = new RestClient();
    }

    public Response doLogin(Object payloadRequest) {
        return restClient.sendPostRequest("https://www.amd.by/login/", payloadRequest);
    }

    public Response searchProduct(){
        return restClient.sendGetRequest("https://api.multisearch.io/");
    }
}
