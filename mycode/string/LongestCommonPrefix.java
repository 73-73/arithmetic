package mycode.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 最长公共子串
 *
 * @author pan
 * @create 2019-11-22-9:25
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs={"a","a","flight"};
////        String s = longestCommonPrefix(strs);
////        System.out.println(s);
        String s = "a";
        s = s.substring(0, 0);
        System.out.println(s);
    }

    /**
     * mycode.string strin strng stng
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        //默认第一个字符串为最长子串
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }
}