package tests.ui;

import base.BaseTest;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.SearchPage;
import utils.DataProviderUtil;

public class HomePageTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @Test(dataProvider = "validSearchData", dataProviderClass = DataProviderUtil.class)
    public void shouldReturnResult_WhenSearchIsValid(String validSearch) {
        SearchPage searchPage = homePage.search(validSearch);

        Assert.assertTrue(searchPage.getResultCount() > 0, "Expected to find at least one result");
    }

    @Test(dataProvider = "noResultData", dataProviderClass = DataProviderUtil.class)
    public void shouldShowNoResultsMessage_WhenSearchHasNoMatches(String search) {
        SearchPage searchPage = homePage.search(search);

        Assert.assertTrue(searchPage.isNoResultMessage(), "Expected to display no result");
    }

    @Test(dataProvider = "blankData", dataProviderClass = DataProviderUtil.class)
    public void shouldShownNoResultMessage_WhenSearchIsBlank(String search) {
        SearchPage searchPage = homePage.search(search);

        Assert.assertTrue(searchPage.isNoResultMessage(), "Expected to display no result");
    }

}
