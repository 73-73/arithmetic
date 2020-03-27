package mycode.leetcode;

/**
 * @author pan
 * @create 2019-11-19-19:27
 */
public class test392 {
    public static void main(String[] args) {
        isSubsequence("abc", "aeebqqc");
    }

    public static boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int i = 0;
        for (int j = 0; j < ts.length; j++) {
            if (i < ss.length && ts[j] == ss[i]) {
                i++;
            }
        }
        return i == ss.length ? true : false;
    }
}
