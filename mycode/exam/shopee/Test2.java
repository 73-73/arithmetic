package newcode.shopee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pan
 * @create 2020-02-27-20:19
 */
public class Test2 {
    public static void main(String[] args) {
        while (true) {
            int solution = solution();
            System.out.println(solution);
        }
    }

    /**
     * 转化为数组，再对数组进行排序，将第n - (2*n-1)个数给取出相加得到结果
     *
     * @return
     */
    public static int solution() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine().trim());
        int[] arr = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        //对数组进行排序
        Arrays.sort(arr);
        int result = 0;
        //找出第n - (2*n-1)个数
        for (int i = n; i < (2 * n); i++) {
            result += arr[i];
        }
        return result;
    }
}
