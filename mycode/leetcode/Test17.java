package mycode.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pan
 * @create 2019-12-02-17:00
 */
public class Test17 {
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits == null) return null;
            List<String> list = new ArrayList();
            HashMap map = new HashMap();
            map.put("2", "abc");
            map.put("3", "def");
            map.put("4", "ghi");
            map.put("5", "jkl");
            map.put("6", "mno");
            map.put("7", "pqrs");
            map.put("8", "tuv");
            map.put("9", "wxyz");
//            digits.charAt()
            return list;
        }
    }
}
