package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RecruitmentPage;

public class RecruitmentPageTest extends BaseTest {
    private RecruitmentPage recruitmentPage;

    @Test(priority = 1)
    public void testRecruitmentPageDisplay() {
        recruitmentPage = new RecruitmentPage(driver);
        Assert.assertTrue(recruitmentPage.isRecruitmentPageDisplayed());
    }

    @Test(priority = 2)
    public void testNavigateToVacancies() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.navigateToVacancies();
    }

    @Test(priority = 3)
    public void testNavigateToCandidates() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.navigateToCandidates();
    }

    @Test(priority = 4)
    public void testClickAddVacancyButton() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickAddVacancyButton();
    }

    @Test(priority = 5)
    public void testEnterJobTitle() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterJobTitle("Java Developer");
    }

    @Test(priority = 6)
    public void testEnterVacancyCount() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterVacancyCount("5");
    }

    @Test(priority = 7)
    public void testEnterJobDescription() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterDescription("Looking for experienced Java developer");
    }

    @Test(priority = 8)
    public void testEnterCandidateName() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterCandidateName("Alice Johnson");
    }

    @Test(priority = 9)
    public void testEnterCandidateDetails() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterCandidateEmail("alice@example.com");
        recruitmentPage.enterCandidatePhone("1234567890");
    }

    @Test(priority = 10)
    public void testGetVacanciesCount() {
        recruitmentPage = new RecruitmentPage(driver);
        int count = recruitmentPage.getVacanciesCount();
        Assert.assertGreaterOrEqual(count, 0);
    }
}
