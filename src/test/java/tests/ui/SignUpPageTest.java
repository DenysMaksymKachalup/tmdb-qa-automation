package tests.ui;

import base.BaseTest;
import dto.UserRegistrationDTO;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.SignUpPage;
import utils.DataProviderUtil;

public class SignUpPageTest extends BaseTest {
    private SignUpPage signUpPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        HomePage homePage = new HomePage(driver);
        signUpPage = homePage.clickJoinTmdbLink();
    }

    @Test(dataProvider = "userRegistrationValidData", dataProviderClass = DataProviderUtil.class)
    public void shouldFillUsernameOnLoginPage_WhenInputDataIsValid(UserRegistrationDTO userRegistrationDTO) {
        signUpPage.register(userRegistrationDTO);

        if (signUpPage.isCaptchaPresented()) {
            throw new SkipException("Captcha is present");
        }
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(userRegistrationDTO.username(), loginPage.getUsernameFromLogin());
    }

    @Test(dataProvider = "userWithTakenEmail", dataProviderClass = DataProviderUtil.class)
    public void shouldShowErrorMessage_WhenEmailIsTaken(UserRegistrationDTO userRegistrationDTO) {
        signUpPage.register(userRegistrationDTO);
        if (signUpPage.isCaptchaPresented()) {
            throw new SkipException("Captcha is present");
        }
        Assert.assertTrue(signUpPage.isEmailTakenMessagePresented());

    }

    @Test(dataProvider = "userWithInvalidConfirmPassword", dataProviderClass = DataProviderUtil.class)
    public void shouldShowErrorMessage_WhenConfirmationPasswordInvalid(UserRegistrationDTO userRegistrationDTO) {
        signUpPage.register(userRegistrationDTO);
        if (signUpPage.isCaptchaPresented()) {
            throw new SkipException("Captcha is present");
        }
        Assert.assertTrue(signUpPage.isConfirmationPasswordInvalidMessagePresented());

    }

    @Test(dataProvider = "userWithTakenUsername", dataProviderClass = DataProviderUtil.class)
    public void shouldShowErrorMessage_WhenUsernameIsTaken(UserRegistrationDTO userRegistrationDTO) {
        signUpPage.register(userRegistrationDTO);
        if (signUpPage.isCaptchaPresented()) {
            throw new SkipException("Captcha is present");
        }
        Assert.assertTrue(signUpPage.isUsernameTakenMessagePresented());
    }
}
