package mycode.string;

/**
 * 在一串字符串（txt）中查找是否包含子串（patten）
 *
 * @author pan
 * @create 2019-12-04-9:53
 */
public class Substring {

    public static void main(String[] args) {
        int subString = findSubString("abcdefg", "cde");
    }

    /**
     * 暴力匹配法，找到返回子串第一次出现的下标，否则返回-1
     *
     * @param txt    文本
     * @param patten 待查找的子串
     * @return
     */
    public static int findSubString(String txt, String patten) {
        int m = txt.length();
        int n = patten.length();
        for (int i = 0; i <= m - n; i++) {
            if (txt.charAt(i) == patten.charAt(0)) {
                int j;
                for (j = 0; j < n; j++) {
                    if (txt.charAt(i + j) != patten.charAt(j)) {
                        break;
                    }
                }
                if (j == n) return i;
            }
        }
        return -1;
    }

    public static int findSubStringWithKMP() {
        return -1;
    }
}
