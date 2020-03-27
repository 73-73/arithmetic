package mycode.exam.baidu;

import java.util.Scanner;

/**
 * @author pan
 * @create 2020-03-14-19:38
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //用于记录第i号员工需要给其购买的果汁种类
        int[] arr = new int[n];
        //用于记录i类饮料需要购买count[i]瓶
        int[] count = new int[k + 1];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
            count[x] = count[x] + 1;
        }
        int result = 0;
        for (int i = 1; i < count.length; i++) {
            result += (count[i] + 1) / 2;
        }
        System.out.println(result);
    }
}
