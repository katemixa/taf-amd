package model;

import lombok.Data;

import static utils.UserCreator.*;

@Data
public class UserRequest {
    String email;
    String password;

    public UserRequest() {
        setEmail(EMAIL);
        setPassword(PASSWORD);
    }
}
