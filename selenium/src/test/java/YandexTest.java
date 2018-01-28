import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;


public class YandexTest {

    private static String SEARCH_ARROW = "//*[@id=\"text\"]";
    private static String SEARCH_TEXT = "артем ерошенко";

    @Test
    public void shouldSearchByText() {

        WebPage yandex = new WebPage(ConfigFactory.create(SeleniumConfig.class).urlYandex());

        yandex.inputText(SEARCH_ARROW, SEARCH_TEXT);

        yandex.quit();
    }


}
