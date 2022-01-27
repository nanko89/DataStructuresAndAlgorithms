import implementations.BalancedParentheses;
import implementations.ReversedList;

public class Main {
    public static void main(String[] args) {
        BalancedParentheses balancedParentheses = new BalancedParentheses("{([])}{}");
        System.out.println(balancedParentheses.solve());

    }
}
