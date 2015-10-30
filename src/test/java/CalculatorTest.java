import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void it_should_add_integers() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.eval("1 + 1"), 0);
        assertEquals(4.0, calc.eval("1 + 3"), 0);
    }
}
