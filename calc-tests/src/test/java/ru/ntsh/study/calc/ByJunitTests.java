package ru.ntsh.study.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.ntsh.study.calc.testdata.CalcTestsData.*;

public class ByJunitTests {

    private static Calculator CALC = new Calculator();

    @Test
    public void shouldSum() {
        assertEquals(CALC.getSum(FIRST_VALUE, SECOND_VALUE),
                FIRST_VALUE + SECOND_VALUE, 0);

    }

    @Test
    public void shouldDiv() {
        assertEquals(CALC.getDiv(FIRST_VALUE, SECOND_VALUE),
                FIRST_VALUE / SECOND_VALUE, 0);
    }

}
