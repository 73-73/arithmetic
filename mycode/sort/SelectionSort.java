package mycode.sort;

import java.util.Random;

/**
 * n=80000时选择排序耗时：2725ms
 * ---------------------------------
 *
 * @author pan
 * @create 2019-11-26-17:15
 */
public class SelectionSort {
    public static void main(String[] args) {
        int n = 80000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        long start = System.currentTimeMillis();
        selectionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("n=" + n + "时选择排序耗时：" + (end - start) + "ms");
        System.out.println("---------------------------------");
    }

    /**
     * 选择排序：https://sort.hust.cc/2.selectionsort 动图演示更直观
     * 1、每轮选择排序都默认当前位置为最小（大）的元素，将选择标志位置到该位置
     * 2、遍历该位置后的所有元素，如果找到比这个位置还小的元素，则更新位置和值
     * 3、遍历完成后，如果有更新，则将数组互换
     * 4、对比冒泡排序的优点是：不用每次都互换两个数组，每轮排序都只要互换一次，但是时间复杂度还是O(n^2)
     *
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        int min;
        int minIndex;
        //对于长度为n的数组，排出n-1个元素的位置，就可确定排序后的数组
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //更新
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //互换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
