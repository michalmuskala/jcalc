package Token;

public class Number implements IToken {
    private final Double value;

    public Number(double value) {
        this.value = new Double(value);
    }

    public String getValue() {
        return value.toString();
    }

    public double getDoubleValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return !(value != null ? !value.equals(number.value) : number.value != null);

    }
}
