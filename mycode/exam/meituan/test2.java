package mycode.exam.meituan;

/**
 * @author pan
 * @create 2020-03-12-20:46
 */
public class test2 {
    public static int count = 0;

/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] chs1 = scanner.nextLine().toCharArray();
        char[] chs2 = scanner.nextLine().toCharArray();
        int[][] arr = new int[2][n];
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        scanner.close();
        for (int i = 0; i < chs1.length; i++) {
            if (chs1[i] == 'X') {
                arr[0][i] = 1;
                dp[0][i] = -1;
            }
            if (chs2[i] == 'X') {
                arr[1][i] = 1;
                dp[0][i] = -1;
            }
        }
        for (int x = 1; x < dp[0].length; x++) {
            if (dp[0][x - 1] != -1 && dp[0][x] != -1) {
                dp[0][x] += dp[0][x - 1];
            }
            if (dp[1][x - 1] != -1 && dp[0][x] != -1) {
                dp[0][x] += dp[1][x - 1];
            }
            if (dp[0][x - 1] != -1 && dp[1][x] != -1) {
                dp[0][x] += dp[0][x - 1];
            }
            if (dp[1][x - 1] != -1 && dp[1][x] != -1) {
                dp[0][x] += dp[1][x - 1];
            }
        }
        System.out.println(dp[1][n - 1]);
    }*/
}
