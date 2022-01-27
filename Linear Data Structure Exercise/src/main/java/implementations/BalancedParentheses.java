package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Character> openParentheses = new ArrayDeque<>();
        boolean isBalanced = false;

        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                if (!isBalanced) {
                    openParentheses.push(current);
                }else {
                    return false;
                }
            } else {
                if (openParentheses.isEmpty()){
                    return false;
                }

                if (current == ')') {
                    if (openParentheses.poll() != '(') {
                        return false;
                    }else {
                        isBalanced = true;
                    }
                } else if (current == '}') {

                    if (openParentheses.poll() != '{') {
                        return false;
                    }else {
                        isBalanced = true;
                    }
                } else if (current == ']') {
                    if (openParentheses.poll() != '[') {
                        return false;
                    }else {
                        isBalanced = true;
                    }
                }
            }
        }

        return true;
    }
}
