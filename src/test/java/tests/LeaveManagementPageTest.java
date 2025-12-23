package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeaveManagementPage;

public class LeaveManagementPageTest extends BaseTest {
    private LeaveManagementPage leaveManagementPage;

    @Test(priority = 1)
    public void testLeavePageDisplay() {
        leaveManagementPage = new LeaveManagementPage(driver);
        Assert.assertTrue(leaveManagementPage.isLeavePageDisplayed());
    }

    @Test(priority = 2)
    public void testNavigateToApplyLeave() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToApplyLeave();
    }

    @Test(priority = 3)
    public void testNavigateToMyLeave() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToMyLeave();
    }

    @Test(priority = 4)
    public void testNavigateToLeaveType() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToLeaveType();
    }

    @Test(priority = 5)
    public void testNavigateToLeavePeriod() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToLeavePeriod();
    }

    @Test(priority = 6)
    public void testNavigateToLeaveEntitlement() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToLeaveEntitlement();
    }

    @Test(priority = 7)
    public void testNavigateToLeaveReport() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.navigateToLeaveReport();
    }

    @Test(priority = 8)
    public void testSelectLeaveType() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.selectLeaveType("PTO");
    }

    @Test(priority = 9)
    public void testEnterLeaveDates() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.enterFromDate("2024-01-01");
        leaveManagementPage.enterToDate("2024-01-05");
    }

    @Test(priority = 10)
    public void testEnterLeaveRemarks() {
        leaveManagementPage = new LeaveManagementPage(driver);
        leaveManagementPage.enterRemarks("Annual vacation");
    }
}
