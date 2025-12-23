package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * OrangeHRM Dashboard Page Object Model
 * Contains locators and methods for OrangeHRM Dashboard page
 */
public class DashboardPage {
    private WebDriver driver;

    // Dashboard Page Locators
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private By welcomeMessage = By.xpath("//p[contains(text(), 'Welcome')]");
    private By sidebarMenu = By.className("oxd-sidebar-menu");
    private By adminModule = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private By pimModule = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    private By leaveModule = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");
    private By recruitmentModule = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");
    private By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutOption = By.xpath("//a[@href='/web/index.php/auth/logout']");
    private By profileButton = By.xpath("//button[contains(text(), 'Profile')]");
    private By dashboardWidgets = By.className("oxd-grid-item");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if Dashboard is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, dashboardTitle);
        ExtentReportManager.getExtentTest().info("Dashboard displayed: " + isDisplayed);
        return isDisplayed;
    }

    public String getDashboardTitle() {
        ExtentReportManager.getExtentTest().info("Getting dashboard title");
        String title = WebDriverUtils.getText(driver, dashboardTitle);
        ExtentReportManager.getExtentTest().info("Dashboard title: " + title);
        return title;
    }

    public boolean isWelcomeMessageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if welcome message is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, welcomeMessage);
        ExtentReportManager.getExtentTest().info("Welcome message displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void navigateToAdminModule() {
        ExtentReportManager.getExtentTest().info("Navigating to Admin module");
        WebDriverUtils.clickElement(driver, adminModule);
        ExtentReportManager.getExtentTest().info("Admin module clicked");
    }

    public void navigateToPIMModule() {
        ExtentReportManager.getExtentTest().info("Navigating to PIM module");
        WebDriverUtils.clickElement(driver, pimModule);
        ExtentReportManager.getExtentTest().info("PIM module clicked");
    }

    public void navigateToLeaveModule() {
        ExtentReportManager.getExtentTest().info("Navigating to Leave module");
        WebDriverUtils.clickElement(driver, leaveModule);
        ExtentReportManager.getExtentTest().info("Leave module clicked");
    }

    public void navigateToRecruitmentModule() {
        ExtentReportManager.getExtentTest().info("Navigating to Recruitment module");
        WebDriverUtils.clickElement(driver, recruitmentModule);
        ExtentReportManager.getExtentTest().info("Recruitment module clicked");
    }

    public void logout() {
        ExtentReportManager.getExtentTest().info("Logging out from dashboard");
        WebDriverUtils.clickElement(driver, userDropdown);
        ExtentReportManager.getExtentTest().info("User dropdown clicked");
        WebDriverUtils.clickElement(driver, logoutOption);
        ExtentReportManager.getExtentTest().info("Logout option clicked");
    }

    public boolean isSidebarMenuDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if sidebar menu is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, sidebarMenu);
        ExtentReportManager.getExtentTest().info("Sidebar menu displayed: " + isDisplayed);
        return isDisplayed;
    }

    public int getDashboardWidgetCount() {
        ExtentReportManager.getExtentTest().info("Getting dashboard widget count");
        List<WebElement> widgets = driver.findElements(dashboardWidgets);
        ExtentReportManager.getExtentTest().info("Widget count: " + widgets.size());
        return widgets.size();
    }

    public void clickProfileButton() {
        ExtentReportManager.getExtentTest().info("Clicking profile button");
        WebDriverUtils.clickElement(driver, profileButton);
        ExtentReportManager.getExtentTest().info("Profile button clicked");
    }
}
