import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void initCalc() {
        this.calc = new Calculator();
    }

    @Test
    public void it_adds_integers() {
        assertEquals(2.0, calc.eval("1 + 1"), 0);
        assertEquals(4.0, calc.eval("1 + 3"), 0);
    }

    @Test
    public void it_adds_doubles() {
        assertEquals(3.0, calc.eval("1.5 + 1.5"), 0);
        assertEquals(2.5, calc.eval("1.5 + 1"), 0);
    }

    @Test
    public void it_subtracts_integers() {
        assertEquals(0.0, calc.eval("1 - 1"), 0);
        assertEquals(-2.0, calc.eval("1 - 3"), 0);
    }

    @Test
    public void it_subtracts_doubles() {
        assertEquals(0.0, calc.eval("0.5 - 0.5"), 0);
        assertEquals(1.5, calc.eval("2.5 - 1"), 0);
    }

    @Test
    public void it_multiplies_integers() {
        assertEquals(1.0, calc.eval("1 * 1"), 0);
        assertEquals(3.0, calc.eval("1 * 3"), 0);
    }

    @Test
    public void it_multiplies_doubles() {
        assertEquals(1.5, calc.eval("0.5 * 3"), 0);
        assertEquals(2.8125, calc.eval("2.25 * 1.25"), 0);
    }

    @Test
    public void it_divides_integers() {
        assertEquals(1.0, calc.eval("1 / 1"), 0);
        assertEquals(0.5, calc.eval("1 / 2"), 0);
    }

    @Test
    public void it_divides_doubles() {
        assertEquals(1.0, calc.eval("0.5 / 0.5"), 0);
        assertEquals(10.0, calc.eval("5 / 0.5"), 0);
    }
}
