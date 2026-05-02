package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        return switch (ConfigReader.getProperty("browser")) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en");
                yield new ChromeDriver(options);
            }

            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("intl.accept_languages", "en,en-US");
                yield new FirefoxDriver(options);
            }

            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--lang=en");
                yield new EdgeDriver(options);
            }
            default -> throw new UnsupportedOperationException("Unsupported browser: " + ConfigReader.getProperty("browser"));
        };
    }

}
