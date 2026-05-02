package tests.ui;

import base.BaseTest;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.SearchPage;

public class HomePageTests extends BaseTest {
    public final static String SEARCH = "Avatar";
    public final static String SEARCH_NO_RESULT = RandomString.make(10);

    @Test(priority=1)
    public void searchReturnResult() {
        HomePage homePage = new HomePage(driver);
        homePage.setSearchTextBox(SEARCH);
        SearchPage searchPage = homePage.clickSearchButton();
        Assert.assertTrue(searchPage.getResultCount() > 0, "Expected to find at least one result");
    }

    @Test(priority = 2)
    public void noResultSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.setSearchTextBox(SEARCH_NO_RESULT);
        SearchPage searchPage = homePage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultMessage(), "Expected to display no result");
    }

}
