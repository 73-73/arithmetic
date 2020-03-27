package mycode.sort;

import java.util.Arrays;

/**
 * @author pan
 * @create 2020-03-08-21:41
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 17, 3, 1, 7, 9};
        quickSort(arr, 0, arr.length - 1);//0 6
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 经典快排，类似荷兰国旗问题，每次选一个数作为基准值，小于这个数的放数组左边，大于这个数的放数组右边，
     * 然后得到小于和大于的边界，对这两个子数组再进行快排
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int target = arr[right];
            int[] partition = partition(arr, left, right, target);
            int less = partition[0];
            int more = partition[1];
            quickSort(arr, left, less - 1);
            quickSort(arr, more + 1, right);
        }
    }

    /**
     * 将传进来的数组按照小于target的放在左边，等于target的放在中间，大于target的放在右边
     * 最后将less和more区域的下标传入数组返回
     * =:i++
     * <:arr[i]与arr[left+1]交换，i++,less++
     * >:arr[i]与arr[more-1]交换，more--，i不变
     *
     * @return
     */
    public static int[] partition(int[] arr, int left, int right, int target) {
        int less = left - 1;
        int more = right;
        for (int i = left; i < more; ) {
            if (arr[i] == target) {
                i++;
            }
            if (arr[i] < target) {
                int temp = arr[i];
                arr[i] = arr[less + 1];
                arr[less + 1] = temp;
                i++;
                less++;
            }
            if (arr[i] > target) {
                int temp = arr[i];
                arr[i] = arr[more - 1];
                arr[more - 1] = temp;
                more--;
            }
        }
        int temp = arr[more];
        arr[more] = arr[right];
        arr[right] = temp;
        int[] result = {less + 1, more};
        return result;
    }
}
