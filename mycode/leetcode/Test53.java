package mycode.leetcode;

/**
 * @author pan
 * @create 2019-12-02-14:45
 */
public class Test53 {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
