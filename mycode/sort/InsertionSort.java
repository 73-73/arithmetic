package mycode.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author pan
 * @create 2019-11-26-17:35
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 4, 3, 2, 0, -88};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    /**
     * 1、构造一个有序数组，初始为第一个元素
     * 2、从第二个元素开始遍历后面的所有元素，如果当前元素小于前面的元素，则将当前元素和前一元素互换，
     * 直到找到正确的位置
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                //移动
                arr[j] = arr[j - 1];
                //移动指针
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
