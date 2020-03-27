package mycode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * n=80000时冒泡排序耗时：11644ms
 * ---------------------------------
 *
 * @author pan
 * @create 2019-11-26-10:57
 */
public class BubbleSort {
    public static void main(String[] args) {
        int n = 80000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("n=" + n + "时冒泡排序耗时：" + (end - start) + "ms");
        System.out.println("---------------------------------");
    }

    /**
     * https://sort.hust.cc/1.bubblesort
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        //循环n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                //将大的元素往后移
                if (arr[j] < arr[j - 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
   /* public static int[] bubbleSort2(int[] arr) {
        // 5 9 7 8 4
        for(int i = 1; i<arr.length;i++){
            for(int j = 0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }*/
}
