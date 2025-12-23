package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryAnalyzer for handling test failures with retry logic
 * Automatically retries failed tests based on configured retry count
 * Useful for handling flaky tests and intermittent failures
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    // Number of times to retry a failed test
    private static final int MAX_RETRY_COUNT = 3;
    // Current retry count
    private int retryCount = 0;

    /**
     * Retry method that decides if a test should be retried
     * @param result ITestResult of the test execution
     * @return true if test should be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult result) {
        // Check if test failed and retry count is less than max
        if (!result.isSuccess() && retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            String testName = result.getMethod().getMethodName();
            String testClass = result.getTestClass().getName();
            System.out.println("\n========================================");
            System.out.println("RETRYING TEST: " + testClass + "." + testName);
            System.out.println("Retry Attempt: " + retryCount + " of " + MAX_RETRY_COUNT);
            System.out.println("Test Status: " + (result.getThrowable() != null ? 
                result.getThrowable().getMessage() : "Unknown failure"));
            System.out.println("========================================\n");
            return true;
        }
        return false;
    }

    /**
     * Get the maximum retry count
     * @return Maximum number of retries
     */
    public int getMaxRetryCount() {
        return MAX_RETRY_COUNT;
    }

    /**
     * Get the current retry count
     * @return Current retry attempt number
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * Reset retry count (useful for new test execution)
     */
    public void resetRetryCount() {
        this.retryCount = 0;
    }
}
