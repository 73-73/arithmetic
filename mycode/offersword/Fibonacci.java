package mycode.offersword;

/**
 * F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 *
 * @author pan
 * @create 2019-11-20-10:59
 */

/**
 * 递归和迭代的对比
 * fibonacciWithRecursion:
 * n=39
 * 63245986
 * 232ms
 * fibonacciWithIteration:
 * n=39
 * 63245986
 * 1ms
 */
public class Fibonacci {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacciWithIteration(39));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    /**
     * 利用递归求解
     *
     * @param n
     * @return
     */
    public int fibonacciWithRecursion(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        else
            return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    /**
     * 采用迭代，将前一位、前两位、当前位用三个变量表示
     *
     * @param n
     * @return
     */
    public int fibonacciWithIteration(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        else {
            int first = 1, second = 1, third = 2;
            for (int i = 3; i <= n; i++) {
                third = first + second;
                first = second;
                second = third;
            }
            return third;
        }
    }
}
