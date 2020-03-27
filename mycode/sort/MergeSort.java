package mycode.sort;

import java.util.Arrays;

/**
 * 分治思想，给定一个数组，分成左右两部分，对这左右两部分再进行二分，直到分为一组组大小为2的数组，对这个小数组进行小范围排序
 *
 * @author pan
 * @create 2020-03-08-20:33
 */


public class MergeSort {
    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        //对左右两边都递归的进行排序
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        //此时左右两边都分别有序
        merge(arr, L, R);
    }

    private static void merge(int[] arr, int L, int R)  {
        int[] temp = new int[R - L + 1];
        int mid = L + (R - L) / 2;
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                temp[index] = arr[p1];
                p1++;
                index++;
            }
            if (arr[p1] > arr[p2]) {
                temp[index] = arr[p2];
                p2++;
                index++;
            }
        }
        while (p1 <= mid) {
            temp[index] = arr[p1];
            p1++;
            index++;
        }
        while (p2 <= R) {
            temp[index] = arr[p2];
            p2++;
            index++;
        }
        //将辅助数组复制回原数组
        for (int i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 7, 3, 5};
        mergeSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort2(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        mergeSort2(arr, L, mid);
        mergeSort2(arr, mid + 1, R);
        merge2(arr, L, R, mid);
    }

    /**
     * 这个方法的作用是将两段有序子数组合并成一段有序的数组
     *
     * @param arr
     * @param L
     * @param R
     * @param mid
     */
    private static void merge2(int[] arr, int L, int R, int mid) {
        int[] temp = new int[R - L + 1];
        int p1 = L, p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        //将临时数组拷贝回原数组，这里注意数组位置是相对的，并不是从0开始
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }
}
