import org.aeonbits.owner.Config;

public interface SeleniumConfig extends Config {
    @Key("url.yandex")
    String urlYandex();

    @Key("url.vk")
    String urlVk();

    @Key("vk.reciever")
    String vkReciever();

    @Key("vk.sender.login")
    String vkSenderLogin();

    @Key("vk.sender.password")
    String vkSenderPassword();
}
