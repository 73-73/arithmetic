package mycode.leetcode;

/**
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pan
 * @create 2019-11-20-9:58
 */
public class Test376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int diff = nums[1] - nums[0];
        int count = diff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            //如果当前差值大于0且前一差值小于0 或者 当前差值小于0且前一差值大于0
            if ((nums[i] - nums[i - 1] > 0 && diff <= 0) || nums[i] - nums[i - 1] < 0 && diff >= 0) {
                count++;
            }
        }
        return count;
    }
}
