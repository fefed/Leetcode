package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
class O58_2 {

    // 方法一
    /*
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
    }
    */
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
