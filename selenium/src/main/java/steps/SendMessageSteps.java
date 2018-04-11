package steps;

import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.element.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.VkSomeUserPage;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static org.hamcrest.CoreMatchers.not;

import java.util.List;
import java.util.stream.Collectors;

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

    public void goToFullDialog(){
        onVkSomeUserPage().quickDialog().fullDialogLink().click();
    }

    public List<String> getLatestMessages() {

        onVkSomeUserPage().messages().get(1).waitUntil(displayed());

        List<ExtendedWebElement> latestMessages = onVkSomeUserPage().messages();

        return latestMessages.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }



    public void quit() {
        driver.quit();
    }

}
