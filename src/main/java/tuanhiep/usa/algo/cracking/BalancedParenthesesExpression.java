package tuanhiep.usa.algo.cracking;

import java.util.Stack;

public class BalancedParenthesesExpression {

    public static void main(String[] args) {

    }

    char[][] tokens = {{'(', ')'}, {'[', ']'}, {'{', '}'}};

    public boolean checkBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenToken(c)) {
                stack.push(c);

            }
            if (isCloseToken(c)) {
                char open = stack.pop();
                if (!isTogether(open, c)) {
                    return false;
                }
            } else {
                return false;
            }


        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }

    private boolean isTogether(char open, char c) {
        for (char[] token : tokens) {
            if (token[0] == open && token[1] == c) {
                return true;
            }
        }
        return false;

    }

    private boolean isCloseToken(char c) {
        for (char[] token : tokens) {
            if (token[1] == c) {
                return true;
            }
        }
        return false;

    }

    private boolean isOpenToken(char c) {
        for (char[] token : tokens) {
            if (token[0] == c) {
                return true;
            }
        }
        return false;
    }


}
