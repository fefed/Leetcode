package interview150;

import java.nio.file.Path;
import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L71 {
    // 简化unix路径
    // 方法一：一句
    public String simplifyPath1(String path) {
        return Path.of(path).normalize().toString();
    }

    // 方法二：以两个斜杠间的目录划分处理，用栈存储
    public String simplifyPath2(String path) {
        int n = path.length();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i < n; i++) {
            if (path.charAt(i) == '/')
                continue;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            String dir = path.substring(i, j);
            if ("..".equals(dir)) {
                if (!stack.isEmpty())
                    stack.pollLast();
            } else if (!".".equals(dir)) {
                stack.addLast(dir);
            }
            i = j;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollFirst());
        }
        return res.isEmpty() ? "/" : res.toString();
    }

    // 方法三：利用split划分dir
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");

        for (String dir : dirs) {
            if ("..".equals(dir)) {
                if (!stack.isEmpty())
                    stack.pollLast();
            } else if (!dir.isEmpty() && !".".equals(dir)) {
                stack.addLast(dir);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollFirst());
        }
        return res.isEmpty() ? "/" : res.toString();
    }
}
