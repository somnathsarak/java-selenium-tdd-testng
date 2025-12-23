# Java Selenium TDD TestNG Framework

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/saraksomanath/java-selenium-tdd-testng)
[![Java](https://img.shields.io/badge/Java-11+-blue)](https://www.oracle.com/java/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.1-brightgreen)](https://testng.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.15.0-brightgreen)](https://www.selenium.dev/)
[![ExtentReports](https://img.shields.io/badge/ExtentReports-5.1.1-blue)](https://www.extentreports.com/)
[![Maven](https://img.shields.io/badge/Maven-3.8.0+-blue)](https://maven.apache.org/)

## Overview

A comprehensive, production-ready **Java Selenium Test Automation Framework** built using:
- **Test-Driven Development (TDD)** approach
- **Page Object Model (POM)** pattern
- **TestNG** framework
- **ExtentReports** for detailed test reporting
- **Maven** for build automation
- **Retry Analyzer** for handling flaky tests

This framework provides a solid foundation for automated UI testing with best practices in code organization, maintainability, and scalability.

## Key Features

✅ **Maven-Based Project** - Easy build automation and dependency management
✅ **Page Object Model** - Encapsulated page objects with proper locator management
✅ **Test-Driven Development** - Write tests first, then implement functionality
✅ **Detailed Wait Logs** - All wait operations logged in ExtentReports
✅ **Date-Time Report Naming** - Auto-generated reports: `ExtentReport_YYYY-MM-DD_HH-mm-ss.html`
✅ **Comprehensive Logging** - Detailed logs for every action (clicks, inputs, waits, assertions)
✅ **Test Retry Logic** - Automatic retry for flaky tests (max 3 retries)
✅ **Configuration Management** - Externalized configuration via `config.properties`
✅ **Dark Theme Reports** - Professional-looking ExtentReports with dark theme
✅ **System Information** - OS, Java version, Browser, and User details in reports
✅ **TestNG Listeners** - Custom listeners for test event logging
✅ **WebDriver Utilities** - Common operations with explicit waits

## Project Structure

```
java-selenium-tdd-testng/
├── pom.xml                                 # Maven configuration
├── README.md                               # Project documentation
├── .gitignore                              # Git ignore file
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── base/
    │   │       ├── BaseTest.java           # Base class for WebDriver setup/teardown
    │   │       ├── ConfigReader.java       # Configuration properties reader
    │   │       ├── ExtentReportManager.java # ExtentReports management with date-time naming
    │   │       ├── LoginPage.java          # Login Page Object Model (POM)
    │   │       ├── RetryAnalyzer.java      # Retry analyzer for flaky tests
    │   │       ├── TestListener.java       # TestNG listener for test events
    │   │       └── WebDriverUtils.java     # Common WebDriver utilities with waits
    │   │
    │   └── resources/
    │       └── config.properties           # Configuration file (BaseURL, credentials, timeouts)
    │
    └── test/
        └── java/
            └── tests/
                └── LoginTestWithWaitLogs.java  # Sample test with wait logs
```

## Getting Started

### Prerequisites

- **Java 11+** installed
- **Maven 3.8.0+** installed
- **Git** installed
- Modern web browser (Chrome, Firefox, Edge)

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/saraksomanath/java-selenium-tdd-testng.git
   cd java-selenium-tdd-testng
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Update Configuration**
   - Edit `src/main/resources/config.properties`
   - Update BaseURL, username, password as needed
   - Configure browser and timeout settings

### Running Tests

**Run all tests:**
```bash
mvn test
```

**Run specific test class:**
```bash
mvn test -Dtest=LoginTestWithWaitLogs
```

**Run specific test method:**
```bash
mvn test -Dtest=LoginTestWithWaitLogs#testSuccessfulLogin
```

**Generate ExtentReports:**
Reports are automatically generated after test execution in the `test-reports/` directory with timestamp naming convention.

## Configuration

### config.properties

```properties
# Application Configuration
baseURL=https://www.saucedemo.com

# Credentials
username=standard_user
password=secret_sauce
alt_username=problem_user
alt_password=secret_sauce

# Browser Configuration
browser=chrome  # Options: chrome, firefox, edge

# Timeouts (in seconds)
implicit_wait=10
explicit_wait=15
page_load_timeout=30

# Test Data
test_product_name=Sauce Labs Backpack
test_product_price=$29.99

# Report Configuration
report_path=test-reports
report_theme=dark

# Logging
log_level=INFO
```

## Framework Components

### 1. BaseTest.java
- Initializes WebDriver for different browsers (Chrome, Firefox, Edge)
- Uses WebDriverManager for automatic driver management
- Sets implicit waits and page load timeouts
- Provides @BeforeMethod and @AfterMethod for setup/teardown

### 2. LoginPage.java (Page Object Model)
- Contains page locators for login page elements
- Implements methods for user interactions (enterUsername, enterPassword, clickLogin)
- Logs all wait operations to ExtentReports
- Provides error message verification

### 3. ExtentReportManager.java
- Manages ExtentReports with date-time naming: `ExtentReport_YYYY-MM-DD_HH-mm-ss.html`
- Provides test creation and logging methods
- Configures dark theme and system information
- Handles report initialization and flushing

### 4. WebDriverUtils.java
- Provides common WebDriver operations with explicit waits
- Methods: waitForElementToBeVisible, waitForElementToBeClickable, clickElement, sendKeys, getText
- Handles element presence checks and page load waits
- Includes scroll functionality

### 5. ConfigReader.java
- Reads configuration from config.properties file
- Provides static methods for accessing configuration values
- Supports default values for timeouts
- Singleton pattern for single properties instance

### 6. RetryAnalyzer.java
- Implements IRetryAnalyzer for test retry logic
- Max 3 retry attempts for failed tests
- Logs retry information with test name and error details
- Useful for handling flaky tests and intermittent failures

### 7. TestListener.java
- Implements ITestListener for test event logging
- Logs test start, pass, fail, and skip events
- Captures error messages and skip reasons
- Logs test suite start/finish with timestamps

## Sample Test: LoginTestWithWaitLogs

Demonstrates TDD approach with detailed wait logs:

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
public void testSuccessfulLogin() {
    // Initialize reports
    ExtentReportManager.createTest("Login Test With Wait Logs");
    
    // Navigate to application
    navigateTo(ConfigReader.getBaseURL());
    ExtentReportManager.getExtentTest().info("Navigated to application");
    
    // Verify login page
    Assert.assertTrue(loginPage.isLoginPageDisplayed());
    
    // Perform login with wait logs
    loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
    
    // Wait for page load
    WebDriverUtils.waitForPageLoad(driver, 15);
    ExtentReportManager.getExtentTest().pass("Login successful");
}
```

Test results include:
- Detailed wait logs for each operation
- Step-by-step execution timeline
- Error messages with root causes
- Test execution duration
- System information

## ExtentReports Output

Reports are generated with:
- **Dark Theme** for professional appearance
- **Detailed Logs** for every action (waits, clicks, inputs)
- **System Information** (OS, Java version, Browser, User)
- **Test Status** (Pass, Fail, Skip)
- **Execution Time** for each test
- **Stack Traces** for failures
- **Retry Information** for retried tests

## Maven Dependencies

- **Selenium WebDriver** 4.15.0 - Browser automation
- **TestNG** 7.8.1 - Testing framework
- **WebDriverManager** 5.6.3 - Automatic WebDriver management
- **ExtentReports** 5.1.1 - Test reporting
- **Log4j** 2.20.0 - Logging

## Best Practices Implemented

✅ Page Object Model pattern for maintainability
✅ Separation of concerns (locators, interactions, tests)
✅ Configuration externalization
✅ Comprehensive wait strategies
✅ Detailed test reporting with logs
✅ Automatic driver management via WebDriverManager
✅ Test retry logic for flaky tests
✅ Proper exception handling
✅ DRY (Don't Repeat Yourself) principle
✅ Java naming conventions and code standards

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## Troubleshooting

### WebDriver Issues
- WebDriverManager automatically downloads the correct driver version
- Ensure Chrome/Firefox/Edge browsers are installed

### Report Generation Issues
- Check `test-reports/` directory has write permissions
- Ensure config.properties is properly configured

### Test Failures
- Check ExtentReports for detailed logs
- Verify BaseURL in config.properties
- Review waits and timeouts

## Future Enhancements

- Add more page objects for different application pages
- Implement database testing utilities
- Add API testing capabilities
- Integrate with CI/CD pipelines (Jenkins, GitHub Actions)
- Add Allure reports integration
- Implement parallel test execution
- Add mobile testing support

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Sarak Somanath**
- GitHub: [@saraksomanath](https://github.com/saraksomanath)
- LinkedIn: [Profile](https://www.linkedin.com/in/saraksomanath/)

## Support

For issues, questions, or suggestions, please create an issue on the GitHub repository.

---

**Last Updated:** December 2025
**Framework Version:** 1.0.0
