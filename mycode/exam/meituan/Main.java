package mycode.exam.meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。
 * <p>
 * 请问众数最多出现多少次。
 * 5 2
 * 3 1 3 2 5
 * 3
 *
 * @author pan
 * @create 2020-03-12-19:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1s = scanner.nextLine().split("\\s");
        String[] str2s = scanner.nextLine().split("\\s");
        int n = Integer.parseInt(str1s[0]);
        int[] arr = new int[n];
        int[] arrOrX = new int[n];
        int x = Integer.parseInt(str1s[1]);
        //准备两个数组，另外一个数组元素全是原数组与x相或的数
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str2s[i]);
            arrOrX[i] = arr[i] | x;
        }
        //从输入获得两个数组
        System.out.println(getMax(arr, arrOrX));
    }

    /**
     * 从两个数组中找出最多众数的次数
     *
     * @return
     */
    public static int getMax(int[] arr, int[] arrOrx) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            //如果两个数一样，则执行一遍逻辑即可
            if (arr[i] == arrOrx[i]) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            //分别对这两个数放入map中
            else {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
                if (map.containsKey(arrOrx[i])) {
                    map.put(arrOrx[i], map.get(arrOrx[i]) + 1);
                } else {
                    map.put(arrOrx[i], 1);
                }
            }
        }
        //找到map集合中value最大的数
        for (Integer x : map.values()) {
            count = Math.max(x, count);
        }
        return count;
    }
}
