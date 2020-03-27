package mycode.recursion;

/**
 * 题目
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。求N年后，母牛的数量。
 * 思路
 * 所有牛都不会死，且所有成年母牛都可以生出小牛，对于任意一年的牛的数量，是在上一年的基础上，加上所有成年母牛生出来的小牛，得到递推式
 * F(N) = F(N-1) + F(N-3)
 *
 * @author pan
 * @create 2020-03-15-16:26
 */
public class Cow {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int result = getCowsRecur(40);
        long end = System.currentTimeMillis();
        System.out.println(result + "  Recur:time:"+(end - start)+"ms" );

        start = System.currentTimeMillis();
        result = getCows(40);
        end = System.currentTimeMillis();
        System.out.println(result + "  dp:time:"+(end - start)+"ms" );
    }

    public static int getCowsRecur(int n) {
        if (n < 5) {
            return n;
        } else {
            return getCowsRecur(n - 1) + getCowsRecur(n - 3);
        }
    }

    public static int getCows(int n) {
        if (n < 5) {
            return n;
        } else {
            //第i年有arr[i]个母牛
            int[] arr = new int[n + 1];
            for (int i = 1; i < 5; i ++) {
                arr[i] = i;
            }
            for (int i = 5; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i - 3];
            }
            return arr[n];
        }
    }
}
