import Token.*;
import Token.Number;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private TokenStream tokenStream;

    public Calculator() {
        Acceptor acceptor = new AlternativeAcceptor()
                .registerAcceptor(new NumberAcceptor())
                .registerAcceptor(new CharAcceptor('+'))
                .registerAcceptor(new CharAcceptor('-'))
                .registerAcceptor(new CharAcceptor('*'))
                .registerAcceptor(new CharAcceptor('/'));
        this.tokenStream = new TokenStream(acceptor);
    }

    public double eval(String expr) {
        Reader reader = new BufferedReader(new StringReader(expr));

        List<IToken> list = tokenStream.stream(reader).collect(Collectors.toList());

        double lhs = ((Token.Number)list.get(0)).getDoubleValue();
        double rhs = ((Token.Number)list.get(2)).getDoubleValue();

        char op = ((Char)list.get(1)).getCharValue();

        switch (op) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
            default:
                throw new RuntimeException("Invalid operation: '" + op + "'");
        }
    }
}
