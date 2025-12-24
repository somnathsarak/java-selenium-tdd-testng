package pages;

import base.ExtentReportManager;
import base.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * OrangeHRM Recruitment Page Object Model using PageFactory
 * Contains locators and methods for OrangeHRM Recruitment page
 */
public class RecruitmentPage {
    private WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Recruitment Page locators using @FindBy annotation
    @FindBy(xpath = "//h6[text()='Recruitment']")
    private WebElement recruitmentTitle;

    @FindBy(xpath = "//a[contains(@href, 'vacancy')]")
    private WebElement vacanciesLink;

    @FindBy(xpath = "//a[contains(@href, 'candidate')]")
    private WebElement candidatesLink;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    private WebElement addVacancyButton;

    @FindBy(xpath = "//input[@name='jobTitle']")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//input[@name='numberOfPositions']")
    private WebElement vacancyCountInput;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionTextarea;

    @FindBy(xpath = "//input[@name='candidateName']")
    private WebElement candidateNameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//table[@role='grid']/tbody/tr")
    private List<WebElement> vacancyRows;

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
        int count = vacancyRows.size();
        ExtentReportManager.getExtentTest().info("Vacancies count: " + count);
        return count;
    }

    public WebElement getRecruitmentTitle() {
        return recruitmentTitle;
    }
}
