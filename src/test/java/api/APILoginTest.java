package api;

import api.request.RequestFactory;
import org.apache.http.HttpStatus;
import org.junit.Test;
import model.UserRequest;

import static org.hamcrest.CoreMatchers.*;

public class APILoginTest {

    RequestFactory requestFactory = new RequestFactory();

    @Test
    public void verifyLoginSuccessTest() {
        UserRequest userRequest = new UserRequest();
        requestFactory.doLogin(userRequest).then().assertThat().statusCode(equalTo(HttpStatus.SC_OK));
    }
}
