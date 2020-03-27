package mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author pan
 * @create 2019-11-20-16:37
 */
public class test26 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        List list = new ArrayList();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) list.add(nums[i]);
        }
        return list.size();
    }
}
