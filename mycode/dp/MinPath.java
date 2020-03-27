package mycode.dp;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 *
 * @author pan
 * @create 2020-03-15-9:27
 */
public class MinPath {
    public static void main(String[] args) {
//        int[][] m = {
//                {1, 3, 5, 9},
//                {8, 1, 3, 4},
//                {5, 0, 6, 1},
//                {8, 8, 4, 0}};
//        int[][] m = {{1},
//                    {2},
//                    {3}};
        int[][] m = {{1, 2, 3}};
        int minPath = getMinPath(m, m.length - 1, m[0].length - 1);
        System.out.println(minPath);

    }

    public static int getMinPath(int[][] m, int x, int y) {
        //用于表示0，0坐标到i，j坐标需要花费的最小距离
        int[][] dp = new int[m.length][m[0].length];
        //因为只能向下或者向右走，对于第一行和第一列，从0，0位置走到dp[i][j]位置，需要花费最少的路径为m矩阵本身相加
        dp[0][0] = m[0][0];
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        //对于I,J点，它只能从i-1，j往下走，或者从i，j-1往右走，取这两个点花费路径最小的点，与当前点花费路径相加，得到到当前点的最小路径
        int i = 1;
        //逐行填充dp矩阵
        while (i <= y) {
            int j = 1;
            while (j <= x) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
                j++;
            }
            i++;
        }
        return dp[x][y];
    }
}
