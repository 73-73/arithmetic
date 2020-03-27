package mycode.exam.kuaishou;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author pan
 * @create 2020-03-22-19:38
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[][] num = new int[split.length][11];
        for (int i = 0; i < split.length; i++) {
            //把号码转化为整数数组
            for (int j = 0; j < 11; j++) {
                num[i][j] = split[i].charAt(j) - '0';
            }
        }
        ArrayList<PhoneNumber> list = new ArrayList<>();
        //得到后八位的号码数组
        for (int i = 0; i < num.length; i++) {
            int x = isGoodNumber(num[i]);
            if (x > 0) {
                PhoneNumber phoneNumber = new PhoneNumber(x, num[i]);
                list.add(phoneNumber);
            }
        }
        list.sort(new Comparator<PhoneNumber>() {
            @Override
            public int compare(PhoneNumber o1, PhoneNumber o2) {
                return o2.getPriority() - o1.getPriority();
            }
        });
        int count = 0;
        for (PhoneNumber number : list) {
            count++;
            if (count == list.size()) {
                System.out.print(number.toString());
            } else {
                System.out.print(number.toString() + " ");
            }
        }
    }

    /**
     * 判断是否是靓号，并返回优先级
     *
     * @param arr
     * @return
     */
    public static int isGoodNumber(int[] arr) {
        int p = 0;
        int q = 0;
        for (int i = 3; i < 8; i++) {
            p = Math.max(p, isSame(arr, i));
            if (p > 0) {
                continue;
            }
            q = Math.max(q, isOrder(arr, i));
            if (q > 0) {
                continue;
            }
        }
        if (p >= q) {
            return 2 * p;
        }
        if (p < q) {
            return 2 * q - 1;
        }
        return -1;
    }

    /**
     * 判断是否是豹子，是的话返回几位豹子,否则返回-1
     *
     * @return
     */
    public static int isSame(int[] arr, int index) {
        int count = 1;
        while (index < arr.length - 1) {
            if (arr[index] == arr[++index]) {
                count++;
            }
        }
        return count > 2 ? count : -1;
    }

    /**
     * 判断是否有序,并返回优先级
     *
     * @return
     */
    public static int isOrder(int[] arr, int index) {
        int count = 1;
        //降序
        if (arr[index] - arr[index + 1] == 1) {
            index++;
            while (index < arr.length - 1) {
                if (arr[index] - arr[++index] == 1) {
                    count++;
                    continue;
                }
                break;
            }
        }

        if (arr[index] - arr[index + 1] == -1) {
            index++;
            while (index < arr.length - 1) {
                if (arr[index] - arr[++index] == -1) {
                    count++;
                    continue;
                }
                break;
            }
        }
        return count > 2 ? count : -1;
    }
}

class PhoneNumber {
    //优先级
    int priority;
    //号码
    int[] number;

    public PhoneNumber(int priority, int[] number) {
        this.priority = priority;
        this.number = number;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            sb.append(number[i]);
        }
        return sb.toString();
    }
}
