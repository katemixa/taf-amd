package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.BASE_URL;
import static utils.Constants.SEARCH_URL;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='header-top-auth-block']/a[contains(text(), 'Авторизация')]")
    private WebElement buttonLogIn;

    @FindBy(id = "inputString")
    private WebElement inputSearch;

    public HomePage openPage() {
        driver.get(BASE_URL);
        LOGGER.info("open {}", BASE_URL);
        return this;
    }

    public LoginPage openPageForLogin() {
        buttonLogIn.click();
        return new LoginPage();
    }

    public SearchPage openMultiSearchFrame() {
        driver.get(SEARCH_URL);
        LOGGER.info("open {}", SEARCH_URL);
        return new SearchPage();
    }
}
