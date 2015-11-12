package Token;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TokenStream {
    private class TokenSpliterator extends Spliterators.AbstractSpliterator<IToken> {
        private final StreamTokenizer tokenizer;
        private final Acceptor acceptor;

        public TokenSpliterator(StreamTokenizer tokenizer, Acceptor acceptor) {
            super(Long.MAX_VALUE, 0);
            this.tokenizer = tokenizer;
            this.acceptor = acceptor;
        }

        public boolean tryAdvance(Consumer<? super IToken> action) throws RuntimeException {
            try {
                if (tokenizer.nextToken() == StreamTokenizer.TT_EOF) {
                    return false;
                }

                Optional<IToken> t = acceptor.accept(tokenizer);
                t.ifPresent(action);
                if (!t.isPresent()) {
                    String message = "Unrecognized token: " + tokenizer.toString();
                    throw new RuntimeException(message);
                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException("IOException when tokenizing: " + e.getMessage());
            }
        }

        private String stringValue(StreamTokenizer tokenizer) {
            switch(tokenizer.ttype) {
                case StreamTokenizer.TT_WORD:
                    return "String(" + tokenizer.sval + ")";
                case StreamTokenizer.TT_NUMBER:
                    return "Double(" + Double.toString(tokenizer.nval) + ")";
                case StreamTokenizer.TT_EOL:
                    return "EOL";
                case StreamTokenizer.TT_EOF:
                    return "EOF";
                default:
                    return String.valueOf((char) tokenizer.ttype);
            }
        }
    }

    private final Acceptor acceptor;

    public TokenStream(Acceptor acceptor) {
        this.acceptor = acceptor;
    }

    public Stream<IToken> stream(Reader reader) {
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        tokenizer.eolIsSignificant(false);
        tokenizer.ordinaryChar('/');
        Spliterator<IToken> spliterator = new TokenSpliterator(tokenizer, acceptor);
        return StreamSupport.stream(spliterator, false);
    }
}
