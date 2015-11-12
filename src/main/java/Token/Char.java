package Token;

public class Char implements IToken {
    private final char value;

    public Char(char value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public char getCharValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Char aChar = (Char) o;

        return value == aChar.value;

    }
}
