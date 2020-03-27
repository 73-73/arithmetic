package mycode.leetcode;

/**
 * @author pan
 * @create 2019-11-19-16:58
 */
public class test22 {
    public static void main(String[] args) {
        Integer i = -123;
        String s = Integer.toString(i);
        System.out.println(s);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = chars.length - 1; j >= 0; j--) {
            sb.append(chars[j]);
        }
        String s1 = sb.toString();
        if (s1.endsWith("-")) {
            s1 = "-" + s1.substring(0, s1.length() - 1);
        }
        System.out.println(Integer.valueOf(s1));
    }
}
