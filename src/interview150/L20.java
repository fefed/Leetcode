package interview150;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L20 {
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || (ch == ')' && !(stack.peek() == '(')) || (ch == ']' && !(stack.peek() == '[')) || (ch == '}' && !(stack.peek() == '{'))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 简单写法
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }};

        Stack<Character> stack = new Stack<>();
        stack.add('?');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.get(stack.pop()) != ch) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
