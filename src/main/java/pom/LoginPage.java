package pom;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginText = By.xpath("//input[@id='username']");
    private final By passwordText = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login_button']");

    public LoginPage setLoginText(String login) {
        type(loginText, login);
        return this;
    }

    public LoginPage setPasswordText(String password) {
        type(passwordText, password);
        return this;
    }

    public ProfilePage clickLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }

    public ProfilePage login(String username, String password) {
       return setLoginText(username).
                setPasswordText(password)
                .clickLoginButton();
    }

    public String getUsernameFromLogin() {
        return getValue(loginText);
    }
}
