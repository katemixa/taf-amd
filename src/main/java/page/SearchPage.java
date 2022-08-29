package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(id = "q")
    private WebElement inputMultiSearch;

    @FindBy(xpath = "//div[@class='multi-item']")
    private List<WebElement> searchResult;

    @FindBy(className = "multi-noResults")
    private WebElement noResultMessage;

    private static final By ITEM_CONTENT_LOCATOR = By.className("multi-content");

    public SearchPage typeSearchInput(String query) {
        waitForVisibilityOfElement(inputMultiSearch);
        LOGGER.info("Send text {} to text field {}", query, "search");
        inputMultiSearch.sendKeys(query);
        return this;
    }

    public boolean hasItemInResultList(String query) {
        try {
            waitForVisibilityOfAllElements(ITEM_CONTENT_LOCATOR);
            for (WebElement item : searchResult) {
                if (item.findElement(ITEM_CONTENT_LOCATOR).getText().contains(query)) {
                    LOGGER.info("Product {} found", query);
                    return true;
                }
            }
        } catch (TimeoutException e) {
            LOGGER.info("Product {} not found or wrong request", query);
        }
        return false;
    }

    public String getMessageNoResults() {
        return noResultMessage.getText();
    }
}
