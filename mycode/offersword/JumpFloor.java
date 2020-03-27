package mycode.offersword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 当前n阶的跳法数由前(n-1)阶的跳法数和(n-2)阶的跳法数决定：f(n)=f(n-1)+f(n-2)
 *
 * @author pan
 * @create 2019-11-20-11:19
 */
public class JumpFloor {

    /**
     * 102334155
     * 240ms
     * 102334155
     * 0ms
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpFloor2(39));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    /**
     * 递归斐波那契
     *
     * @param n
     * @return
     */
    public int jumpFloor1(int n) {
        if (n <= 0)
            return 0;
        if (n < 3) {
            return n == 1 ? 1 : 2;
        } else {
            return jumpFloor1(n - 1) + jumpFloor1(n - 2);
        }
    }

    /**
     * 迭代法
     *
     * @param n
     * @return
     */
    public int jumpFloor2(int n) {
        if (n <= 0)
            return 0;
        if (n < 3) {
            return n == 1 ? 1 : 2;
        } else {
            int first = 1, second = 2, third = 0;
            for (int i = 3; i <= n; i++) {
                third = first + second;
                first = second;
                second = third;
            }
            return third;
        }
    }
}
