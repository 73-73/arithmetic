package mycode.leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author pan
 * @create 2019-11-20-9:10
 */
public class test55 {
    /**
     * 时间复杂度为O(n)，贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int good = nums.length - 1;
        //从倒数第二个点开始遍历数组
        for (int i = nums.length - 2; i >= 0; i--) {
            //当前点可跳距离大于到前一个good点距离，则当前点也为good点
            if (nums[i] >= (good - i)) {
                good = i;//更新good点
            }
        }
        return good == 0;//第一个点是否是good点，是则可跳到终点，否则说明不能跳到终点
    }
}
