package steps;

import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.VkSomeUserPage;

public class SendMessageSteps {

    private static WebDriver driver;
    private static WebPageFactory factory;

    public SendMessageSteps(String url) {
        driver = new SafariDriver();
        driver.get(url);
        factory = new WebPageFactory();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected VkSomeUserPage onVkSomeUserPage() {
        return factory.get(this.getDriver(), VkSomeUserPage.class);
    }

    public void quickLogin(String login, String password){
        onVkSomeUserPage().quickLogin().password().sendKeys(password);
        onVkSomeUserPage().quickLogin().login().sendKeys(login);
        onVkSomeUserPage().quickLogin().quickExpireCheckbox().setChecked(true);

        onVkSomeUserPage().quickLogin().loginButton().click();
    }

    public SendMessageSteps openQuickDialog(){
        onVkSomeUserPage().sendMessageButton().click();
        return this;
    }

    public void sendQuickMessage(String message){
        onVkSomeUserPage().quickDialog().messageInput().sendKeys(message);
        onVkSomeUserPage().quickDialog().sendButton().click();
    }

    public void quit() {
        driver.quit();
    }

}
