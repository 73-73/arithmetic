package mycode.sort;

import java.util.Random;

/**
 * 希尔排序
 * n=80000时普通插入排序耗时：640ms
 * ---------------------------------
 * n=80000时希尔排序耗时：6ms
 * <p>
 * 八十万数据耗时：n=8000000时希尔排序耗时：3061ms
 * <p>
 * 进程完成，退出码 0
 *
 * @author pan
 * @create 2019-11-27-9:14
 */
public class ShellSort {
    public static void main(String[] args) {
        int n = 8000000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        long start = System.currentTimeMillis();
//        InsertionSort.insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("n=" + n + "时普通插入排序耗时：" + (end - start) + "ms");
        System.out.println("---------------------------------");

        start = System.currentTimeMillis();
        shellSort(arr);
        end = System.currentTimeMillis();
        System.out.println("n=" + n + "时希尔排序耗时：" + (end - start) + "ms");

    }

    /**
     * 希尔排序：
     * 因为插入排序在数据规模较小，数据初步排序的情况下比较高效（如果数据没有初步排序，很多小的元素在后面，
     * 则每趟插入排序的时候都要把后面的小元素慢慢移到前面来，且这个时候数据规模很大，要移很久）
     * 所以构造同时满足两个条件（规模较小，初步排序），来执行插入排序，使插入排序的效率得到提升。
     * 1、取增量，这里取数组长度/2，即每组最多两个元素。
     * 2、对这些组进行插入排序
     * 3、缩小增量，取上一次的增量/2，并对这些增量下的分组进行插入排序
     * 4、重复进行3，直到增量为1，（此时构造出了虽然数据规模可能较大，但是初步有序的数组）进行插入排序，
     * 得到最后排过序的数组
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //将数据分组，对每组都进行插入排序
            for (int i = 0; i < gap; i++) {
                //以gap为增量进行插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
        }
        return arr;
    }
}
