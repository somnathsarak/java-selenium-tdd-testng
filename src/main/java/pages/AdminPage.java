package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * OrangeHRM Admin Page Object Model
 * Contains locators and methods for OrangeHRM Admin page
 */
public class AdminPage {
    private WebDriver driver;

    // Admin Page locators
    private By adminTitle = By.xpath("//h6[text()='Admin']");
    private By userManagementLink = By.xpath("//a[@href='/web/index.php/admin/viewUserList']");
    private By jobTitleLink = By.xpath("//a[contains(@href, 'jobTitle')]");
    private By payGradeLink = By.xpath("//a[contains(@href, 'payGrade')]");
    private By employmentStatusLink = By.xpath("//a[contains(@href, 'employmentStatus')]");
    private By organizationLink = By.xpath("//a[contains(@href, 'organization')]");
    private By qualificationsLink = By.xpath("//a[contains(@href, 'qualifications')]");
    private By languagesLink = By.xpath("//a[contains(@href, 'languages')]");
    private By skillsLink = By.xpath("//a[contains(@href, 'skills')]");
    private By generalInformationLink = By.xpath("//a[contains(@href, 'general')]");
    private By systemUsersTable = By.xpath("//table[@role='grid']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAdminPageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if admin page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, adminTitle);
        ExtentReportManager.getExtentTest().info("Admin page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void navigateToUserManagement() {
        ExtentReportManager.getExtentTest().info("Navigating to user management");
        WebDriverUtils.clickElement(driver, userManagementLink);
        ExtentReportManager.getExtentTest().info("User management page opened");
    }

    public void navigateToJobTitles() {
        ExtentReportManager.getExtentTest().info("Navigating to job titles");
        WebDriverUtils.clickElement(driver, jobTitleLink);
        ExtentReportManager.getExtentTest().info("Job titles page opened");
    }

    public void navigateToPayGrades() {
        ExtentReportManager.getExtentTest().info("Navigating to pay grades");
        WebDriverUtils.clickElement(driver, payGradeLink);
        ExtentReportManager.getExtentTest().info("Pay grades page opened");
    }

    public void navigateToEmploymentStatus() {
        ExtentReportManager.getExtentTest().info("Navigating to employment status");
        WebDriverUtils.clickElement(driver, employmentStatusLink);
        ExtentReportManager.getExtentTest().info("Employment status page opened");
    }

    public void navigateToOrganization() {
        ExtentReportManager.getExtentTest().info("Navigating to organization");
        WebDriverUtils.clickElement(driver, organizationLink);
        ExtentReportManager.getExtentTest().info("Organization page opened");
    }

    public void navigateToQualifications() {
        ExtentReportManager.getExtentTest().info("Navigating to qualifications");
        WebDriverUtils.clickElement(driver, qualificationsLink);
        ExtentReportManager.getExtentTest().info("Qualifications page opened");
    }

    public void navigateToLanguages() {
        ExtentReportManager.getExtentTest().info("Navigating to languages");
        WebDriverUtils.clickElement(driver, languagesLink);
        ExtentReportManager.getExtentTest().info("Languages page opened");
    }

    public void navigateToSkills() {
        ExtentReportManager.getExtentTest().info("Navigating to skills");
        WebDriverUtils.clickElement(driver, skillsLink);
        ExtentReportManager.getExtentTest().info("Skills page opened");
    }

    public void navigateToGeneralInformation() {
        ExtentReportManager.getExtentTest().info("Navigating to general information");
        WebDriverUtils.clickElement(driver, generalInformationLink);
        ExtentReportManager.getExtentTest().info("General information page opened");
    }

    public int getSystemUsersCount() {
        ExtentReportManager.getExtentTest().info("Getting system users count");
        List<WebElement> users = driver.findElements(systemUsersTable);
        ExtentReportManager.getExtentTest().info("System users count: " + users.size());
        return users.size();
    }
}
