import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

public interface SeleniumConfig extends Config {
    @Key("yandex.url")
    String yandexUrl();

    @Key("vk.url")
    String vkUrl();

    @Key("vk.reciever")
    String vkReciever();

    @Key("vk.sender.login")
    String vkSenderLogin();

    @Key("vk.sender.password")
    String vkSenderPassword();
}
