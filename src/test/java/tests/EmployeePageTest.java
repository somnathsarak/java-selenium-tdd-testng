package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;

public class EmployeePageTest extends BaseTest {
    private EmployeePage employeePage;

    @Test(priority = 1)
    public void testEmployeePageDisplay() {
        employeePage = new EmployeePage(driver);
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
    }

    @Test(priority = 2)
    public void testNavigateToEmployeeList() {
        employeePage = new EmployeePage(driver);
        employeePage.navigateToEmployeeList();
    }

    @Test(priority = 3)
    public void testClickAddEmployeeButton() {
        employeePage = new EmployeePage(driver);
        employeePage.clickAddEmployeeButton();
    }

    @Test(priority = 4)
    public void testSearchEmployee() {
        employeePage = new EmployeePage(driver);
        employeePage.searchEmployee("John");
    }

    @Test(priority = 5)
    public void testGetEmployeeCount() {
        employeePage = new EmployeePage(driver);
        int count = employeePage.getEmployeeCount();
        Assert.assertGreaterOrEqual(count, 0);
    }

    @Test(priority = 6)
    public void testEnterFirstName() {
        employeePage = new EmployeePage(driver);
        employeePage.enterFirstName("John");
    }

    @Test(priority = 7)
    public void testEnterLastName() {
        employeePage = new EmployeePage(driver);
        employeePage.enterLastName("Doe");
    }

    @Test(priority = 8)
    public void testEnterEmployeeId() {
        employeePage = new EmployeePage(driver);
        employeePage.enterEmployeeId("12345");
    }

    @Test(priority = 9)
    public void testClickSaveButton() {
        employeePage = new EmployeePage(driver);
        employeePage.clickSaveButton();
    }

    @Test(priority = 10)
    public void testAddNewEmployee() {
        employeePage = new EmployeePage(driver);
        employeePage.addNewEmployee("Jane", "Smith", "54321");
    }
}
