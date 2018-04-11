package elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.Checkbox;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface QuickLoginForm extends ExtendedWebElement{

    @FindBy("//input[@id='quick_email']")
    ExtendedWebElement login();

    @FindBy("//input[@id='quick_pass']")
    ExtendedWebElement password();

    @FindBy("//button[@id='quick_login_button']")
    ExtendedWebElement loginButton();

    @FindBy("//div[@id='quick_expire']")
    Checkbox quickExpireCheckbox();

}
