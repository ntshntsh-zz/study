package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class YandexSERPage extends OldWebPage {

    private static final String SERP_ITEM = "//*[@class=\"serp-item\"]";
    private static final String HIGHLITED_TEXT = "//*[@class=\"needsclick\"]";
    private static final String SEARCH_ARROW = "//*[@id=\"text\"]";

    public YandexSERPage(String url) {
        super(url);
    }

    public void textSearch(String text) {
        inputText(SEARCH_ARROW, text);
    }

    public List<String> getSerpElementsHighlightedText() {

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000)
                .withMessage("Элемент не найден");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SERP_ITEM)));

        List<WebElement> clickElements = getDriver()
                .findElements(By.xpath(HIGHLITED_TEXT));

        return clickElements.stream().map(WebElement::getText).collect(Collectors.toList());

    }
}
