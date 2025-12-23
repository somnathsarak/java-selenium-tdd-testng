package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TestNG Listener for test execution events
 * Logs test start, success, failure, and skip events
 */
public class TestListener implements ITestListener {
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onTestStart(ITestResult result) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST STARTED: %s.%s",
                timestamp,
                result.getTestClass().getName(),
                result.getMethod().getMethodName());
        Reporter.log(message);
        System.out.println(message);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST PASSED: %s.%s [Duration: %dms]",
                timestamp,
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                result.getEndMillis() - result.getStartMillis());
        Reporter.log(message);
        System.out.println(message);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST FAILED: %s.%s [Duration: %dms]",
                timestamp,
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                result.getEndMillis() - result.getStartMillis());
        Reporter.log(message);
        System.out.println(message);

        if (result.getThrowable() != null) {
            String errorMessage = String.format("Error: %s", result.getThrowable().getMessage());
            Reporter.log(errorMessage);
            System.out.println(errorMessage);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST SKIPPED: %s.%s",
                timestamp,
                result.getTestClass().getName(),
                result.getMethod().getMethodName());
        Reporter.log(message);
        System.out.println(message);

        if (result.getThrowable() != null) {
            String reason = String.format("Reason: %s", result.getThrowable().getMessage());
            Reporter.log(reason);
            System.out.println(reason);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST SUITE STARTED: %s", timestamp, context.getName());
        Reporter.log(message);
        System.out.println(message);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String message = String.format("[%s] TEST SUITE FINISHED: %s", timestamp, context.getName());
        Reporter.log(message);
        System.out.println(message);
    }
}
