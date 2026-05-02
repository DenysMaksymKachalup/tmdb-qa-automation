package pom;

import base.BasePage;
import dto.UserRegistrationDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("password_confirm");
    private final By email = By.id("email");
    private final By signUpButton = By.id("sign_up_button");
    private final By captcha = By.id("captcha-container");
    private final By emailTakenMessage = By.xpath("//li[normalize-space()='Email has already been taken']");
    private final By confirmationPasswordInvalidMessage = By.xpath("//li[normalize-space()='Password and password confirmation do not match']");
    private final By usernameTakenMessage = By.xpath("//li[normalize-space()='Username has already been taken']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUpButton() {
        click(signUpButton);
    }

    public void register(UserRegistrationDTO userDTO) {
        fillForm(userDTO);
        clickSignUpButton();
    }

    public boolean isCaptchaPresented() {
        return isVisible(captcha);
    }

    public boolean isEmailTakenMessagePresented() {
        return isVisible(emailTakenMessage);
    }

    public boolean isConfirmationPasswordInvalidMessagePresented() {
        return isVisible(confirmationPasswordInvalidMessage);
    }

    public boolean isUsernameTakenMessagePresented() {
        return isVisible(usernameTakenMessage);
    }


    private void enterUsername(String usernameText) {
        type(username, usernameText);
    }

    private void enterPassword(String passwordText) {
        type(password, passwordText);
    }

    private void enterConfirmPassword(String confirmPasswordText) {
        type(confirmPassword, confirmPasswordText);
    }

    private void enterEmail(String emailText) {
        type(email, emailText);
    }

    private void fillForm(UserRegistrationDTO userDTO) {
        enterUsername(userDTO.username());
        enterPassword(userDTO.password());
        enterConfirmPassword(userDTO.confirmPassword());
        enterEmail(userDTO.email());
    }
}
