package mycode.search;

/**
 * 二分查找
 * 插值查找
 *
 * @author pan
 * @create 2019-11-28-9:20
 */
public class BinarySerach {

    /**
     * 输入一个数和一个一个数组，找出这个数在数组中的位置，如果不存在，返回-1；
     *
     * @param target
     * @return
     */
    public static int binarySerach(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //二分查找的代码，对于left和right的-1和+1非常重要，因为在不存在目标值时，不-1和+1，会导致进入死循环
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
