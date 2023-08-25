package interview150;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L135 {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i -1])
                candy[i] = candy[i-1]+1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i+1])
                candy[i] = candy[i+1]+1;
        }
        int res = 0;
        for (int num : candy) {
            res += num;
        }
        return res;
    }
}
