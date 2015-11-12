package Token;

import org.junit.Test;

public class AlternativeAcceptorTest extends AcceptorTest {

    @Test
    public void it_rejects_without_any_acceptors() {
        Acceptor acceptor = new AlternativeAcceptor();

        assertRejects(acceptor, "a");
        assertRejects(acceptor, "1");
        assertRejects(acceptor, "+");
    }

    @Test
    public void it_mimics_other_acceptor_with_one_acceptor() {
        AlternativeAcceptor acceptor = new AlternativeAcceptor();
        acceptor.registerAcceptor(new NumberAcceptor());

        assertAccepts(acceptor, "123");
        assertRejects(acceptor, "abc");
    }

    @Test
    public void it_combines_two_acceptors() {
        AlternativeAcceptor acceptor = new AlternativeAcceptor();
        acceptor.registerAcceptor(new CharAcceptor('+'));
        acceptor.registerAcceptor(new CharAcceptor('-'));

        assertAccepts(acceptor, "+");
        assertAccepts(acceptor, "-");
        assertRejects(acceptor, "12");
        assertRejects(acceptor, "abc");
    }
}