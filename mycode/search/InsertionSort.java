package mycode.search;

/**
 * @author pan
 * @create 2019-11-28-10:59
 */
public class InsertionSort {

    public static int insertionSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        /**
         * 插值查找是在二分查找的基础上，通过比对中间点和target的规律，动态的依据target来动态的选择mid点
         * 可以在数组长度较大，值分布较均匀的情况下获得跟高的效率
         * mid=(low+high)/2, 即mid=low+1/2*(high-low);
         *   通过类比，我们可以将查找的点改进为如下：
         * mid=low+(key-a[low])/(a[high]-a[low])*(high-low)，
         *
         */
        while (left <= right) {
//            int mid = (right + left) / 2; mid = left + 1/2*(right - left)
            int mid = left + ((target - nums[left]) / (nums[right] - nums[left])) * (right - left);
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
