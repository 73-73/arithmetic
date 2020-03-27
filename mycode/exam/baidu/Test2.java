package mycode.exam.baidu;

import java.util.*;

/**
 * @author pan
 * @create 2020-03-14-19:51
 */
public class Test2 {
    /**
     * 使用list将所有钱存储起来，使用贪心策略，因为不可找零，每次都拿最大的钱去付工资，不够再找最小的凑
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                queue.offer(money);
            }
            scanner.nextLine();
        }
        scanner.close();
        //可以发工资的月数
        int count = 0;
        //对钞票面额进行排序
        Integer[] arr = new Integer[queue.size()];
        arr =queue.toArray(arr);
        int left = 0, right = arr.length;
        while (right-left> 0) {
            long sum = 0;
            sum = arr[right-1];
            right--;
            if (sum >= m) {
                count++;
                continue;
            } else {
                while (right-left > 0 && sum < m) {
                    sum += arr[left];
                    left++;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
