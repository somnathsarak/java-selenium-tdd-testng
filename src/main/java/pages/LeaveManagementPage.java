package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * OrangeHRM Leave Management Page Object Model using PageFactory
 * Contains locators and methods for OrangeHRM Leave Management page
 */
public class LeaveManagementPage {
    private WebDriver driver;

    public LeaveManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Leave Management Page locators using @FindBy annotation
    @FindBy(xpath = "//h6[text()='Leave']")
    private WebElement leaveTitle;

    @FindBy(xpath = "//a[contains(@href, 'applyLeave')]")
    private WebElement applyLeaveLink;

    @FindBy(xpath = "//a[contains(@href, 'myLeave')]")
    private WebElement myLeaveLink;

    @FindBy(xpath = "//a[contains(@href, 'leaveType')]")
    private WebElement leaveTypeLink;

    @FindBy(xpath = "//a[contains(@href, 'leavePeriod')]")
    private WebElement leavePeriodLink;

    @FindBy(xpath = "//a[contains(@href, 'leaveEntitlement')]")
    private WebElement leaveEntitlementLink;

    @FindBy(xpath = "//a[contains(@href, 'report')]")
    private WebElement reportLeaveLink;

    @FindBy(xpath = "//select[@name='leaveType']")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//input[@name='fromDate']")
    private WebElement leaveFromDate;

    @FindBy(xpath = "//input[@name='toDate']")
    private WebElement leaveToDDate;

    @FindBy(xpath = "//textarea[@name='remarks']")
    private WebElement remarksTextarea;

    public boolean isLeavePageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if leave page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, leaveTitle);
        ExtentReportManager.getExtentTest().info("Leave page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void navigateToApplyLeave() {
        ExtentReportManager.getExtentTest().info("Navigating to apply leave");
        WebDriverUtils.clickElement(driver, applyLeaveLink);
        ExtentReportManager.getExtentTest().info("Apply leave page opened");
    }

    public void navigateToMyLeave() {
        ExtentReportManager.getExtentTest().info("Navigating to my leave");
        WebDriverUtils.clickElement(driver, myLeaveLink);
        ExtentReportManager.getExtentTest().info("My leave page opened");
    }

    public void navigateToLeaveType() {
        ExtentReportManager.getExtentTest().info("Navigating to leave type");
        WebDriverUtils.clickElement(driver, leaveTypeLink);
        ExtentReportManager.getExtentTest().info("Leave type page opened");
    }

    public void navigateToLeavePeriod() {
        ExtentReportManager.getExtentTest().info("Navigating to leave period");
        WebDriverUtils.clickElement(driver, leavePeriodLink);
        ExtentReportManager.getExtentTest().info("Leave period page opened");
    }

    public void navigateToLeaveEntitlement() {
        ExtentReportManager.getExtentTest().info("Navigating to leave entitlement");
        WebDriverUtils.clickElement(driver, leaveEntitlementLink);
        ExtentReportManager.getExtentTest().info("Leave entitlement page opened");
    }

    public void navigateToLeaveReport() {
        ExtentReportManager.getExtentTest().info("Navigating to leave report");
        WebDriverUtils.clickElement(driver, reportLeaveLink);
        ExtentReportManager.getExtentTest().info("Leave report page opened");
    }

    public void selectLeaveType(String leaveType) {
        ExtentReportManager.getExtentTest().info("Selecting leave type: " + leaveType);
        WebDriverUtils.selectByValue(driver, leaveTypeDropdown, leaveType);
        ExtentReportManager.getExtentTest().info("Leave type selected");
    }

    public void enterFromDate(String fromDate) {
        ExtentReportManager.getExtentTest().info("Entering from date: " + fromDate);
        WebDriverUtils.sendKeys(driver, leaveFromDate, fromDate);
        ExtentReportManager.getExtentTest().info("From date entered");
    }

    public void enterToDate(String toDate) {
        ExtentReportManager.getExtentTest().info("Entering to date: " + toDate);
        WebDriverUtils.sendKeys(driver, leaveToDDate, toDate);
        ExtentReportManager.getExtentTest().info("To date entered");
    }

    public void enterRemarks(String remarks) {
        ExtentReportManager.getExtentTest().info("Entering remarks: " + remarks);
        WebDriverUtils.sendKeys(driver, remarksTextarea, remarks);
        ExtentReportManager.getExtentTest().info("Remarks entered");
    }

    public WebElement getLeaveTitle() {
        return leaveTitle;
    }
}
