import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void it_should_add_integers() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.eval("1 + 1"), 0);
        assertEquals(4.0, calc.eval("1 + 3"), 0);
    }

    @Test
    public void it_should_subtract_integers() {
        Calculator calc = new Calculator();
        assertEquals(0.0, calc.eval("1 - 1"), 0);
        assertEquals(-2.0, calc.eval("1 - 3"), 0);
    }

    @Test
    public void it_should_multiply_integers() {
        Calculator calc = new Calculator();
        assertEquals(1.0, calc.eval("1 * 1"), 0);
        assertEquals(3.0, calc.eval("1 * 3"), 0);
    }

    @Test
    public void it_should_divide_integers() {
        Calculator calc = new Calculator();
        assertEquals(1.0, calc.eval("1 / 1"), 0);
        assertEquals(0.5, calc.eval("1 / 2"), 0);
    }
}
