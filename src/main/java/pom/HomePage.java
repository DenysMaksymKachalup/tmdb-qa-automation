package pom;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    private final By loginLink =
            By.xpath("//ul[@class='primary']//a[@title='Login'][normalize-space()='Login']");
    private final By joinTmdbLink = By.xpath("//a[normalize-space()='Join TMDB']");
    private final By searchTextBox = By.xpath("//input[@id='inner_search_v4']");
    private final By searchButton = By.xpath("//input[@value = 'Search']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickJoinTmdbLink() {
       click(joinTmdbLink);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void setSearchTextBox(String text) {
        type(searchTextBox, text);
    }

    public void clickSearchButton() {
        click(searchButton);
    }
}
