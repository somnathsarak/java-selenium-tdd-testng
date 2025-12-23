package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Utility class for common WebDriver operations
 * Provides helper methods for element interactions and waits
 */
public class WebDriverUtils {

    /**
     * Wait for element to be visible
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @param timeoutInSeconds Timeout in seconds
     * @return WebElement
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be visible (default timeout: 10 seconds)
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return WebElement
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return waitForElementToBeVisible(driver, locator, 10);
    }

    /**
     * Wait for element to be clickable
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @param timeoutInSeconds Timeout in seconds
     * @return WebElement
     */
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for element to be clickable (default timeout: 10 seconds)
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return WebElement
     */
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, 10);
    }

    /**
     * Click on element with explicit wait
     * @param driver WebDriver instance
     * @param locator By locator of the element
     */
    public static void clickElement(WebDriver driver, By locator) {
        WebElement element = waitForElementToBeClickable(driver, locator);
        element.click();
    }

    /**
     * Send keys to element with explicit wait
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @param text Text to send
     */
    public static void sendKeys(WebDriver driver, By locator, String text) {
        WebElement element = waitForElementToBeVisible(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get text from element with explicit wait
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return Text content
     */
    public static String getText(WebDriver driver, By locator) {
        WebElement element = waitForElementToBeVisible(driver, locator);
        return element.getText();
    }

    /**
     * Check if element is present in DOM
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return true if element is present, false otherwise
     */
    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if element is displayed
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return true if element is displayed, false otherwise
     */
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for page to load
     * @param driver WebDriver instance
     * @param timeoutInSeconds Timeout in seconds
     */
    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Scroll to element
     * @param driver WebDriver instance
     * @param element WebElement to scroll to
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
