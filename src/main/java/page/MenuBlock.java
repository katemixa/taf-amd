package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.RandomUtils;

import java.util.List;

public class MenuBlock extends BasePage{

    WebElement menuItem;
    WebElement submenuItem;
    WebElement categoryItem;

    @FindBy(xpath="//div[contains(@class, 'item-category-view-pc main-cats category_id')]")
    private List<WebElement> mainMenuItems;

    @FindBy(xpath="//section[contains(@style,'block')]//div[@class='item-section-view-pc']")
    private List<WebElement> sectionsList;

    @FindBy(xpath="//section[contains(@style,'block')]/div[@class='item-sub-section']/a")
    private List<WebElement> categoriesList;

    private By nameCategoryLocator = By.className("name");

    public MenuBlock clickMainMenuItem(){
        menuItem = mainMenuItems.get(RandomUtils.generateRandomNumber(mainMenuItems.size()));
        LOGGER.info("Open menu {}", menuItem.getText());
        menuItem.click();
        return this;
    }

    public MenuBlock clickSubMenuItem(){
        waitForVisibilityOfAllElements(sectionsList);
        submenuItem = sectionsList.get(RandomUtils.generateRandomNumber(sectionsList.size()));
        LOGGER.info("Open submenu {}", submenuItem.getText());
        submenuItem.click();
        return this;
    }

    public CategoryPage clickCategoryItem(){
        waitForVisibilityOfAllElements(categoriesList);
        categoryItem = categoriesList.get(RandomUtils.generateRandomNumber(categoriesList.size()));
        LOGGER.info("Open category {}", categoryItem.findElement(nameCategoryLocator).getText());
        categoryItem.click();
        return new CategoryPage();
    }
}
