package mycode.exam.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.nowcoder.com/question/next?pid=1088888&qid=36846&tid=31060455
 * 完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * Input Param
 * n               输入随机数的个数
 * inputArray      n个随机整数组成的数组
 * Return Value
 * OutputArray    输出处理后的随机整数
 * 样例输入解释：
 * 样例有两组测试
 * 第一组是3个数字，分别是：2，2，1。
 * 第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
 *
 * @author pan
 * @create 2020-03-04-16:21
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            for (int i = 0; i < x; i++) {
                set.add(scanner.nextInt());
            }
        }
        scanner.close();
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
