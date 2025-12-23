package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

/**
 * Test class for OrangeHRM Dashboard Page
 * Contains 10 test cases for dashboard functionality
 */
public class DashboardPageTest extends BaseTest {
    private DashboardPage dashboardPage;

    @Test(priority = 1, description = "Test dashboard page loads successfully")
    public void testDashboardPageLoad() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page should be displayed");
    }

    @Test(priority = 2, description = "Test sidebar menu is displayed")
    public void testSidebarMenuDisplayed() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isSidebarMenuDisplayed(), "Sidebar menu should be displayed");
    }

    @Test(priority = 3, description = "Test quick launch display")
    public void testQuickLaunchDisplay() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isQuickLaunchDisplayed(), "Quick launch should be displayed");
    }

    @Test(priority = 4, description = "Test employee on leave widget")
    public void testEmployeeOnLeaveWidget() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isEmployeeOnLeaveDisplayed(), "Employee on leave widget should be displayed");
    }

    @Test(priority = 5, description = "Test work anniversary widget")
    public void testWorkAnniversaryWidget() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isWorkAnniversaryDisplayed(), "Work anniversary widget should be displayed");
    }

    @Test(priority = 6, description = "Test dashboard user dropdown menu")
    public void testUserDropdownMenu() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserDropdown();
        Assert.assertTrue(dashboardPage.isUserDropdownDisplayed(), "User dropdown menu should be displayed");
    }

    @Test(priority = 7, description = "Test logging out from dashboard")
    public void testLogoutFromDashboard() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserDropdown();
        dashboardPage.clickLogoutOption();
    }

    @Test(priority = 8, description = "Test sidebar menu is hidden or shown")
    public void testSidebarMenuToggle() {
        dashboardPage = new DashboardPage(driver);
        boolean isDisplayed = dashboardPage.isSidebarMenuDisplayed();
        Assert.assertTrue(isDisplayed, "Sidebar menu should be in expected state");
    }

    @Test(priority = 9, description = "Test dashboard widget count")
    public void testDashboardWidgetCount() {
        dashboardPage = new DashboardPage(driver);
        int widgetCount = dashboardPage.getDashboardWidgetCount();
        Assert.assertGreater(widgetCount, 0, "Dashboard should have at least one widget");
    }

    @Test(priority = 10, description = "Test profile button visibility")
    public void testProfileButtonVisibility() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isProfileButtonDisplayed(), "Profile button should be visible");
    }
}
