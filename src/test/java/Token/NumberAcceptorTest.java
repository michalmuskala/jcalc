package Token;

import org.junit.Test;

public class NumberAcceptorTest extends AcceptorTest {
    @Test
    public void it_accepts_numbers() {
        Acceptor acceptor = new NumberAcceptor();
        assertAccepts(acceptor, "123");
        assertAccepts(acceptor, "-12.2");
    }

    @Test
    public void it_rejects_non_numbers() {
        Acceptor acceptor = new NumberAcceptor();
        assertRejects(acceptor, "abc");
        assertRejects(acceptor, "+");
        assertRejects(acceptor, "a12v");
        assertRejects(acceptor, "");
    }
}