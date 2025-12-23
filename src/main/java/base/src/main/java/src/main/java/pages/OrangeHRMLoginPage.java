package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * OrangeHRM Login Page Object Model
 * Contains locators and methods for OrangeHRM login page interactions
 * Follows Page Object Model pattern for test automation
 */
public class OrangeHRMLoginPage {
    private WebDriver driver;

    // OrangeHRM Page Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By pageTitle = By.xpath("//h5[text()='Login']");
    private By errorMessage = By.className("oxd-alert-content-text");
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");

    /**
     * Constructor to initialize the page
     * @param driver WebDriver instance
     */
    public OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verify if OrangeHRM Login page is displayed
     * @return true if page title is visible, false otherwise
     */
    public boolean isLoginPageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if OrangeHRM Login page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, pageTitle);
        if (isDisplayed) {
            ExtentReportManager.getExtentTest().info("OrangeHRM Login page is displayed");
        } else {
            ExtentReportManager.getExtentTest().warning("OrangeHRM Login page is NOT displayed");
        }
        return isDisplayed;
    }

    /**
     * Enter username on OrangeHRM login page
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
     * Enter password on OrangeHRM login page
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
        ExtentReportManager.getExtentTest().info("=== Starting OrangeHRM Login Process ===");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        ExtentReportManager.getExtentTest().info("=== OrangeHRM Login Process Completed ===");
    }

    /**
     * Verify if login was successful by checking dashboard
     * @return true if dashboard is visible, false otherwise
     */
    public boolean isLoginSuccessful() {
        ExtentReportManager.getExtentTest().info("Verifying if login was successful by checking dashboard");
        try {
            WebDriverUtils.waitForPageLoad(driver, 15);
            boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, dashboardTitle);
            if (isDisplayed) {
                ExtentReportManager.getExtentTest().pass("Login successful - Dashboard is displayed");
            } else {
                ExtentReportManager.getExtentTest().warning("Dashboard not visible after login");
            }
            return isDisplayed;
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().warning("Error checking dashboard: " + e.getMessage());
            return false;
        }
    }

    /**
     * Get error message from login page
     * @return Error message text
     */
    public String getErrorMessage() {
        ExtentReportManager.getExtentTest().info("Waiting for error message to be visible");
        try {
            WebElement element = WebDriverUtils.waitForElementToBeVisible(driver, errorMessage, 5);
            String errorText = element.getText();
            ExtentReportManager.getExtentTest().info("Error message found: " + errorText);
            return errorText;
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().info("No error message found or error occurred: " + e.getMessage());
            return "";
        }
    }
}
