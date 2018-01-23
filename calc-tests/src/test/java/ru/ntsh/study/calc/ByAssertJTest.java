package ru.ntsh.study.calc;

import org.junit.Test;

import static  org.assertj.core.api.Assertions.assertThat;
import static ru.ntsh.study.calc.testdata.CalcTestsData.*;

public class ByAssertJTest {

    private static Calculator CALC = new Calculator();

    @Test
    public void shouldSum()
    {
        assertThat(CALC.getSum(FIRST_VALUE,SECOND_VALUE))
                .isEqualTo(FIRST_VALUE + SECOND_VALUE);
    }
}
