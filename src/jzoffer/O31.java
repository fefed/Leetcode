package jzoffer;

import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O31 {
    // 利用辅助栈模拟，空间复杂度O(N)
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int ele : pushed) {
            stack.push(ele);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    // 原数组模拟栈，空间复杂度O(1)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int stkIndex = -1, popIndex = 0;
        for (int ele : pushed) {
            pushed[++stkIndex] = ele; // 入栈
            while (stkIndex >= 0 && pushed[stkIndex] == popped[popIndex]){
                popIndex++;
                stkIndex--; // 出栈
            }
        }
        return stkIndex == -1; // 判断栈是否为空
    }
}
