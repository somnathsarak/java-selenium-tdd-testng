package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * OrangeHRM Dashboard Page Object Model using PageFactory
 * Contains locators and methods for OrangeHRM Dashboard page
 */
public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Dashboard Page locators using @FindBy annotation
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//div[@class='oxd-sidepanel-body']")
    private WebElement sidebarMenu;

    @FindBy(xpath = "//div[@class='oxd-grid-item'][contains(.,'Employees on Leave Today')]")
    private WebElement employeeOnLeaveWidget;

    @FindBy(xpath = "//div[@class='oxd-grid-item'][contains(.,'Work Anniversaries')]")
    private WebElement workAnniversaryWidget;

    @FindBy(xpath = "//div[@class='oxd-grid-item'][contains(.,'Upcoming Holidays')]")
    private WebElement upcomingHolidaysWidget;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-icon-button--solid-main' and @type='button']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutOption;

    @FindBy(xpath = "//div[@class='oxd-layout-context']//div[@class='oxd-grid-item']")
    private List<WebElement> dashboardWidgets;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-icon-button--solid-main' and @title='View Profile']")
    private WebElement profileButton;

    public boolean isDashboardPageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if dashboard page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, dashboardTitle);
        ExtentReportManager.getExtentTest().info("Dashboard page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public boolean isSidebarMenuDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if sidebar menu is displayed");
        return WebDriverUtils.isElementDisplayed(driver, sidebarMenu);
    }

    public boolean isQuickLaunchDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if quick launch is displayed");
        return dashboardWidgets.size() > 0;
    }

    public boolean isEmployeeOnLeaveDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if employee on leave widget is displayed");
        return WebDriverUtils.isElementDisplayed(driver, employeeOnLeaveWidget);
    }

    public boolean isWorkAnniversaryDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if work anniversary widget is displayed");
        return WebDriverUtils.isElementDisplayed(driver, workAnniversaryWidget);
    }

    public void clickUserDropdown() {
        ExtentReportManager.getExtentTest().info("Clicking user dropdown");
        WebDriverUtils.clickElement(driver, userDropdown);
        ExtentReportManager.getExtentTest().info("User dropdown opened");
    }

    public boolean isUserDropdownDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if user dropdown is displayed");
        return WebDriverUtils.isElementDisplayed(driver, logoutOption);
    }

    public void clickLogoutOption() {
        ExtentReportManager.getExtentTest().info("Clicking logout option");
        WebDriverUtils.clickElement(driver, logoutOption);
        ExtentReportManager.getExtentTest().info("Logged out successfully");
    }

    public int getDashboardWidgetCount() {
        ExtentReportManager.getExtentTest().info("Getting dashboard widget count");
        int count = dashboardWidgets.size();
        ExtentReportManager.getExtentTest().info("Dashboard widgets count: " + count);
        return count;
    }

    public boolean isProfileButtonDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if profile button is displayed");
        return WebDriverUtils.isElementDisplayed(driver, profileButton);
    }
}
