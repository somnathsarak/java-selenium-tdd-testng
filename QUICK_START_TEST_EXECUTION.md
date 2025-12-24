# Quick Start: Running All Test Cases

## Overview
This guide provides quick step-by-step instructions to execute all 50 test cases in the Java Selenium TDD TestNG Framework.

**Total Test Cases: 50** (10 per page class)
- DashboardPageTest: 10 test cases
- AdminPageTest: 10 test cases
- EmployeePageTest: 10 test cases
- LeaveManagementPageTest: 10 test cases
- RecruitmentPageTest: 10 test cases

---

## Prerequisites

### Required Software
- **Java 11+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.8.0+** - [Download](https://maven.apache.org/download.cgi)
- **Git** - [Download](https://git-scm.com/)
- **Modern Web Browser** (Chrome, Firefox, Edge) - Installed

### Verify Installation
```bash
java -version
mvn -version
git --version
```

---

## Setup Instructions

### Step 1: Clone the Repository
```bash
git clone https://github.com/somnathsarak/java-selenium-tdd-testng.git
cd java-selenium-tdd-testng
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Update Configuration (Optional)
Edit `src/main/resources/config.properties` to update:
- `baseURL` - Application URL (default: OrangeHRM)
- `username` - Test user credentials
- `password` - Test user credentials
- `browser` - Browser type (chrome, firefox, edge)
- `implicit_wait` - Implicit wait timeout
- `explicit_wait` - Explicit wait timeout

---

## Running All Test Cases

### Method 1: Using Bash Script (Recommended for Linux/Mac)
```bash
cd java-selenium-tdd-testng
chmod +x run_tests.sh
./run_tests.sh
```

### Method 2: Using Maven Command (All Platforms)
```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

### Method 3: IDE Execution (Eclipse/IntelliJ)
1. Right-click on `testng.xml` file in project root
2. Select "Run As" → "TestNG Suite"
3. View test execution in IDE console
4. Reports generated automatically

### Method 4: Run Specific Test Class
```bash
mvn test -Dtest=DashboardPageTest
mvn test -Dtest=AdminPageTest
mvn test -Dtest=EmployeePageTest
mvn test -Dtest=LeaveManagementPageTest
mvn test -Dtest=RecruitmentPageTest
```

### Method 5: Run Specific Test Method
```bash
mvn test -Dtest=DashboardPageTest#testVerifyDashboardTitle
```

---

## Test Execution Process

When you execute the tests, the following happens:

### Execution Steps
1. **Maven Clean** - Removes previous build artifacts
2. **Compilation** - Compiles Java source code
3. **Dependency Resolution** - Downloads required libraries
4. **Test Setup** - WebDriver initialization and configuration
5. **Test Execution** - Runs all 50 test cases sequentially/parallel
6. **Report Generation** - Creates ExtentReports and TestNG reports
7. **Cleanup** - Browser closure and resource cleanup

### Expected Execution Time
- **Parallel Execution (2 threads)**: ~3-5 minutes
- **Sequential Execution**: ~8-10 minutes

---

## Test Execution Output

### Console Output Example
```
========================================
Java Selenium TDD TestNG Framework
Test Execution Script
========================================

[INFO] Maven version: 3.8.1
[INFO] Cleaning and compiling the project...
[INFO] Compilation successful!
[INFO] Running OrangeHRM Test Suite...

[INFO] Executing 50 test cases...
[INFO] DashboardPageTest: Starting 10 test cases
[INFO] Test 1: testVerifyDashboardTitle ... PASS (2.5s)
[INFO] Test 2: testVerifyWelcomeMessage ... PASS (2.8s)
...

[SUCCESS] All tests executed successfully!

Test Reports Location:
 - HTML Report: test-reports/ExtentReport_2025-12-24_07-30-15.html
 - Surefire Report: target/surefire-reports/
 - TestNG Report: test-output/
```

---

## Test Reports

### Report Locations

#### 1. Primary ExtentReport (Recommended)
```
test-reports/ExtentReport_YYYY-MM-DD_HH-mm-ss.html
```
**Open in Browser**: Double-click the HTML file to view

**Report Contains**:
- Test Summary (Passed, Failed, Skipped)
- Detailed test logs
- Wait operations with timestamps
- System information
- Execution timeline
- Pass/Fail statistics
- Dark theme professional design

#### 2. Maven Surefire Reports
```
target/surefire-reports/
├── index.html
├── *.xml (Test results)
└── *.html (Individual test reports)
```

#### 3. TestNG Default Output
```
test-output/
├── index.html
├── emailable-report.html
└── testng-results.xml
```

---

## Expected Test Results

### Success Scenario (All Tests Pass)
```
Test Suite: OrangeHRM Test Automation
Total Tests: 50
Passed: 50
Failed: 0
Skipped: 0
Pass Rate: 100%
Execution Time: 4 minutes 32 seconds
Status: SUCCESS ✓
```

### Test Status Indicators
- ✓ **PASS** - Test executed successfully
- ✗ **FAIL** - Test failed (assertion/exception)
- ⊘ **SKIP** - Test skipped (skip condition met)

---

## Understanding Test Results

### If All Tests Pass
1. ExtentReport will show **100% Pass Rate**
2. All test steps will be marked as **PASSED** (green)
3. No error messages in logs
4. Execution time will be displayed

### If Some Tests Fail
1. Failed tests will be highlighted in **RED**
2. Error message and stack trace provided
3. Check the detailed logs for root cause
4. Common failures:
   - Element not found (NoSuchElementException)
   - Timeout waiting for element (TimeoutException)
   - Assertion failure
   - Stale element reference

### Debugging Failed Tests
1. **Review Extent Report** - Click on failed test for details
2. **Check Log Entries** - Look for error messages
3. **Verify Element Locators** - Ensure page elements haven't changed
4. **Check Wait Conditions** - Increase timeout if needed
5. **Verify Application URL** - Ensure OrangeHRM is accessible

---

## Troubleshooting

### Issue: "Maven command not found"
**Solution**: Set MAVEN_HOME environment variable
```bash
export PATH=$PATH:/path/to/maven/bin
```

### Issue: "Chrome driver not found"
**Solution**: WebDriverManager should auto-download. If not:
1. Ensure Chrome is installed
2. Check internet connection
3. Clear Maven cache: `mvn clean dependency:resolve`

### Issue: "Tests timeout"
**Solution**: Increase timeout in `config.properties`
```
explicit_wait=20
page_load_timeout=30
```

### Issue: "Application not accessible"
**Solution**: Verify OrangeHRM URL
1. Check: https://opensource-demo.orangehrmlive.com/
2. Verify internet connection
3. Try different browser

### Issue: "Reports not generated"
**Solution**: 
1. Ensure `test-reports/` directory exists
2. Check write permissions
3. Verify TestListener is registered in testng.xml
4. Review test execution logs for errors

---

## Best Practices

### Before Running Tests
- [ ] Verify all prerequisites are installed
- [ ] Check OrangeHRM application is accessible
- [ ] Update `config.properties` if needed
- [ ] Ensure sufficient disk space for reports
- [ ] Close other resource-intensive applications

### During Test Execution
- [ ] Do not interrupt the script (let it complete)
- [ ] Monitor console for errors
- [ ] Keep internet connection stable
- [ ] Avoid manual actions on application

### After Test Execution
- [ ] Review ExtentReport for summary
- [ ] Check failed test details if any
- [ ] Archive reports for historical tracking
- [ ] Document any issues found

---

## Next Steps

1. **Add More Test Cases** - Extend test coverage
2. **Integrate with CI/CD** - Setup Jenkins/GitHub Actions
3. **Generate Reports** - Configure email notifications
4. **Performance Testing** - Add performance benchmarks
5. **Mobile Testing** - Extend to mobile browsers

---

## Support & Documentation

- **Framework README**: [README.md](README.md)
- **Test Execution Guide**: [TEST_EXECUTION_AND_REPORT_GUIDE.md](TEST_EXECUTION_AND_REPORT_GUIDE.md)
- **TestNG Documentation**: https://testng.org/
- **Selenium Documentation**: https://www.selenium.dev/
- **ExtentReports**: https://www.extentreports.com/
- **OrangeHRM Demo**: https://opensource-demo.orangehrmlive.com/

---

## Summary

**Framework Status**: ✓ Production Ready
**Total Test Cases**: 50
**Test Coverage**: 5 Page Classes × 10 Tests each
**Report Format**: ExtentReports (Dark Theme)
**Last Updated**: December 24, 2025
**Framework Version**: 1.0.0

---

**Happy Testing! 🚀**
