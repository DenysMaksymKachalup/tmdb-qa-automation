package tests.ui;

import base.BaseTest;
import dto.UserRegistrationDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.SignUpPage;
import utils.DataProviderUtil;

public class SignUpPageTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @Test(dataProvider = "userRegistrationValidData", dataProviderClass = DataProviderUtil.class)
    public void shouldReturnProfilePage_WhenInputDataIsValid(UserRegistrationDTO userRegistrationDTO) {
        SignUpPage signUpPage = homePage.clickJoinTmdbLink();
        signUpPage.register(userRegistrationDTO);
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(userRegistrationDTO.username(),loginPage.getUsernameFromLogin());
    }
}
