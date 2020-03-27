package mycode.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pan
 * @create 2019-12-10-8:30
 */
public class Test3 {
    public static void main(String[] args) {
        String s = "abccdeuuoiyi";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        List<Character> list = new ArrayList();
        Set<Integer> treeSet = new TreeSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!list.contains(ch)) {
                list.add(ch);
                count++;
            } else {
                list.removeAll(list);
                list.add(ch);
                treeSet.add(count);
                count = 1;
            }
        }
        return treeSet.isEmpty() ? count : ((TreeSet<Integer>) treeSet).last();
    }
}
