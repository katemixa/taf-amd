package api;

import api.request.RequestFactory;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import model.UserRequest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

public class APILoginTest {

    RequestFactory requestFactory = new RequestFactory();

    @Test
    public void verifyLoginSuccessTest() {
        UserRequest userRequest = new UserRequest();
        requestFactory.doLogin(userRequest)
                .then()
                .assertThat()
                .statusCode(equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void checkSearchResultTest() {
        requestFactory.searchProduct()
                .then()
                .assertThat()
                .statusCode(equalTo(HttpStatus.SC_OK))
                .extract()
                .body()
                .asString().contains("results");
    }
}
