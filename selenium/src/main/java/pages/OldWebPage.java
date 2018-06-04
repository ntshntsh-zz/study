package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class OldWebPage {

    private static WebDriver driver;

    public OldWebPage(String url) {
        driver = new SafariDriver();
        driver.get(url);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void inputText(String fieldXpath, String message) {

        WebElement textInput = driver.findElement(By.xpath(fieldXpath));
        textInput.click();
        textInput.sendKeys(message);
        textInput.submit();

    }

    public void btnClick(String btnXpath) {
        WebElement btn = driver.findElement(By.xpath(btnXpath));
        btn.click();
    }

    public void quit() {
        driver.quit();
    }

}
