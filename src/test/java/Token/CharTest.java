package Token;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharTest {

    @Test
    public void it_has_value() {
        Char c = new Char('a');
        assertEquals("a", c.getValue());
    }

    @Test
    public void it_has_charValue() {
        Char c = new Char('z');
        assertEquals('z', c.getCharValue());
    }

    @Test
    public void it_has_identity() {
        Char c1 = new Char('c');
        Char c2 = new Char('c');
        Char x = new Char('x');

        assertEquals(c1, c2);
        assertNotEquals(c1, x);
    }
}