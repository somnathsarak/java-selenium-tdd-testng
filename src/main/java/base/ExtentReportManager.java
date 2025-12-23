package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

/**
 * ExtentReports Manager for generating test reports
 * Provides singleton pattern for ExtentReports instance
 */
public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static final String REPORT_DIR = "test-reports";
    private static final String REPORT_FILE_FORMAT = "yyyy-MM-dd_HH-mm-ss";
    private static ExtentSparkReporter sparkReporter;

    /**
     * Initialize ExtentReports with timestamp
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

            sparkReporter = new ExtentSparkReporter(reportPath);
            configureSparkReporter();

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            setSystemInfo();
        }
        return extentReports;
    }

    /**
     * Configure ExtentSparkReporter settings
     */
    private static void configureSparkReporter() {
        sparkReporter.config().setDocumentTitle("Java Selenium TDD - Extent Report");
        sparkReporter.config().setReportName("Automated Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Set system information in the report
     */
    private static void setSystemInfo() {
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Environment", "Testing");
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
    }

    /**
     * Create a new test in the report
     * @param testName Name of the test
     * @return ExtentTest instance
     */
    public static ExtentTest createTest(String testName) {
        extentTest = extentReports.createTest(testName);
        return extentTest;
    }

    /**
     * Create a test with description
     * @param testName Name of the test
     * @param description Description of the test
     * @return ExtentTest instance
     */
    public static ExtentTest createTest(String testName, String description) {
        extentTest = extentReports.createTest(testName, description);
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
