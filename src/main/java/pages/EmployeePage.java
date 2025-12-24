package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * OrangeHRM Employee Page Object Model using PageFactory
 * Contains locators and methods for OrangeHRM Employee page
 */
public class EmployeePage {
    private WebDriver driver;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Employee Page locators using @FindBy annotation
    @FindBy(xpath = "//h6[text()='Employee']")
    private WebElement employeeTitle;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewEmployeeList']")
    private WebElement employeeListLink;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeSearchInput;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@role='grid']")
    private WebElement employeesTable;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Employee Id']")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@role='grid']/tbody/tr")
    private List<WebElement> employeeRows;

    public boolean isEmployeePageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if employee page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, employeeTitle);
        ExtentReportManager.getExtentTest().info("Employee page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void navigateToEmployeeList() {
        ExtentReportManager.getExtentTest().info("Navigating to employee list");
        WebDriverUtils.clickElement(driver, employeeListLink);
        ExtentReportManager.getExtentTest().info("Employee list page opened");
    }

    public void clickAddEmployeeButton() {
        ExtentReportManager.getExtentTest().info("Clicking add employee button");
        WebDriverUtils.clickElement(driver, addEmployeeButton);
        ExtentReportManager.getExtentTest().info("Add employee form displayed");
    }

    public void searchEmployee(String employeeName) {
        ExtentReportManager.getExtentTest().info("Searching for employee: " + employeeName);
        WebDriverUtils.sendKeys(driver, employeeSearchInput, employeeName);
        WebDriverUtils.clickElement(driver, searchButton);
        ExtentReportManager.getExtentTest().info("Search executed");
    }

    public int getEmployeeCount() {
        ExtentReportManager.getExtentTest().info("Getting employee count");
        int count = employeeRows.size();
        ExtentReportManager.getExtentTest().info("Employee count: " + count);
        return count;
    }

    public void enterFirstName(String firstName) {
        ExtentReportManager.getExtentTest().info("Entering first name: " + firstName);
        WebDriverUtils.sendKeys(driver, firstNameInput, firstName);
        ExtentReportManager.getExtentTest().info("First name entered");
    }

    public void enterLastName(String lastName) {
        ExtentReportManager.getExtentTest().info("Entering last name: " + lastName);
        WebDriverUtils.sendKeys(driver, lastNameInput, lastName);
        ExtentReportManager.getExtentTest().info("Last name entered");
    }

    public void enterEmployeeId(String employeeId) {
        ExtentReportManager.getExtentTest().info("Entering employee ID: " + employeeId);
        WebDriverUtils.sendKeys(driver, employeeIdInput, employeeId);
        ExtentReportManager.getExtentTest().info("Employee ID entered");
    }

    public void clickSaveButton() {
        ExtentReportManager.getExtentTest().info("Clicking save button");
        WebDriverUtils.clickElement(driver, saveButton);
        ExtentReportManager.getExtentTest().info("Employee saved");
    }

    public void addNewEmployee(String firstName, String lastName, String employeeId) {
        ExtentReportManager.getExtentTest().info("Adding new employee with name: " + firstName + " " + lastName);
        clickAddEmployeeButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmployeeId(employeeId);
        clickSaveButton();
        ExtentReportManager.getExtentTest().info("New employee added successfully");
    }

    public WebElement getEmployeeTitle() {
        return employeeTitle;
    }

    public WebElement getAddEmployeeButton() {
        return addEmployeeButton;
    }
}
