package pom;

import base.BasePage;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameTextBox = By.xpath("//input[@id='username']");
    private final By passwordTextBox = By.xpath("//input[@id='password']");
    private final By confirmPasswordTextBox = By.xpath("//input[@id='password_confirm']");
    private final By signUpButton = By.xpath("//input[@id='sign_up_button']");
    private final By emailTextBox = By.xpath("//input[@id='email']");

    public RegistrationPage setUsernameTextBox(String username) {
        type(usernameTextBox, username);
        return this;
    }

    public RegistrationPage setPasswordTextBox(String password) {
        type(passwordTextBox, password);
        return this;
    }

    public RegistrationPage setConfirmPasswordTextBox(String confirmPassword) {
        type(confirmPasswordTextBox, confirmPassword);
        return this;
    }

    public RegistrationPage setEmailTextBox(String email) {
        type(emailTextBox, email);
        return this;
    }

    public LoginPage clickSignUpButton() {
        click(signUpButton);
        return new LoginPage(driver);
    }

    public LoginPage registerUser(UserDTO userDTO) {
        return setEmailTextBox(userDTO.email())
                .setPasswordTextBox(userDTO.password())
                .setConfirmPasswordTextBox(userDTO.confirmPassword())
                .setUsernameTextBox(userDTO.username())
                .clickSignUpButton();
    }

}
