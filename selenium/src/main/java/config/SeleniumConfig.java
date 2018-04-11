package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:testing.properties")
public interface SeleniumConfig extends Config {
    @Key("yandex.url")
    @DefaultValue("https://www.yandex.ru")
    String yandexUrl();

    @Key("vk.url")
    @DefaultValue("https://vk.com")
    String vkUrl();

    @Key("vk.reciever")
    String vkReciever();

    @Key("vk.sender.login")
    String vkSenderLogin();

    @Key("vk.sender.password")
    String vkSenderPassword();
}
