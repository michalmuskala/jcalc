package Token;

import java.io.StreamTokenizer;
import java.util.Optional;

public class NumberAcceptor implements Acceptor {
    public Optional<IToken> accept(StreamTokenizer tokenizer) {
        if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            IToken t = new Number(tokenizer.nval);
            return Optional.of(t);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[double]";
    }
}
