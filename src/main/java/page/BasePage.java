package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static final Logger LOGGER = LogManager.getLogger();
    protected WebDriver driver;
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

    protected List<WebElement> waitForVisibilityOfAllElements(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForVisibilityOfAllElements(List<WebElement> list) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                    .visibilityOfAllElements(list));
        } catch (ElementNotInteractableException e) {
            System.out.println(e);
        }
    }

    protected void clearInput(WebElement webElement) {
        webElement.clear();
    }

    protected void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}