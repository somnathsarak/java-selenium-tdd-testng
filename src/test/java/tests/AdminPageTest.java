package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;

public class AdminPageTest extends BaseTest {
    private AdminPage adminPage;

    @Test(priority = 1)
    public void testAdminPageDisplay() {
        adminPage = new AdminPage(driver);
        Assert.assertTrue(adminPage.isAdminPageDisplayed());
    }

    @Test(priority = 2)
    public void testNavigateToUserManagement() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToUserManagement();
    }

    @Test(priority = 3)
    public void testNavigateToJobTitles() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToJobTitles();
    }

    @Test(priority = 4)
    public void testNavigateToPayGrades() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToPayGrades();
    }

    @Test(priority = 5)
    public void testNavigateToEmploymentStatus() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToEmploymentStatus();
    }

    @Test(priority = 6)
    public void testNavigateToOrganization() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToOrganization();
    }

    @Test(priority = 7)
    public void testNavigateToQualifications() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToQualifications();
    }

    @Test(priority = 8)
    public void testNavigateToLanguages() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToLanguages();
    }

    @Test(priority = 9)
    public void testNavigateToSkills() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToSkills();
    }

    @Test(priority = 10)
    public void testGetSystemUsersCount() {
        adminPage = new AdminPage(driver);
        int count = adminPage.getSystemUsersCount();
        Assert.assertGreater(count, 0);
    }
}
