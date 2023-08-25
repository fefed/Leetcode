package interview150;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L42 {
    // 分层接雨水
    public int trap1(int[] height) {
        int sum = 0;
        int max = Arrays.stream(height).max().getAsInt();//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    // 按列算
    // 找出每一列的左侧最高和右侧最高，求当前列和其中较小者的差值，
    // 若差值大于0，即为当前列可存储的雨水量
    // 时间O(n²),空间O(1)
    public int trap2(int[] height) {
        int length = height.length, res = 0;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (height[j] > maxLeft)
                    maxLeft = height[j];
            }
            int maxRight = 0;
            for (int j = i+1; j < length; j++) {
                if (height[j] > maxRight)
                    maxRight = height[j];
            }
            int lowMax = Math.min(maxLeft, maxRight);
            if (lowMax > height[i])
                res += lowMax - height[i];
        }
        return res;
    }

    // 动态规划对求两侧最高列的过程进行优化
    // 时间O(n),空间O(n)
    public int trap3(int[] height) {
        int length = height.length, res = 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = length -2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for (int i = 1; i < length - 1; i++) {
            int lowMax = Math.min(maxLeft[i], maxRight[i]);
            if (lowMax > height[i])
                res += lowMax - height[i];
        }
        return res;
    }

    // 双指针优化空间
    // 双指针分别从最左侧和最右侧向中间扫描
    // 1. 起始状态：
    //      left = 0, right = height.length - 1;
    //      若X_left < X_right,那么X1左侧最大值 < Xn-1 < 右侧最大值，可以更新X1
    //      反之，可以更新Xn-2
    // 2. 中间状态：
    //      left = i, right = j;
    //      若X_left < X_right, 又有X0-X_left-1都小于X_right(不然X_right必然先被更新了),
    //      那么X_left左侧最大值 < X_right < 右侧最大值，可以更新X_left
    //      反之，可以更新X_right
    public int trap4(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
                left++;
            }else {
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }

    // 单调栈
    // 时间O(n)，空间最坏O(n)
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int low = height[stack.pop()];
                if (stack.isEmpty())
                    break;
                int minMax = Math.min(height[current], height[stack.peek()]);
                res += (current - stack.peek() - 1) * (minMax - low);
            }
            stack.push(current);
            current++;
        }
        return res;
    }
    public static void main(String[] args) {
        int trap = new L42().trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
