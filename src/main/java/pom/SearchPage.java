package pom;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By resultCards = By.xpath("//div[contains(@class,'media-card')]");
    private final By movieTitles = By.xpath("//div[contains(@class,'media-card')]//h2");
    private final By noResultMessage = By.cssSelector("div[class='search_results movie '] p");

    public int getResultCount() {
        isVisible(resultCards);
        return driver.findElements(resultCards).size();
    }

    public List<String> getTitles() {
        isVisible(movieTitles);
        return driver.findElements(movieTitles)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isNoResultMessage() {
        return isVisible(noResultMessage);

    }

}
