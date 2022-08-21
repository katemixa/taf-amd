package ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//div[@class='multi-search multi-theme-compact']")
    private WebElement multisearchFrame;
    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputSearch;

    public SearchPage typeSearchQuery(String query) {
        waitForElementToBeClickable(inputSearch);
        inputSearch.sendKeys(query);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }
}
