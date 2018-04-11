import config.SeleniumConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.YandexSERPage;

import static org.assertj.core.api.Assertions.assertThat;


public class YandexTest {

    private static String SEARCH_TEXT = "артем ерошенко";

    private YandexSERPage yandex;


    @Before
    public void init() {
        yandex = new YandexSERPage(ConfigFactory.create(SeleniumConfig.class).yandexUrl());

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
