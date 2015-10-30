public class Calculator {
    public double eval(String expr) {
        String[] parts = expr.split("\\s");

        double lhs = Double.parseDouble(parts[0]);
        double rhs = Double.parseDouble(parts[2]);

        char op = parts[1].charAt(0);

        switch (op) {
            case '+':
                return lhs + rhs;
            default:
                throw new RuntimeException("Invalid operation " + op);
        }
    }
}
