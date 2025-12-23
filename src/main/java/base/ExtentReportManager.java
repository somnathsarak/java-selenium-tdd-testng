package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

/**
 * ExtentReports Manager for generating test reports
 * Provides singleton pattern for ExtentReports instance
 * Enhanced with detailed logging, screenshots, and report customization
 */
public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static final String REPORT_DIR = "test-reports";
    private static final String REPORT_FILE_FORMAT = "yyyy-MM-dd_HH-mm-ss";
    private static ExtentSparkReporter sparkReporter;

    /**
     * Initialize ExtentReports with timestamp and customization
     * @return ExtentReports instance
     */
    public static ExtentReports initializeExtentReports() {
        if (extentReports == null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern(REPORT_FILE_FORMAT));
            String reportPath = REPORT_DIR + File.separator + "ExtentReport_" + timestamp + ".html";

            // Create report directory if not exists
            File reportDir = new File(REPORT_DIR);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            // Initialize ExtentSparkReporter
            sparkReporter = new ExtentSparkReporter(reportPath);
            configureSparkReporter();

            // Initialize ExtentReports
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            // Set system information
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
            extentReports.setSystemInfo("Application URL", "https://opensource-demo.orangehrmlive.com");
            extentReports.setSystemInfo("Test Environment", "Production");
            extentReports.setSystemInfo("Test Framework", "Selenium + TestNG + ExtentReports");
            extentReports.setSystemInfo("Automation Engineer", "SQA Team");
        }
        return extentReports;
    }

    /**
     * Configure ExtentSparkReporter with theme and settings
     */
    private static void configureSparkReporter() {
        if (sparkReporter != null) {
            sparkReporter.config().setDocumentTitle("OrangeHRM Test Automation Report");
            sparkReporter.config().setReportName("Test Execution Summary");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        }
    }

    /**
     * Create a test in the report
     * @param testName Name of the test
     * @param testDescription Description of the test
     * @return ExtentTest instance
     */
    public static ExtentTest createTest(String testName, String testDescription) {
        extentTest = extentReports.createTest(testName, testDescription);
        return extentTest;
    }

    /**
     * Get current ExtentTest instance
     * @return ExtentTest instance
     */
    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    /**
     * Log test step with PASS status
     * @param stepDetails Details of the step
     */
    public static void passStep(String stepDetails) {
        if (extentTest != null) {
            extentTest.log(Status.PASS, stepDetails);
        }
    }

    /**
     * Log test step with FAIL status
     * @param stepDetails Details of the step
     */
    public static void failStep(String stepDetails) {
        if (extentTest != null) {
            extentTest.log(Status.FAIL, stepDetails);
        }
    }

    /**
     * Log test step with INFO status
     * @param stepDetails Details of the step
     */
    public static void infoStep(String stepDetails) {
        if (extentTest != null) {
            extentTest.log(Status.INFO, stepDetails);
        }
    }

    /**
     * Log test step with WARNING status
     * @param stepDetails Details of the step
     */
    public static void warningStep(String stepDetails) {
        if (extentTest != null) {
            extentTest.log(Status.WARNING, stepDetails);
        }
    }

    /**
     * Log test step with SKIP status
     * @param stepDetails Details of the step
     */
    public static void skipStep(String stepDetails) {
        if (extentTest != null) {
            extentTest.log(Status.SKIP, stepDetails);
        }
    }

    /**
     * Add exception to test report
     * @param exception Exception to log
     */
    public static void logException(Throwable exception) {
        if (extentTest != null) {
            extentTest.fail(exception);
        }
    }

    /**
     * Flush and close the ExtentReports
     */
    public static void flushExtentReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    /**
     * Remove ExtentReports instance
     */
    public static void removeExtentReports() {
        if (extentReports != null) {
            extentReports = null;
        }
    }
}
