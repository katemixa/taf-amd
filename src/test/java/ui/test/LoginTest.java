package ui.test;

import org.junit.Assert;
import org.junit.Test;
import entity.User;
import page.AuthorizedHomePage;
import page.LoginPage;
import ui.step.LoginPageStep;
import utils.UserCreator;

import static utils.Constants.EXPECTED_ERROR_LOGIN_MESSAGE;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithEmptyCredentials() {
        User user = UserCreator.createIncorrectUser();
        new LoginPageStep().typeLoginFormFields(user)
                .clearUserEmail()
                .clearPassword()
                .clickLogin();
        Assert.assertEquals(EXPECTED_ERROR_LOGIN_MESSAGE, LoginPage.getMessageIncorrectUserNameOrPassword());
    }

    @Test
    public void testLoginFormWithIncorrectCredentials() {
        User user = UserCreator.createIncorrectUser();
        new LoginPageStep().typeLoginFormFields(user)
                .clickLogin();
        Assert.assertEquals(EXPECTED_ERROR_LOGIN_MESSAGE, LoginPage.getMessageIncorrectUserNameOrPassword());
    }

    @Test
    public void testLoginFormWithCorrectCredentials() {
        User user = UserCreator.createCorrectUser();
        AuthorizedHomePage authorizedHomePage = new LoginPageStep().typeLoginFormFields(user)
                .clickLogin();
        Assert.assertEquals(user.getUsername().toUpperCase(), authorizedHomePage.getUserName());
    }
}
