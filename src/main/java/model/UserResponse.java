package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

@Data
@JsonDeserialize(builder = UserResponse.UserBuilder.class)
public class UserResponse {

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {
    }
}
