package ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends BasePage {

    @FindBy(xpath = "//div[@class='header-top-auth-block']/span")
    private WebElement userName;

    @FindBy(id = "inputString")
    private WebElement openSearchFrame;

    public void clickSearch() {
        openSearchFrame.click();
    }

    public String getUserName(){
        return userName.getText();
    }
}
