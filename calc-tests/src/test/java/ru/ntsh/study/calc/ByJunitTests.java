package ru.ntsh.study.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByJunitTests {

    private static Calculator CALC = new Calculator();
    private static float FIRST_VALUE = 5;
    private static float SECOND_VALUE = 0.01F;


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
