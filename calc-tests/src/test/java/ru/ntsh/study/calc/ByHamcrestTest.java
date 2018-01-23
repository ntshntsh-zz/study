package ru.ntsh.study.calc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.ntsh.study.calc.testdata.CalcTestsData.*;

public class ByHamcrestTest {

    private static Calculator CALC = new Calculator();

    @Test
    public void shouldDiv() {
        assertThat(CALC.getDiv(FIRST_VALUE, SECOND_VALUE),
                equalTo(FIRST_VALUE / SECOND_VALUE));
    }

}
