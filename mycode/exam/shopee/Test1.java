package newcode.shopee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 判断输入是否是回文数
 *
 * @author pan
 * @create 2020-02-29-10:57
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //去除双引号和空格方便处理
        String s1 = s.replaceAll("", "'");
        scanner.close();
    }

    /**
     * 获取元素一个[]为界的字符串，找出里面所含的元素以\n连接
     * 准备一个HashMap存储分界符和下标{ [  ]}
     * 将所有元素存放于list集合中
     *
     * @param
     * @return
     */
    /*public static ArrayList<String> solution(String s ){
        ArrayList<String > list = new ArrayList<>();
        boolean flag = false ;//为true说明前面有一个"
        //忽略第一个[
        for(int i = 1 ;i<s.length();i++){
            int j;
            if(s.charAt(i)==']'){
                return list ;
            }
            //如果是
            else if(s.charAt(i)==''){
                j = i;
                flag = true;
            }
        }
    }*/
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.print("False");
                return;
            }
            left++;
            right--;
        }
        System.out.print("True");
    }

    public static void test2() {
        //将输入字符串转化为整数数组
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);
        if (substring.equals("")) {
            System.out.println("[]");
            return;
        }
        String[] split = substring.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i].trim());
        }
        //执行方法
        int[] counts = solution2(arr);
        System.out.println(Arrays.toString(counts));
    }

    /**
     * 输入一个数组，返回counts结果
     *
     * @param arr
     * @return
     */
    private static int[] solution2(int[] arr) {
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts;
    }
}
