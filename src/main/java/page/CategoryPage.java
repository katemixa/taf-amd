package page;

import entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.RandomUtils;

import java.util.List;

public class CategoryPage extends BasePage {

    WebElement brand;
    Product product;
    int max;

    @FindBy(id = "v-m")
    private List<WebElement> brands;

    @FindBy(xpath = "//div[contains(@class,'product-layout')]//div[@class='title']/a")
    private List<WebElement> productsTitles;

    @FindBy(xpath = "//div[@class='list-group-item selected-options']")
    private WebElement selectedOptions;

    private static final By CHECKBOX_BRAND_LOCATOR = By.tagName("input");

    public CategoryPage clickBrand() {
        max = Math.min(brands.size(), 4);
        brand = brands.get(RandomUtils.generateRandomNumber(max));
        brand.findElement(CHECKBOX_BRAND_LOCATOR).click();
        LOGGER.info("Select brand {}", brand.getText());
        product = new Product(brand.getText());
        return this;
    }

    public boolean checkProductWithClickedBrand() {
        waitForVisibilityOfElement(selectedOptions);
        for (WebElement productTitle : productsTitles) {
            if (StringUtils.containsNone(product.getBrand(), productTitle.getText())) {
                LOGGER.info("Product {} don't contains brand {}", productTitle.getText(), product.getBrand());
                return false;
            }
        }
        LOGGER.info("All products contains brand {}", product.getBrand());
        return true;
    }
}
