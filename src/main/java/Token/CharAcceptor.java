package Token;

import java.io.StreamTokenizer;
import java.util.Optional;

public class CharAcceptor implements Acceptor {
    private final char operation;

    public CharAcceptor(char operation) {
        this.operation = operation;
    }

    public Optional<IToken> accept(StreamTokenizer tokenizer) {
        if (tokenizer.ttype == operation) {
            IToken t = new Char(operation);
            return Optional.of(t);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[" + operation + "]";
    }
}
