package ui;

import org.junit.Assert;
import org.junit.Test;
import ui.page.AuthorizedHomePage;
import ui.page.LoginPage;
import ui.step.LoginPageStep;
import ui.utils.Random;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithEmptyCredentials() {
        String expectedErrorMessage = "Неправильно заполнены поля E-Mail и/или пароль!";
        AuthorizedHomePage authorizedHomePage = new LoginPageStep().typeLoginFormFields(Random.generateRandomSting(), Random.generateRandomSting())
                .clearUserEmail()
                .clearPassword()
                .clickLogin();
        Assert.assertEquals(expectedErrorMessage, LoginPage.getMessageIncorrectUserNameOrPassword());
    }

    @Test
    public void testLoginFormWithIncorrectCredentials() {
        String expectedErrorMessage = "Неправильно заполнены поля E-Mail и/или пароль!";
        AuthorizedHomePage authorizedHomePage = new LoginPageStep().typeLoginFormFields(Random.generateRandomSting(), Random.generateRandomSting())
                .clickLogin();
        Assert.assertEquals(expectedErrorMessage, LoginPage.getMessageIncorrectUserNameOrPassword());
    }

    @Test
    public void testLoginFormWithCorrectCredentials() {
        String userName = "Tester";
        String email = "test@dispostable.com";
        String password = "Test12345";
        AuthorizedHomePage authorizedHomePage = new LoginPageStep().typeLoginFormFields(email, password)
                .clickLogin();
        Assert.assertEquals(userName.toUpperCase(), authorizedHomePage.getUserName());
    }
}
