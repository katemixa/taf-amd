package utils;

import entity.User;

public class UserCreator {
    public static final String USERNAME = "Tester";
    public static final String EMAIL = "test@dispostable.com";
    public static final String PASSWORD = "Test12345";

    public static User createCorrectUser() {
        return new User(EMAIL, PASSWORD, USERNAME);
    }

    public static User createIncorrectUser() {
        return new User(RandomUtils.generateRandomSting(), RandomUtils.generateRandomSting());
    }
}
