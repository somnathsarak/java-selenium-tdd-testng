package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * OrangeHRM Employee Page Object Model
 * Contains locators and methods for OrangeHRM Employee page
 */
public class EmployeePage {
    private WebDriver driver;

    // Employee Page locators
    private By employeeTitle = By.xpath("//h6[text()='Employee']");
    private By employeeListLink = By.xpath("//a[@href='/web/index.php/pim/viewEmployeeList']");
    private By addEmployeeButton = By.xpath("//button[contains(text(), 'Add')]");
    private By employeeSearchInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By searchButton = By.xpath("//button[contains(text(), 'Search')]");
    private By employeesTable = By.xpath("//table[@role='grid']");
    private By firstNameInput = By.xpath("//input[@name='firstName']");
    private By lastNameInput = By.xpath("//input[@name='lastName']");
    private By employeeIdInput = By.xpath("//input[@placeholder='Employee Id']");
    private By saveButton = By.xpath("//button[contains(text(), 'Save')]");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

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
        List<WebElement> employees = driver.findElements(employeesTable);
        ExtentReportManager.getExtentTest().info("Employee count: " + employees.size());
        return employees.size();
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
}
