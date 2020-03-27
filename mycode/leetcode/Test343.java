package mycode.leetcode;

/**
 * 剪绳子，给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author pan
 * @create 2020-03-09-21:38
 */
public class Test343 {
    public static void main(String[] args) {
//        int i = cuttingRope(10);
//        System.out.println(i);


    }
    /**
     * 贪心算法
     * https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        //n = 2 最大值 1 ，n = 3 最大值2
        if( n <= 3){
            return n-1;
        }
        //剩下的转化为n/3的余数，余数为1,n = 3x+1 时，转化为(x-1)*3+4，4的最优解为4，结果为3^x*4
        //余数为2时，转化为x*3+2，结果为3^x*2
        //余数为3时，转为x*3，结果为3^x
        int x = n/3;
        int y = n%3;
        if( y == 1){
            return (int)Math.pow(3,x-1)*4;
        }
        if( y == 2){
            return (int)Math.pow(3,x)*2;
        }
        return (int)Math.pow(3,x);
    }
}
