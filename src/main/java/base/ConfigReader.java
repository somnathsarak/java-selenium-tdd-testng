package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader utility class for reading properties from config file
 * Provides centralized access to configuration values
 * Uses singleton pattern for single instance of properties
 */
public class ConfigReader {
    private static Properties properties;
    private static final String PROPERTY_FILE_PATH = "src/main/resources/config.properties";

    // Static initialization block to load properties
    static {
        loadProperties();
    }

    /**
     * Load properties from the config file
     */
    private static void loadProperties() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Unable to load properties file: " + PROPERTY_FILE_PATH);
            e.printStackTrace();
        }
    }

    /**
     * Get the Base URL from properties
     * @return Base URL of the application
     */
    public static String getBaseURL() {
        return properties.getProperty("baseURL");
    }

    /**
     * Get the Username from properties
     * @return Username for login
     */
    public static String getUsername() {
        return properties.getProperty("username");
    }

    /**
     * Get the Password from properties
     * @return Password for login
     */
    public static String getPassword() {
        return properties.getProperty("password");
    }

    /**
     * Get alternative username from properties
     * @return Alternative username for testing
     */
    public static String getAltUsername() {
        return properties.getProperty("alt_username");
    }

    /**
     * Get alternative password from properties
     * @return Alternative password for testing
     */
    public static String getAltPassword() {
        return properties.getProperty("alt_password");
    }

    /**
     * Get Browser name from properties
     * @return Browser name (chrome, firefox, edge)
     */
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    /**
     * Get Implicit Wait timeout from properties
     * @return Implicit wait in seconds
     */
    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit_wait", "10"));
    }

    /**
     * Get Explicit Wait timeout from properties
     * @return Explicit wait in seconds
     */
    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicit_wait", "15"));
    }

    /**
     * Get Page Load Timeout from properties
     * @return Page load timeout in seconds
     */
    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("page_load_timeout", "30"));
    }

    /**
     * Get Test Product Name from properties
     * @return Test product name
     */
    public static String getTestProductName() {
        return properties.getProperty("test_product_name");
    }

    /**
     * Get Test Product Price from properties
     * @return Test product price
     */
    public static String getTestProductPrice() {
        return properties.getProperty("test_product_price");
    }

    /**
     * Get Report Path from properties
     * @return Path where reports will be generated
     */
    public static String getReportPath() {
        return properties.getProperty("report_path");
    }

    /**
     * Get Log Level from properties
     * @return Log level (INFO, DEBUG, ERROR, etc.)
     */
    public static String getLogLevel() {
        return properties.getProperty("log_level", "INFO");
    }

    /**
     * Get a property value by key
     * @param key Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get a property value by key with default value
     * @param key Property key
     * @param defaultValue Default value if key not found
     * @return Property value or default value
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
