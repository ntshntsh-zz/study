import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class YandexTest {

    private static String SEARCH_TEXT = "артем ерошенко";

    private YandexSERP yandex;


    @Before
    public void init() {
        yandex = new YandexSERP(ConfigFactory.create(SeleniumConfig.class).urlYandex());

    }

    @After
    public void quit() {
        yandex.quit();
    }

    @Test
    public void shouldSearchByText() {

        yandex.textSearch(SEARCH_TEXT);

        assertThat(yandex.getSerpElementsHighlightedText())
                .containsOnly("Артем", "Ерошенко", "Artem", "Eroshenko");

    }


}
