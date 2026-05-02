package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;
import utils.DriverManager;


public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterTest
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
