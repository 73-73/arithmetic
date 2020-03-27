package mycode.dp;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
 * 数字，能不能累加得到aim，返回true或者false
 *
 * @author pan
 * @create 2020-03-15-10:23
 */
public class MoneyProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        boolean resultRecur = getResultRecur(arr, 0, 0, 1);
        System.out.println(resultRecur);
        System.out.println(getResultDP(arr,1));

    }

    public static boolean getResultRecur(int[] arr, int sum, int i, int target) {
        if (sum == target) {
            return true;
        } else if (i == arr.length) {
            return false;
        } else {
            return getResultRecur(arr, sum + arr[i], i + 1, target)
                    || getResultRecur(arr, sum, i + 1, target);
        }
    }

    public static boolean getResultDP(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        //由基准条件，填充dp
        for (int i = 0; i < dp.length; i++) {
            dp[i][target] = true;
        }
        //依次填充数组中为true的部分
        int i = arr.length;
        while (i > 0) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    dp[i - 1][j] = true;
                    //因为dp当前的行数i对应数组下标的i-1，所以用arr[i-1]
                    if (j - arr[i-1] >= 0) {
                        dp[i - 1][j - arr[i-1]] = true;
                    }
                }
            }
            i--;
        }
        return dp[0][0];
    }
}
