package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O05 {
    public String replaceSpace(String s){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return str.toString();
    }
}
