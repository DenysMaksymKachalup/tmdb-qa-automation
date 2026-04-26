package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getDriverFromProperties();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver getDriverFromProperties() {
        return switch (System.getProperty("browser")) {
            case "firefox" -> new FirefoxDriver();
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new UnsupportedOperationException("Unsupported browser: " + System.getProperty("browser"));
        };
    }

}
