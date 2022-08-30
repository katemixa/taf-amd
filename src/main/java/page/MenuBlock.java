package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.RandomUtils;

import java.util.List;

public class MenuBlock extends BasePage {

    WebElement menuItem;
    WebElement submenuItem;
    WebElement categoryItem;

//    @FindBy(xpath = "//div[@class='item-category-block-view-pc']")
//    private WebElement MenuBlock;

    @FindBy(id = "Category-0")
    private WebElement firstMainMenuItems;

    @FindBy(xpath = "//section[contains(@style,'block')]//div[@class='item-section-view-pc']")
    private List<WebElement> sectionsList;

    @FindBy(xpath = "//section[contains(@style,'block')]/div[@class='item-sub-section']/a")
    private List<WebElement> categoriesList;

    private static final By NAME_CATEGORY_LOCATOR = By.className("name");
  //  private static final By MENU_BLOCK_LOCATOR = By.className("item-category-block-view-pc");

    public MenuBlock clickMainMenuItem() {
        //waitForVisibilityOfAllElements(mainMenuItems);
        //menuItem = mainMenuItems.get(0);
        LOGGER.info("Open menu {}", firstMainMenuItems.getText());
        jsClick(firstMainMenuItems);
        //menuItem.click();
        return this;
    }

    public MenuBlock clickSubMenuItem() {
        waitForVisibilityOfAllElements(sectionsList);
        submenuItem = sectionsList.get(RandomUtils.generateRandomNumber(sectionsList.size()));
        LOGGER.info("Open submenu {}", submenuItem.getText());
        jsClick(submenuItem);
        return this;
    }

    public CategoryPage clickCategoryItem() {
        try {
            waitForVisibilityOfAllElements(categoriesList);
        } catch (TimeoutException e) {
            LOGGER.info("Categories not loaded. Open new submenu item");
            clickSubMenuItem();
        }
        categoryItem = categoriesList.get(RandomUtils.generateRandomNumber(categoriesList.size()));
        LOGGER.info("Open category {}", categoryItem.findElement(NAME_CATEGORY_LOCATOR).getText());
        jsClick(categoryItem);
        return new CategoryPage();
    }
}
