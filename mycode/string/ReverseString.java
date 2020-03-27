package mycode.string;

/**
 * 反转字符串中的每个小字符串并输出，输入的字符串中有下划线。
 * 如abc_def_gh，反转后的结果cba_fed_hg
 *
 * @author pan
 * @create 2020-03-06-13:10
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "abc_def_gh";
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split("_");
        for (int i = 0; i < strs.length; i++) {
            String s1 = reverse(strs[i]);
            sb.append(s1);
            if (i != strs.length - 1) {
                sb.append("_");
            }
        }
        System.out.println(sb.toString());
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        // a b c d
        for (int i = 0; i < chars.length / 2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = c;
        }
        return String.valueOf(chars);
    }
}
