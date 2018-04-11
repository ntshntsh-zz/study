import config.SeleniumConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import rules.Repeat;
import rules.RepeatRule;
import steps.SendMessageSteps;

import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class VkMessageTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

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
    @Repeat(10)
    public void shouldSendMessageToUser() {

        String alphabet = "ArtemEroshenko";

        String randomMessage = new Random()
                .ints(10, 0, alphabet.length())
                .mapToObj(i -> String.valueOf(alphabet.charAt(i)))
                .collect(Collectors.joining());

        sendMessageSteps.quickLogin(config.vkSenderLogin(), config.vkSenderPassword());
        sendMessageSteps.openQuickDialog()
                .sendQuickMessage(randomMessage);
        sendMessageSteps.openQuickDialog()
                .goToFullDialog();

        assertThat(sendMessageSteps.getLatestMessages()).contains(randomMessage);

    }
}
