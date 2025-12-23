package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Login Page Object Model
 * Contains locators and methods for Login page interactions
 * Follows Page Object Model pattern for test automation
 */
public class LoginPage {
    private WebDriver driver;

    // Page Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By pageTitle = By.className("login_logo");

    /**
     * Constructor to initialize the page
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verify if Login page is displayed
     * @return true if page title is visible, false otherwise
     */
    public boolean isLoginPageDisplayed() {
        return WebDriverUtils.isElementDisplayed(driver, pageTitle);
    }

    /**
     * Enter username on login page
     * @param username Username to enter
     */
    public void enterUsername(String username) {
        ExtentReportManager.getExtentTest().info("Waiting for username field to be visible");
        WebElement element = WebDriverUtils.waitForElementToBeVisible(driver, usernameField);
        ExtentReportManager.getExtentTest().info("Username field is visible. Entering username: " + username);
        element.clear();
        element.sendKeys(username);
        ExtentReportManager.getExtentTest().info("Username entered successfully");
    }

    /**
     * Enter password on login page
     * @param password Password to enter
     */
    public void enterPassword(String password) {
        ExtentReportManager.getExtentTest().info("Waiting for password field to be visible");
        WebElement element = WebDriverUtils.waitForElementToBeVisible(driver, passwordField);
        ExtentReportManager.getExtentTest().info("Password field is visible. Entering password");
        element.clear();
        element.sendKeys(password);
        ExtentReportManager.getExtentTest().info("Password entered successfully");
    }

    /**
     * Click login button
     */
    public void clickLoginButton() {
        ExtentReportManager.getExtentTest().info("Waiting for login button to be clickable");
        WebElement element = WebDriverUtils.waitForElementToBeClickable(driver, loginButton);
        ExtentReportManager.getExtentTest().info("Login button is clickable. Clicking login button");
        element.click();
        ExtentReportManager.getExtentTest().info("Login button clicked successfully");
    }

    /**
     * Perform login with username and password
     * @param username Username
     * @param password Password
     */
    public void login(String username, String password) {
        ExtentReportManager.getExtentTest().info("=== Starting Login Process ===");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        ExtentReportManager.getExtentTest().info("=== Login Process Completed ===");
    }

    /**
     * Get error message from login page
     * @return Error message text
     */
    public String getErrorMessage() {
        ExtentReportManager.getExtentTest().info("Waiting for error message to be visible");
        WebElement element = WebDriverUtils.waitForElementToBeVisible(driver, errorMessage);
        String errorText = element.getText();
        ExtentReportManager.getExtentTest().info("Error message found: " + errorText);
        return errorText;
    }
}
