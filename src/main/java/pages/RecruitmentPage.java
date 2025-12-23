package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * OrangeHRM Recruitment Page Object Model
 * Contains locators and methods for OrangeHRM Recruitment page
 */
public class RecruitmentPage {
    private WebDriver driver;

    // Recruitment Page locators
    private By recruitmentTitle = By.xpath("//h6[text()='Recruitment']");
    private By vacanciesLink = By.xpath("//a[contains(@href, 'vacancy')]");
    private By candidatesLink = By.xpath("//a[contains(@href, 'candidate')]");
    private By addVacancyButton = By.xpath("//button[contains(text(), 'Add')]");
    private By jobTitleInput = By.xpath("//input[@name='jobTitle']");
    private By vacancyCountInput = By.xpath("//input[@name='numberOfPositions']");
    private By descriptionTextarea = By.xpath("//textarea[@name='description']");
    private By candidateNameInput = By.xpath("//input[@name='candidateName']");
    private By emailInput = By.xpath("//input[@name='email']");
    private By phoneInput = By.xpath("//input[@name='phone']");

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRecruitmentPageDisplayed() {
        ExtentReportManager.getExtentTest().info("Checking if recruitment page is displayed");
        boolean isDisplayed = WebDriverUtils.isElementDisplayed(driver, recruitmentTitle);
        ExtentReportManager.getExtentTest().info("Recruitment page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void navigateToVacancies() {
        ExtentReportManager.getExtentTest().info("Navigating to vacancies");
        WebDriverUtils.clickElement(driver, vacanciesLink);
        ExtentReportManager.getExtentTest().info("Vacancies page opened");
    }

    public void navigateToCandidates() {
        ExtentReportManager.getExtentTest().info("Navigating to candidates");
        WebDriverUtils.clickElement(driver, candidatesLink);
        ExtentReportManager.getExtentTest().info("Candidates page opened");
    }

    public void clickAddVacancyButton() {
        ExtentReportManager.getExtentTest().info("Clicking add vacancy button");
        WebDriverUtils.clickElement(driver, addVacancyButton);
        ExtentReportManager.getExtentTest().info("Add vacancy form displayed");
    }

    public void enterJobTitle(String jobTitle) {
        ExtentReportManager.getExtentTest().info("Entering job title: " + jobTitle);
        WebDriverUtils.sendKeys(driver, jobTitleInput, jobTitle);
        ExtentReportManager.getExtentTest().info("Job title entered");
    }

    public void enterVacancyCount(String count) {
        ExtentReportManager.getExtentTest().info("Entering vacancy count: " + count);
        WebDriverUtils.sendKeys(driver, vacancyCountInput, count);
        ExtentReportManager.getExtentTest().info("Vacancy count entered");
    }

    public void enterDescription(String description) {
        ExtentReportManager.getExtentTest().info("Entering job description");
        WebDriverUtils.sendKeys(driver, descriptionTextarea, description);
        ExtentReportManager.getExtentTest().info("Description entered");
    }

    public void enterCandidateName(String candidateName) {
        ExtentReportManager.getExtentTest().info("Entering candidate name: " + candidateName);
        WebDriverUtils.sendKeys(driver, candidateNameInput, candidateName);
        ExtentReportManager.getExtentTest().info("Candidate name entered");
    }

    public void enterCandidateEmail(String email) {
        ExtentReportManager.getExtentTest().info("Entering candidate email: " + email);
        WebDriverUtils.sendKeys(driver, emailInput, email);
        ExtentReportManager.getExtentTest().info("Email entered");
    }

    public void enterCandidatePhone(String phone) {
        ExtentReportManager.getExtentTest().info("Entering candidate phone: " + phone);
        WebDriverUtils.sendKeys(driver, phoneInput, phone);
        ExtentReportManager.getExtentTest().info("Phone entered");
    }

    public int getVacanciesCount() {
        ExtentReportManager.getExtentTest().info("Getting vacancies count");
        List<WebElement> vacancies = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
        ExtentReportManager.getExtentTest().info("Vacancies count: " + vacancies.size());
        return vacancies.size();
    }
}
