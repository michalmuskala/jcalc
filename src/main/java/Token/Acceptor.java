package Token;

import java.io.StreamTokenizer;
import java.util.Optional;

public interface Acceptor {
    public Optional<IToken> accept(StreamTokenizer tokenizer);
}
