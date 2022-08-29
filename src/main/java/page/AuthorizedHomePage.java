package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends BasePage {

    @FindBy(xpath = "//div[@class='header-top-auth-block']/span")
    private WebElement userName;

    public String getUserName() {
        return userName.getText();
    }
}
