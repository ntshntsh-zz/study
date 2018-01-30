import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class VkMsgTest {

    private VkUserPage vk;
    private SeleniumConfig cfg = ConfigFactory.create(SeleniumConfig.class);

    @Before
    public void init() {

        vk = new VkUserPage(cfg.urlVk() + cfg.vkReciever());

    }

    @After
    public void quit() {
        vk.quit();
    }

    @Test
    public void shouldSendMessageToUser() {

        String alphabet = "Artem Eroshenko";

        String randomMessage = new Random()
                .ints(10, 0, alphabet.length())
                .mapToObj(i -> String.valueOf(alphabet.charAt(i)))
                .collect(Collectors.joining());

        vk.quickLogin(cfg.vkSenderLogin(), cfg.vkSenderPassword());
        vk.openMsgPopup().sendMsg(randomMessage);
        vk.openMsgPopup().goToDialog();

        assertThat(vk.getLatestMessages()).contains(randomMessage);

    }

}
