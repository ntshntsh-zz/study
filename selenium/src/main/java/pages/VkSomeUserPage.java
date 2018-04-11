package pages;

import elements.DialogPopup;
import elements.QuickLoginForm;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;

import java.util.List;

public interface VkSomeUserPage extends WebPage{

    @FindBy("//div[@id='quick_login']")
    QuickLoginForm quickLogin();

    @FindBy("//div[@class='box_layout']")
    DialogPopup quickDialog();

    @FindBy("//button[@class='flat_button profile_btn_cut_left']")
    ExtendedWebElement sendMessageButton();

    @FindBy("//div[@class='im-mess--text wall_module _im_log_body']")
    List<ExtendedWebElement> messages();

}
