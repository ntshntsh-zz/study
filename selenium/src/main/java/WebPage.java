import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class WebPage {

    private static WebDriver driver;

    public WebPage(String url) {
        driver = new SafariDriver();
        driver.get(url);
    }

    public void inputText (String fieldXpath, String message) {

        WebElement textInput = driver.findElement(By.xpath(fieldXpath));
        textInput.click();
        textInput.sendKeys(message);
        textInput.submit();

    }

    public void quit() {
        driver.quit();
    }

}
