package mycode.exam.meituan;

import java.util.Scanner;

/**
 * @author pan
 * @create 2020-03-12-19:01
 */
public class Test1 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        char[] chs1 = scanner.nextLine().toCharArray();
        char[] chs2 = scanner.nextLine().toCharArray();
        int[][] arr = new int[2][x];
        scanner.close();
        for (int i = 0; i < chs1.length; i++) {
            if (chs1[i] == 'X') {
                arr[0][i] = 1;
            }
        }
        for (int i = 0; i < chs2.length; i++) {
            if (chs2[i] == 'X') {
                arr[1][i] = 1;
            }
        }
        //数组构造完毕，其中1代表不可停留，0代表可停留
        findWay(arr, 0, 0);
        count = count == 0 ? -1 : count;
        System.out.println(count);
    }

    public static void findWay(int[][] arr, int x, int y) {
        if (x == 1 && y == arr[0].length - 1) {
            count++;
            return ;
        }
        //越界
        if (x > 1 || x < 0) {
            return ;
        }
        if (y > arr[0].length - 1) {
            return ;
        }
        if (arr[x][y] == 1) {
            return ;
        }
        //往当前点上右方走
        findWay(arr, x - 1, y + 1);
        //往当前点下右方走
        findWay(arr, x + 1, y + 1);
        //往当前点右方走
        findWay(arr, x, y + 1);
    }
}
