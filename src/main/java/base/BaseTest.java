package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;

/**
 * Base class for Selenium WebDriver setup and teardown
 * Provides WebDriver initialization and browser management
 */
public class BaseTest {
    protected WebDriver driver;
    protected String browserName = "chrome";
    protected long implicitWait = 10;
    protected long pageLoadTimeout = 30;

    /**
     * Initialize WebDriver based on browser name
     */
    @BeforeMethod
    public void setupDriver() {
        driver = initializeDriver(browserName);
        setTimeouts();
    }

    /**
     * Initialize WebDriver for specified browser
     * @param browserName Browser name (chrome, firefox, edge)
     * @return WebDriver instance
     */
    private WebDriver initializeDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser " + browserName + " is not supported");
        }
        return driver;
    }

    /**
     * Set implicit wait and page load timeout
     */
    private void setTimeouts() {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
    }

    /**
     * Navigate to URL
     * @param url URL to navigate
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Close WebDriver and cleanup
     */
    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
