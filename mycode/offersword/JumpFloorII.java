package mycode.offersword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 当前n阶的跳法数由前面的跳法数决定：f(n)=f(n-1)+f(n-2)+...+f(1)
 * 这个思路非常清晰：
 * 假设n>=2，第一步有n种跳法：跳1级、跳2级、到跳n级
 * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
 * ......
 * 跳n-1级，剩下1级，则剩下跳法是f(1)
 * 跳n级，剩下0级，则剩下跳法是f(0)
 * 跳n-1级，剩下1级，则剩下跳法是f(1)
 * 跳n级，剩下0级，则剩下跳法是f(0)
 * 所以在n>=2的情况下：
 * f(n)=f(n-1)+f(n-2)+...+f(1)
 * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
 * 所以f(n)=2*f(n-1) 又f(1)=1,所以可得**f(n)=2^(number-1)**
 * 1：1   ：1
 * 2：1+1、2    ：2
 * 3：1+1+1、1+2、2+1、3    ：4
 * 4：1+1+1+1、1+2+1、1+1+2、2+1+1、2+2、1+3、3+1、4    ：8
 *
 * @author pan
 * @create 2019-11-20-11:37
 */
public class JumpFloorII {
    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        int i = jumpFloorII.jumpFloorII(10);//n不能太大，int有限制
        System.out.println(i);
    }

    /**
     * 移位：乘2的n次方    x<<n
     * 除2的n次方    x>>n
     *
     * @param n
     * @return
     */
    public int jumpFloorII(int n) {
        return 2 << (n - 1);
    }

}
