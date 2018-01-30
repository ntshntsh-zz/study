import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class VkUserPage extends WebPage {

    private final static String LOGIN_INPUT = "//*[@id=\"quick_email\"]";
    private final static String PASSWORD_INPUT = "//*[@id=\"quick_pass\"]";
    private final static String LOGIN_BTN = "//*[@id=\"quick_login_button\"]";
    private final static String MY_PAGE = "//*[@id=\"l_pr\"]";
    private final static String SEND_MSG_BTN = "//*[@class=\"flat_button profile_btn_cut_left\"]";
    private final static String DIALOG_LINK = "//*[@class=\"mail_box_header_link\"]";
    private final static String POPUP_MSG_INPUT = "//*[@id=\"mail_box_editable\"]";
    private final static String POPUP_BTN_SEND = "//*[@id=\"mail_box_send\"]";
    private final static String SUCCESS_BALOON = "//*[@class=\"top_result_baloon\"]";
    private final static String MESSAGE = "//*[@class=\"im-mess--text wall_module _im_log_body\"]";

    private final Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000)
            .withMessage("Элемент не найден");

    public VkUserPage(String urlUserPage) {
        super(urlUserPage);
    }

    public void quickLogin(String login, String password) {

        //необходимо отключить в настройках подтверждение входа!
        inputText(LOGIN_INPUT, login);
        inputText(PASSWORD_INPUT, password);
        btnClick(LOGIN_BTN);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MY_PAGE)));

    }

    public VkUserPage openMsgPopup() {
        btnClick(SEND_MSG_BTN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_MSG_INPUT)));
        return this;
    }

    public void sendMsg(String msg) {
        inputText(POPUP_MSG_INPUT, msg);
        btnClick(POPUP_BTN_SEND);
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
