package Token;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {
    @Test
    public void it_has_value() {
        Number n = new Number(1.22);
        assertEquals("1.22", n.getValue());
    }

    @Test
    public void it_has_double_value() {
        Number n = new Number(-2.23);
        assertEquals(-2.23, n.getDoubleValue(), 0);
    }

    @Test
    public void it_has_identity() {
        Number n1 = new Number(123);
        Number n2 = new Number(123);
        Number x = new Number(532.32);

        assertEquals(n1, n2);
        assertNotEquals(n1, x);
    }
}