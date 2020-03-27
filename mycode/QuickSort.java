package mycode;


/**
 * 经典快排：
 * 思路：将这个数组像荷兰国旗一样，
 * 取最后一个数为num，将数组arr小于num的放在左边，大于num的放在右边，等于num的放在中间
 * 问题：时间复杂度可能会随着数据集的变化而变化，如果这个划分成一个子数组非常大，一个子数组非常小，那时间复杂度就接近O(n^2)了
 * 改进：每次都随机选取一个数作为num，而不是每次都选择数组最后一位
 *
 * @author pan
 * @create 2020-02-17-20:28
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 8, 4, 4, 2, 5};
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] partition = partition(arr, left, right);
            quickSort(arr, 0, partition[0]);
            quickSort(arr, partition[1], arr.length - 1);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int x = arr[right];
        int less = left - 1;
        int more = right + 1;
        for (int i = 0; i < right; ) {
            //荷兰国旗
            //4，5,6，8，4，4，2,5
            //4,5,5,8,4,4,2,6
            //4,4,4,5,5,6,8
            if (arr[i] < x) {
                less++;
                i++;
            } else if (arr[i] > x) {
                swap(arr, i, more - 1);
                more--;
            } else if (arr[i] == x) {
                i++;
            }
        }
        return new int[]{less, more};//less = 2 more = 5
    }

    //交换数组a中的a[i]和a[j]
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
