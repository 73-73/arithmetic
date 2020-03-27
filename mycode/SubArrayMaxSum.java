package mycode;
/**
 * 给定一个数组arr，返回所有子数组的累加和中，最大的累加和
 * 思路：准备一个cur变量，记录截止到上一个不为0位置到当前位置，数组累加的和为多少。当cur为负数时，置为0（前一小段累加和已经对后面的数造成了负担，所以丢掉）
 * 一个变量max记录当前最大的累加和
 * 遍历数组，更新cur，当cur大于max时，更新数组
 *
 * @author pan
 * @create 2020-03-15-21:36
 */
public class SubArrayMaxSum {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 5, 4, -10, 3, 5, 7};
        int[] arr = {-1,-2,3};
        int maxSum = getMaxSum(arr);
        System.out.println(maxSum);
    }

    public static int getMaxSum(int[] arr) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cur = Math.max(cur+arr[i],arr[i]);
            max = Math.max(cur,max);
        }
        return max;
    }
}
