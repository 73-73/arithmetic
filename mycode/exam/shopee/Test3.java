package newcode.shopee;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 先看是否递增还是递减
 * 没写完
 *
 * @author pan
 * @create 2020-02-27-19:52
 */
public class Test3 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        boolean order = false;//false表明前段序列是递减的，true表明是递增的
        int k = Integer.valueOf(scanner.nextLine().trim());
        int[] arr = new int[k];
        int count = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
//        System.out.println(k+":"+ Arrays.toString(arr));
        if (k == 1) {
            return 1;
        }
        for (int i = 1; i < k; i++) {
            if (arr[i - 1] < arr[i]) {
                order = true;
                count++;
            }
            if (arr[i - 1] == arr[i]) {
                order = true;
            }
            if (arr[i - 1] > arr[i]) {
                order = false;
            }
        }
        return 0;
    }
}
