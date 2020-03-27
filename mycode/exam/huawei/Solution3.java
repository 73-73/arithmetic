package mycode.exam.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * @author pan
 * @create 2020-03-04-16:37
 */
public class Solution3 {
    /**
     * 未完成
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            int result = 0;
            for (int i = 2; i < chars.length; i++) {
                if (chars[i] == 'A') {
                    result += 10;
                } else if (chars[i] == 'B') {
                    result += 11;
                } else if (chars[i] == 'C') {
                    result += 12;
                } else if (chars[i] == 'D') {
                    result += 13;
                } else if (chars[i] == 'E') {
                    result += 14;
                } else if (chars[i] == 'F') {
                    result += 15;
                } else if (Character.isDigit(chars[i])) {
                    result += Integer.parseInt(Character.toString(chars[i]));
                }
            }
            System.out.println(result);
        }
    }
}
