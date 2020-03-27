package mycode.string;

import java.util.HashSet;

/**
 * LeetCode:  给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如`"Aa"`不能当做一个回文字符串。
 * 注意:假设字符串的长度不会超过 1010。
 * 回文串：“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 *
 * @author pan
 * @create 2019-11-25-18:02
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abcbc";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    /**
     * 输入一个由大小写字母构成的字符串，判断其可以构成的最大长度的回文串，输出其最大长度
     * 分析：
     * 1、创建计数变量count
     * 2、将s转化为字符串数组，遍历这个字符串数组，
     * 3、如果当前字符不存在于集合中，则将其加入集合中
     * 4、如果当前字符存在于集合中，则说明两个字母可以构成一个回文串，count+2，并把集合中的元素去掉
     * 5、判断集合中是否还有元素，有则count+1并返回（回文串中间可以有一个落单的字母），无则返回count
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (char ch : chars) {
            if (set.contains(ch)) {
                set.remove(ch);
                count = count + 2;
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }
}
