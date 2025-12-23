package tests;

import base.*;
import pages.OrangeHRMLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * OrangeHRM Login Test Suite
 * Tests the login functionality of OrangeHRM application
 * Demonstrates TDD approach with POM and ExtentReports
 */
public class OrangeHRMLoginTest extends BaseTest {
    private OrangeHRMLoginPage orangeHRMLoginPage;

    @BeforeClass
    public void setUp() {
        // Initialize ExtentReports
        ExtentReportManager.initializeExtentReports();
        ExtentReportManager.createTest("OrangeHRM Login Test Suite", "Tests OrangeHRM login functionality with detailed wait logs");
        
        // Initialize driver
        super.setupDriver();
        
        // Navigate to OrangeHRM application
        ExtentReportManager.getExtentTest().info("Navigating to OrangeHRM URL: " + ConfigReader.getBaseURL());
        navigateTo(ConfigReader.getBaseURL());
        ExtentReportManager.getExtentTest().info("Successfully navigated to OrangeHRM");
        
        // Initialize page object
        orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
    }

    /**
     * Test successful login with valid admin credentials
     */
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void testSuccessfulAdminLogin() {
        try {
            ExtentReportManager.getExtentTest().info("=== Test: Successful Admin Login Started ===");
            
            // Verify login page is displayed
            ExtentReportManager.getExtentTest().info("Verifying OrangeHRM Login page is displayed");
            Assert.assertTrue(orangeHRMLoginPage.isLoginPageDisplayed(), "OrangeHRM Login page should be displayed");
            ExtentReportManager.getExtentTest().pass("OrangeHRM Login page is displayed successfully");
            
            // Get credentials from config
            String username = ConfigReader.getUsername();
            String password = ConfigReader.getPassword();
            
            // Perform login
            ExtentReportManager.getExtentTest().info("Performing login with credentials: " + username);
            orangeHRMLoginPage.login(username, password);
            
            // Verify login success
            ExtentReportManager.getExtentTest().info("Verifying login success by checking dashboard");
            Assert.assertTrue(orangeHRMLoginPage.isLoginSuccessful(), "Login should be successful and dashboard should be displayed");
            
            ExtentReportManager.getExtentTest().pass("Admin login test completed successfully");
            ExtentReportManager.getExtentTest().info("=== Test: Successful Admin Login Completed ===");
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().fail("Admin login test failed: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Test login with invalid credentials
     */
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWithInvalidCredentials() {
        try {
            ExtentReportManager.getExtentTest().info("=== Test: Login with Invalid Credentials Started ===");
            
            // Verify login page is displayed
            Assert.assertTrue(orangeHRMLoginPage.isLoginPageDisplayed(), "OrangeHRM Login page should be displayed");
            
            // Try to login with invalid credentials
            ExtentReportManager.getExtentTest().info("Attempting login with invalid credentials");
            orangeHRMLoginPage.login("invalid_user", "invalid_password");
            
            // Verify error message is displayed
            ExtentReportManager.getExtentTest().info("Verifying error message is displayed");
            String errorMessage = orangeHRMLoginPage.getErrorMessage();
            Assert.assertTrue(!errorMessage.isEmpty(), "Error message should be displayed for invalid credentials");
            ExtentReportManager.getExtentTest().pass("Error message verified: " + errorMessage);
            
            ExtentReportManager.getExtentTest().info("=== Test: Login with Invalid Credentials Completed ===");
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().fail("Invalid credentials test failed: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Test login with empty credentials
     */
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWithEmptyCredentials() {
        try {
            ExtentReportManager.getExtentTest().info("=== Test: Login with Empty Credentials Started ===");
            
            // Verify login page is displayed
            Assert.assertTrue(orangeHRMLoginPage.isLoginPageDisplayed(), "OrangeHRM Login page should be displayed");
            
            // Try to login with empty credentials
            ExtentReportManager.getExtentTest().info("Attempting login with empty credentials");
            orangeHRMLoginPage.clickLoginButton();
            
            // Verify error message
            ExtentReportManager.getExtentTest().info("Verifying validation error message");
            String errorMessage = orangeHRMLoginPage.getErrorMessage();
            Assert.assertTrue(!errorMessage.isEmpty(), "Validation error should be displayed");
            ExtentReportManager.getExtentTest().pass("Validation error verified: " + errorMessage);
            
            ExtentReportManager.getExtentTest().info("=== Test: Login with Empty Credentials Completed ===");
        } catch (Exception e) {
            ExtentReportManager.getExtentTest().fail("Empty credentials test failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        ExtentReportManager.getExtentTest().info("Closing browser and generating report");
        super.tearDownDriver();
        
        // Flush and close reports
        ExtentReportManager.flushExtentReports();
        ExtentReportManager.getExtentTest().info("OrangeHRM test execution completed. Report generated.");
    }
}
