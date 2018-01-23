package ru.ntsh.study.calc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.ntsh.study.calc.testdata.CalcTestsData.*;

public class ByHamcrestTest {

    private static Calculator CALC = new Calculator();

    @Test
    public void shouldSum() {
        assertThat("Результат сложения отличается от ожидаемого!",
                CALC.getSum(FIRST_VALUE, SECOND_VALUE),
                equalTo(FIRST_VALUE/SECOND_VALUE));
    }
    @Test
    public void shouldDiv() {
        assertThat("Результат деления отличается от ожидаемого!",
                CALC.getDiv(FIRST_VALUE, SECOND_VALUE),
                equalTo(FIRST_VALUE / SECOND_VALUE));
    }

}
