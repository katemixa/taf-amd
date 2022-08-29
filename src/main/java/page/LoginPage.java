package page;

import entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    User user;

    @FindBy(id = "input-email")
    private WebElement inputUserEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private static WebElement messageIncorrectUsernameOrPassword;

    public LoginPage authorize(User user) {
        LOGGER.info("Send text {} to text field {}", user.getEmail(), "email");
        inputUserEmail.sendKeys(user.getEmail());
        LOGGER.info("Send text {} to text field {}", user.getPassword(), "password");
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    public LoginPage clearUserEmail() {
        LOGGER.info("Clear login input");
        clearInput(inputUserEmail);
        return this;
    }

    public LoginPage clearPassword() {
        LOGGER.info("Clear password input");
        clearInput(inputPassword);
        return this;
    }

    public AuthorizedHomePage clickLogin() {
        LOGGER.info("Click login button");
        buttonLogin.click();
        return new AuthorizedHomePage();
    }

    public static String getMessageIncorrectUserNameOrPassword() {
        if (messageIncorrectUsernameOrPassword.isDisplayed()) {
            LOGGER.info("Authorisation Error");
        }
        return messageIncorrectUsernameOrPassword.getText();
    }
}