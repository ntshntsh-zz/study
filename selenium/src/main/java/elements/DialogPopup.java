package elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;

public interface DialogPopup extends ExtendedWebElement {

    @FindBy("//div[@id='mail_box_editable']")
    ExtendedWebElement messageInput();

    @FindBy("//button[@id='mail_box_send']")
    ExtendedWebElement sendButton();

    @FindBy("//a[@class='mail_box_header_link']")
    ExtendedWebElement fullDialogLink();

}
