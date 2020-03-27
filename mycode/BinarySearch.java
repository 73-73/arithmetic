package mycode;

import java.util.Scanner;

/**
 * 二分查找
 *
 * @author pan
 * @create 2020-03-14-13:11
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int target = Integer.parseInt(scanner.nextLine());
            System.out.println(binarySearch(arr, target));
        }

    }

    /**
     * 在数组arr中找到target
     * 0：return -1
     * 1：return arr[0] == target? 0 : -1
     * 1 2 3 arr[0]<target arr[n-1]>target
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr.length == 0 || arr == null) {
            return -1;
        } else if (arr[0] == target || arr[arr.length - 1] == target) {
            return arr[0] == target ? 0 : arr.length - 1;
        } else {
            int left = 0, right = arr.length - 1;
            int mid;
            while (arr[left] <= target && target <= arr[right]) {
                mid = (left + right) / 2;
                if (arr[mid] == target) {
                    return mid;
                }
                if (arr[mid] < target) {
                    left = mid + 1;
                }
                if (arr[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
