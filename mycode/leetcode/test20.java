package mycode.leetcode;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author pan
 * @create 2019-11-19-16:10
 */

class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (ch == ')' || ch == '}' || ch == ']') {
                char peek;
                try {
                    peek = stack.peek();
                } catch (Exception e) {
                    return false;
                }
                if (peek == ch) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty() ? true : false;
    }
}