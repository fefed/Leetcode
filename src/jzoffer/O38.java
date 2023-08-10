package jzoffer;

import java.util.*;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O38 {
    // 方法一：全排列变化版，因为需要去重，所以需要排序+剪枝判断
    /*
    ArrayList<String> res = new ArrayList<>();
    char[] values;
    boolean[] isVisited;
    public String[] permutation(String s) {
        values = s.toCharArray();
        isVisited = new boolean[values.length];
        Arrays.sort(values);

        LinkedList<Character> path = new LinkedList<>();
        dfs(path);

        return res.toArray(new String[0]);
    }
    private void dfs(LinkedList<Character> path) {
        if (path.size() == values.length) {
            StringBuilder tmp = new StringBuilder();
            for (Character ch : path) {
                tmp.append(ch);
            }
            res.add(tmp.toString());
            return;
        }
        for (int i = 0; i < values.length; i++) {
            // 如果之前已经遍历过相同分支，不再遍历
            if (isVisited[i] || (i > 0 && values[i] == values[i - 1] && !isVisited[i - 1]))
                continue;
            isVisited[i] = true;
            path.offer(values[i]);
            dfs(path);
            path.removeLast();
            isVisited[i] = false;
        }
    }

     */

    // 方法二：Set去重+交换
    char[] values;
    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        values = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int index) {
        if (index == values.length - 1) {
            res.add(String.valueOf(values));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < values.length; i++) {
            if (set.contains(values[i]))
                continue;
            set.add(values[i]);
            swap(index, i);
            dfs(index + 1);
            swap(i, index);
        }
    }

    private void swap(int i, int j) {
        char tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
