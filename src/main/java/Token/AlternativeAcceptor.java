package Token;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class AlternativeAcceptor implements Acceptor {
   private List<Acceptor> acceptors = new ArrayList<>();

    public AlternativeAcceptor registerAcceptor(Acceptor acceptor) {
        acceptors.add(acceptor);
        return this;
    }

    public Optional<IToken> accept(StreamTokenizer tokenizer) {
        return acceptors
                .stream()
                .map(acceptor -> acceptor.accept(tokenizer))
                .flatMap(opt -> opt.map(Stream::of).orElse(Stream.empty()))
                .findFirst();
    }
}
