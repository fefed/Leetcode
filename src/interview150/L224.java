package interview150;

import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L224 {
    ArrayDeque<Character> operators = new ArrayDeque<>();
    ArrayDeque<Integer> nums = new ArrayDeque<>();

    // 双栈法：符号栈+操作数栈
    public int calculate1(String s) {
        s = s.replace(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                int num = 0;
                num += ch - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.push(num);
                i = j - 1;
            } else if (ch == '(') {
                operators.push('(');
            } else if (ch == ')') {
                while (operators.peek() != '(')
                    eval();
                operators.pop();
            } else {
                if (i == 0 || (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-'))
                    nums.push(0);
                while (!operators.isEmpty() && operators.peek() != '(' && nums.size() > 1)
                    eval();
                operators.push(ch);
            }
        }
        while (nums.size() > 1) eval();
        return nums.getFirst();
    }

    private void eval() {
        Character op = operators.pop();
        Integer num2 = nums.pop();
        Integer num1 = nums.pop();
        int res = 0;
        switch (op) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
        }
        nums.push(res);
    }

    // 括号展开+单栈（符号栈）
    // 根据符号栈确定括号展开后当前位置的实际符号
    public int calculate(String s) {
        ArrayDeque<Integer> opStack = new ArrayDeque<>() {{
            offerLast(1);
        }};
        int sign = 1, res = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
            } else if (ch == '+') {
                sign = opStack.peekLast();
                i++;
            } else if (ch == '-') {
                sign = -1 * opStack.peekLast();
                i++;
            } else if (ch == '(') {
                opStack.offerLast(sign);
                i++;
            } else if (ch == ')') {
                opStack.pollLast();
                i++;
            } else {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += (int) (sign * num);
            }
        }
        return res;
    }
}
