package tests;

import base.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Login Test with Wait Logs
 * Demonstrates TDD approach with POM and ExtentReports with detailed wait logs
 */
public class LoginTestWithWaitLogs extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Initialize ExtentReports
        ExtentReportManager.initializeExtentReports();
        ExtentReportManager.createTest("Login Test With Wait Logs", "Verifies login functionality with wait logs");
        
        // Initialize driver
        super.setupDriver();
        
        // Navigate to application
        ExtentReportManager.getExtentTest().info("Navigating to application URL: " + ConfigReader.getBaseURL());
        navigateTo(ConfigReader.getBaseURL());
        ExtentReportManager.getExtentTest().info("Successfully navigated to application");
        
        // Initialize page object
        loginPage = new LoginPage(driver);
    }

    /**
     * Test successful login with valid credentials
     * Includes wait logs for all operations
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSuccessfulLogin() {
        try {
            ExtentReportManager.getExtentTest().info("=== Test: Successful Login Started ===");
            
            // Verify login page is displayed
            ExtentReportManager.getExtentTest().info("Verifying login page is displayed");
            Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
            ExtentReportManager.getExtentTest().pass("Login page is displayed successfully");
            
            // Perform login
            String username = ConfigReader.getUsername();
            String password = ConfigReader.getPassword();
            loginPage.login(username, password);
            
            // Add wait for page load after login
            ExtentReportManager.getExtentTest().info("Waiting for page to load after login");
            WebDriverUtils.waitForPageLoad(driver, 15);
            ExtentReportManager.getExtentTest().info("Page loaded successfully");
            
            ExtentReportManager.getExtentTest().pass("Login test completed successfully");
            ExtentReportManager.getExtentTest().info("=== Test: Successful Login Completed ===");
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().fail("Login test failed: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Test login with invalid credentials
     * Includes wait logs and error message verification
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWithInvalidCredentials() {
        try {
            ExtentReportManager.getExtentTest().info("=== Test: Login with Invalid Credentials Started ===");
            
            // Verify login page is displayed
            Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
            
            // Try to login with invalid credentials
            ExtentReportManager.getExtentTest().info("Attempting login with invalid credentials");
            loginPage.login("invalid_user", "invalid_password");
            
            // Verify error message is displayed
            ExtentReportManager.getExtentTest().info("Verifying error message is displayed");
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(errorMessage.contains("Epic sadface"), "Error message should be displayed for invalid credentials");
            ExtentReportManager.getExtentTest().pass("Error message verified: " + errorMessage);
            
            ExtentReportManager.getExtentTest().info("=== Test: Login with Invalid Credentials Completed ===");
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().fail("Invalid credentials test failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        ExtentReportManager.getExtentTest().info("Closing browser and generating report");
        super.tearDownDriver();
        
        // Flush and close reports
        ExtentReportManager.flushExtentReports();
        ExtentReportManager.getExtentTest().info("Test execution completed. Report generated.");
    }
}
