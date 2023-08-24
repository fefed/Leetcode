package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L134 {
    // 暴力做法：O(n²)
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int length = gas.length;
        if (length == 1 && gas[0] == cost[0])
            return 0;
        // 尝试从每一个栈顶出发
        for (int i = 0; i < length; i++) {
            if (gas[i] <= cost[i])
                continue;
            int curGas = 0;
            boolean haveGas = true;
            // 前进
            for (int j = 0; j < length; j++) {
                int index = (i + j) % length;
                // 到达下一站汽油余量
                curGas += gas[index] - cost[index];
                if (curGas < 0) {
                    haveGas = false;
                    break;
                }
            }
            if (haveGas)
                return i;
        }
        return -1;
    }

    // 优化做法：0(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int spare = 0, minSpare = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < length; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        // 正常版本返回
//        return spare < 0 ? -1 : (minIndex + 1) % length;
        // 对多解情况，返回0
        if (spare < 0) return -1;
        else if (minSpare >= 0) return 0;
        else return (minIndex + 1) % length;
    }
}
