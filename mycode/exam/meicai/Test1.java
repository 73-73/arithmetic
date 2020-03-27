package mycode.exam.meicai;

import java.util.*;

public class Test1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int threeSum(String numstr) {
        String[] strings = numstr.split(",");
        if (strings.length < 3) {
            return 0;
        }
        int[] nums = new int[strings.length];
        //把字符串数组转化为整数数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int count = 0;
        //数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //因为是排序数组，若当前元素大于0，则后面元素肯定没有结果
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //滑动窗口
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    count++;
                    //去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
                //如果sum不为0，会分为小于0 或大于0 两种情况，更新LR
                else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return count;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _numstr;
        try {
            _numstr = in.nextLine();
        } catch (Exception e) {
            _numstr = null;
        }

        res = threeSum(_numstr);
        System.out.println(String.valueOf(res));

    }
}
