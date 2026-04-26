package pom;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private final By profileAndSettingLink = By.xpath("//a[@aria-label='Profile and Settings']");
    private final By logoutLink = By.xpath("//a[@title='Logout']");

    ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void openProfileAndSettings() {
        click(profileAndSettingLink);
    }

    public boolean isUserLoggedIn() {
        openProfileAndSettings();
        return isVisible(logoutLink);
    }
}
