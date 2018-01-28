import org.aeonbits.owner.Config;

public interface SeleniumConfig extends Config {
    @Key("url.yandex")
    String urlYandex();
}
