import config.SeleniumConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.SendMessageSteps;

public class VkMessageTest {

    private SendMessageSteps sendMessageSteps;
    private SeleniumConfig config = ConfigFactory.create(SeleniumConfig.class);

    @Before
    public void init() {
        sendMessageSteps = new SendMessageSteps(config.vkUrl() + config.vkReciever());
    }

    @After
    public void quit() {
        sendMessageSteps.quit();
    }

    @Test
    public void test() {
        sendMessageSteps.quickLogin(config.vkSenderLogin(), config.vkSenderPassword());
        sendMessageSteps.openQuickDialog().sendQuickMessage("test");
    }
}
