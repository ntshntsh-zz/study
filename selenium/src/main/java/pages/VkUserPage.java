package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class VkUserPage extends WebPage {

    private final static String LOGIN_INPUT = "//input[@id='quick_email']";
    private final static String PASSWORD_INPUT = "//input[@id='quick_pass']";
    private final static String LOGIN_BUTTON = "//button[@id='quick_login_button']";
    private final static String MY_PAGE_MENU_ITEM = "//li[@id='l_pr']";
    private final static String SEND_MSG_BUTTON = "//button[@class='flat_button profile_btn_cut_left']";
    private final static String DIALOG_LINK = "//a[@class='mail_box_header_link']";
    private final static String POPUP_MSG_INPUT = "//div[@id='mail_box_editable']";
    private final static String POPUP_SEND_BUTTON = "//button[@id='mail_box_send']";
    private final static String SUCCESS_BALOON = "//div[@class='top_result_baloon']";
    private final static String MESSAGE = "//div[@class='im-mess--text wall_module _im_log_body']";
    private final static String QUICK_EXPIRE_CHECKBOX = "//div[@id='quick_expire']";

    private final Wait<WebDriver> wait = new WebDriverWait(getDriver(), 10, 1000)
            .withMessage("Элемент не найден");

    public VkUserPage(String urlUserPage) {
        super(urlUserPage);
    }

    public void quickLogin(String login, String password) {

        //необходимо отключить в настройках подтверждение входа!
        inputText(PASSWORD_INPUT, password);
        inputText(LOGIN_INPUT, login);
        btnClick(QUICK_EXPIRE_CHECKBOX);
        btnClick(LOGIN_BUTTON);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MY_PAGE_MENU_ITEM)));

    }

    public VkUserPage openMsgPopup() {
        btnClick(SEND_MSG_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_MSG_INPUT)));
        return this;
    }

    public void sendMsg(String msg) {
        inputText(POPUP_MSG_INPUT, msg);
        btnClick(POPUP_SEND_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_BALOON)));
    }

    public void goToDialog() {

        btnClick(DIALOG_LINK);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MESSAGE)));
    }

    public List<String> getLatestMessages() {

        List<WebElement> latestMessages = getDriver().findElements(By.xpath(MESSAGE));

        return latestMessages.stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
