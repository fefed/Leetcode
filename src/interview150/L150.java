package interview150;

import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L150 {
    // 栈
    public int evalRPN1(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Integer op1, op2;
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // 数组模拟栈
    public static int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+" -> numStack[index - 2] += numStack[--index];
                case "-" -> numStack[index - 2] -= numStack[--index];
                case "*" -> numStack[index - 2] *= numStack[--index];
                case "/" -> numStack[index - 2] /= numStack[--index];
                default -> numStack[index++] = Integer.parseInt(s);
            }
        }
        return numStack[0];
    }
}
