package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverSingleton;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected final String BASE_URL = "https://www.amd.by/";
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected BasePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .elementToBeClickable(webElement));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .visibilityOf(webElement));
    }

    protected void clearInput(WebElement webElement){
        webElement.clear();
    }

}