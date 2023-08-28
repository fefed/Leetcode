package interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L68 {
    // 分类，硬写
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {

            List<String> tmp = new ArrayList<>();
            int chars = 0; // 加入当前单词前的单词数和总字符数
            while (i < words.length && chars + words[i].length() + tmp.size() <= maxWidth) {
                tmp.add(words[i]);
                chars += words[i].length();
                i++;
            }

            int space = maxWidth - chars;
            StringBuilder str = new StringBuilder();

            int size = tmp.size();
            if (size == 1) {
                str.append(tmp.get(0)).append(" ".repeat(space));
            } else if (i == words.length) {
                for (int j = 0; j < (size - 1); j++) {
                    str.append(tmp.get(j)).append(" ");
                }
                str.append(tmp.get(size - 1)).append(" ".repeat(space - size + 1));
            } else {
                while (space > 0) {
                    for (int j = 0; j < (size - 1); j++) {
                        if (space <= 0) break;
                        tmp.set(j, tmp.get(j) + " ");
                        space--;
                    }
                }
                for (String s : tmp) {
                    str.append(s);
                }
            }

            res.add(str.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new L68().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);

    }
}
