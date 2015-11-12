package Token;

import org.junit.Test;

public class CharAcceptorTest extends AcceptorTest {
    @Test
    public void it_accepts_chars() {
        Acceptor acceptor = new CharAcceptor('+');
        assertAccepts(acceptor, "+");
        assertAccepts(acceptor, " + ");
    }

    @Test
    public void it_rejects_non_chars() {
        Acceptor acceptor = new CharAcceptor('+');
        assertRejects(acceptor, "1");
        assertRejects(acceptor, "abc");
        assertRejects(acceptor, "");
    }
}