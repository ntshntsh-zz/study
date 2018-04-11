import config.SeleniumConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.VkUserPage;
import rules.Repeat;
import rules.RepeatRule;

import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class VkMsgTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    private VkUserPage vk;
    private SeleniumConfig config = ConfigFactory.create(SeleniumConfig.class);

    @Before
    public void init() {
        vk = new VkUserPage(config.vkUrl() + config.vkReciever());
    }

    @After
    public void quit() {
        vk.quit();
    }

    @Test
    @Repeat(10)
    public void shouldSendMessageToUser() {

        String alphabet = "ArtemEroshenko";

        String randomMessage = new Random()
                .ints(10, 0, alphabet.length())
                .mapToObj(i -> String.valueOf(alphabet.charAt(i)))
                .collect(Collectors.joining());

        vk.quickLogin(config.vkSenderLogin(), config.vkSenderPassword());
        vk.openMsgPopup().sendMsg(randomMessage);
        vk.openMsgPopup().goToDialog();

        assertThat(vk.getLatestMessages()).contains(randomMessage);
    }
}
