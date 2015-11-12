package Token;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TokenStreamTest {
    private TokenStream tokenStream;

    @Before
    public void initAcceptor() {
        AlternativeAcceptor acceptor = new AlternativeAcceptor();
        acceptor.registerAcceptor(new NumberAcceptor());
        acceptor.registerAcceptor(new CharAcceptor('+'));
        this.tokenStream = new TokenStream(acceptor);
    }

    @Test
    public void it_parses_valid_tokens() {
        List<IToken> extracted = tokenStream.stream(makeReader("12 + 3")).collect(Collectors.toList());
        List<IToken> expected = Arrays.asList(new Number(12), new Char('+'), new Number(3));
        assertEquals(expected, extracted);
    }

    private Reader makeReader(String str) {
        return new BufferedReader(new StringReader(str));
    }
}