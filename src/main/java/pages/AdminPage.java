package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * OrangeHRM Admin Page Object Model using PageFactory
 * Contains locators and methods for OrangeHRM Admin page
 */
public class AdminPage {
    private WebDriver driver;

    // Initialize PageFactory for WebElement discovery
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Admin Page locators using @FindBy annotation
    @FindBy(xpath = "//h6[text()='Admin']")
    private WebElement adminTitle;

    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewUserList']")
    private WebElement userManagementLink;

    @FindBy(xpath = "//a[contains(@href, 'jobTitle')]")
    private WebElement jobTitleLink;

    @FindBy(xpath = "//a[contains(@href, 'payGrade')]")
    private WebElement payGradeLink;

    @FindBy(xpath = "//a[contains(@href, 'employmentStatus')]")
    private WebElement employmentStatusLink;

    @FindBy(xpath = "//a[contains(@href, 'organization')]")
    private WebElement organizationLink;

    @FindBy(xpath = "//a[contains(@href, 'qualifications')]")
    private WebElement qualificationsLink;

    @FindBy(xpath = "//a[contains(@href, 'languages')]")
    private WebElement languagesLink;

    @FindBy(xpath = "//a[contains(@href, 'skills')]")
    private WebElement skillsLink;

    @FindBy(xpath = "//a[contains(@href, 'general')]")
    private WebElement generalInformationLink;

    @FindBy(xpath = "//table[@role='grid']")
    private WebElement systemUsersTable;

    @FindBy(xpath = "//table[@role='grid']/tbody/tr")
    private List<WebElement> userRows;

    /**
     * Check if admin page is displayed
     * @return boolean indicating if admin title is visible
     */
    public boolean isAdminPageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if admin page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, adminTitle);
        ExtentReportManager.getExtentTest().info("Admin page displayed: " + isDisplayed);
        return isDisplayed;
    }

    /**
     * Navigate to User Management section
     */
    public void navigateToUserManagement() {
        ExtentReportManager.getExtentTest().info("Navigating to user management");
        WebDriverUtils.clickElement(driver, userManagementLink);
        ExtentReportManager.getExtentTest().info("User management page opened");
    }

    /**
     * Navigate to Job Titles section
     */
    public void navigateToJobTitles() {
        ExtentReportManager.getExtentTest().info("Navigating to job titles");
        WebDriverUtils.clickElement(driver, jobTitleLink);
        ExtentReportManager.getExtentTest().info("Job titles page opened");
    }

    /**
     * Navigate to Pay Grades section
     */
    public void navigateToPayGrades() {
        ExtentReportManager.getExtentTest().info("Navigating to pay grades");
        WebDriverUtils.clickElement(driver, payGradeLink);
        ExtentReportManager.getExtentTest().info("Pay grades page opened");
    }

    /**
     * Navigate to Employment Status section
     */
    public void navigateToEmploymentStatus() {
        ExtentReportManager.getExtentTest().info("Navigating to employment status");
        WebDriverUtils.clickElement(driver, employmentStatusLink);
        ExtentReportManager.getExtentTest().info("Employment status page opened");
    }

    /**
     * Navigate to Organization section
     */
    public void navigateToOrganization() {
        ExtentReportManager.getExtentTest().info("Navigating to organization");
        WebDriverUtils.clickElement(driver, organizationLink);
        ExtentReportManager.getExtentTest().info("Organization page opened");
    }

    /**
     * Navigate to Qualifications section
     */
    public void navigateToQualifications() {
        ExtentReportManager.getExtentTest().info("Navigating to qualifications");
        WebDriverUtils.clickElement(driver, qualificationsLink);
        ExtentReportManager.getExtentTest().info("Qualifications page opened");
    }

    /**
     * Navigate to Languages section
     */
    public void navigateToLanguages() {
        ExtentReportManager.getExtentTest().info("Navigating to languages");
        WebDriverUtils.clickElement(driver, languagesLink);
        ExtentReportManager.getExtentTest().info("Languages page opened");
    }

    /**
     * Navigate to Skills section
     */
    public void navigateToSkills() {
        ExtentReportManager.getExtentTest().info("Navigating to skills");
        WebDriverUtils.clickElement(driver, skillsLink);
        ExtentReportManager.getExtentTest().info("Skills page opened");
    }

    /**
     * Get system users count
     * @return number of users in the system
     */
    public int getSystemUsersCount() {
        ExtentReportManager.getExtentTest().info("Getting system users count");
        int count = userRows.size();
        ExtentReportManager.getExtentTest().info("System users count: " + count);
        return count;
    }

    /**
     * Get admin title element
     * @return WebElement for admin title
     */
    public WebElement getAdminTitle() {
        return adminTitle;
    }

    /**
     * Get user management link element
     * @return WebElement for user management link
     */
    public WebElement getUserManagementLink() {
        return userManagementLink;
    }
}
