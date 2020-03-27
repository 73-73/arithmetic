package mycode.string;

/**
 * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author pan
 * @create 2019-11-21-19:29
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "we are c";
        String s1 = replaceSpace3(s);
        System.out.println(s1);
    }

    /**
     * 转化为字符串数组可能有点慢
     *
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }


    public static String replaceSpace2(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }
}
