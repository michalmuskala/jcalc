package Token;

import java.io.*;
import java.util.Optional;

import static org.junit.Assert.*;

public abstract class AcceptorTest {
    private StreamTokenizer makeTokenizer(String input) {
        try {
            Reader reader = new BufferedReader(new StringReader(input));
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            tokenizer.nextToken();
            return tokenizer;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    protected void assertRejects(Acceptor acceptor, String string) {
        assertAcceptor(acceptor, string, false, "to reject");
    }

    protected void assertAccepts(Acceptor acceptor, String string) {
        assertAcceptor(acceptor, string, true, "to accept");
    }

    private void assertAcceptor(Acceptor acceptor, String input, boolean result, String msg) {
        StreamTokenizer tokenizer = makeTokenizer(input);
        Optional<IToken> t = acceptor.accept(tokenizer);
        assertTrue("expected " + acceptor + " " + msg + ": '" + input + "'", t.isPresent() == result);
    }
}
