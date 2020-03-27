package mycode.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * @author pan
 * @create 2020-03-09-22:28
 */
public class Test13 {
    public static void main(String[] args) {
//        int sum = getSum(1907);
//        System.out.println(sum);
        System.out.println(movingCount(36, 11, 15));
    }

    /**
     * 广度优先搜索，将当前点的下、右点当为树的左子树右子树，但是这样会重复遍历，所以准备一个容易visited，存储遍历过的节点
     * 数位之和运算：获取当前点的坐标，将数位之和累加，判断是否满足小于K，满足则count++，否则弃之，将当前点加入visited
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = 0, y = 0;
        int count = 0;
        if (k >= 0) {
            queue.offer(new int[]{x, y});
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            x = p[0];
            y = p[1];
            //如果未访问过该点
            count++;
            map.put(p[0], p[1]);
            //加入满足条件的点
            if (getSum(x + 1) + getSum(y) <= k && x + 1 < m && y < n && !(map.containsKey(p[0]) && map.get(p[0]) == p[1])) {
                queue.offer(new int[]{x + 1, y});
            }
            if (getSum(x) + getSum(y + 1) <= k && x < m && y + 1 < n && !(map.containsKey(p[0]) && map.get(p[0]) == p[1])) {
                queue.offer(new int[]{x, y + 1});
            }
        }
        return count;
    }

    /**
     * 获得正数的数位之和
     *
     * @return
     */
    public static int getSum(int x) {
        if (x < 9) {
            return x;
        }
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}
