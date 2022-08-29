package ui.step;

import entity.User;
import io.qameta.allure.Step;
import page.HomePage;
import page.LoginPage;

public class LoginPageStep extends LoginPage {

    @Step("Type login form field")
    public LoginPage typeLoginFormFields(User user) {
        return new HomePage().openPage()
                .openPageForLogin()
                .authorize(user);
    }
}
