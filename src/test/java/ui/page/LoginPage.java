package ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "input-email")
    private WebElement inputUserEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private static WebElement messageIncorrectUsernameOrPassword;

    public LoginPage typeUserEmail(String username) {
        inputUserEmail.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clearUserEmail() {
        clearInput(inputUserEmail);
        return this;
    }

    public LoginPage clearPassword() {
        clearInput(inputPassword);
        return this;
    }

    public AuthorizedHomePage clickLogin() {
        buttonLogin.click();
        return new AuthorizedHomePage();
    }

    public static String getMessageIncorrectUserNameOrPassword() {
        return messageIncorrectUsernameOrPassword.getText();
    }
}