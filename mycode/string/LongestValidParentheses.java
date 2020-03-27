package mycode.string;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author pan
 * @create 2020-03-01-15:47
 */
public class LongestValidParentheses {

    /**
     * (()())()()
     * 00204608010
     * 采用动态规划：制定一个dp数组：表示当前下标的括号所代表的最大有效括号长度
     * (())
     * ()()(())
     * 0204
     * 如果对应的字符数组字符为（，则元素为0
     * 如果为），则判断chars[i-dp[i-1]]是否为(
     * chars：     ( ( ) )
     * dp下标:     0 1 2 3
     * dp数组元素：0 0 2 4
     * 对于dp[3] 它是否是有效括号应该是看chars[0]的括号状态，这个0这个下标如何来的：i-1-dp[i-1]
     * 所以：如果判断chars[0]是)，则当前下标括号能组成的有效括号长度最小为dp[i-1]+2
     * 但是这里有个问题：就是情况如
     * * ( ) ( ( ) )
     * * 0 1 2 3 4 5
     * * 0 2 0 0 2 6
     * chars：     ( ( ) ) ( )
     * dp下标:     0 1 2 3 4 5
     * dp数组元素：0 0 2 4 0
     * 对于dp[5],此时要判断下标为：5-1-dp[4]的下标的括号是否为（，是则原基础上+2，那这样就扣掉了chars[0]-chars[4]的情况
     * 解决办法：当前下标的长度由三部分组成：配对成功的长度（2）+前一下标的最大长度（dp[i-1]）{可能是(())的情况}+前前段最大长度（配对的(的前一个dp值：dp[i-1-dp[i-1]-1]）
     * 归纳得出：如果当前字符为)，匹配字符下标为i-1-dp[i-1],
     * 如果匹配成功，当前dp值为：2+dp[i-1]+dp[i-1-dp[i-1]-1]
     * 防止数组越界，i从1开始（第一位也不可能匹配）  在（（））情况时：i - 1 - dp[i - 1] - 1 = 3-1-2-1=-1，为防止数组越界，增加判断，小于0 直接置为0
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s == "") {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else if (chars[i] == ')') {
                int pre = i - 1 - dp[i - 1];
                if (chars[pre] == '(') {
                    dp[i] = 2 + dp[i - 1] + dp[(pre - 1) < 0 ? 0 : (pre - 1)];
//                    dp[i] = 2 + dp[i - 1] + dp[(i - 1 - dp[i - 1] - 1)<0?0:(i - 1 - dp[i - 1] - 1)];
                    max = Math.max(dp[i], max);
                } else {
                    dp[i] = 0;
                }
            }
        }
        return max;
    }
}
