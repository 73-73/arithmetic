package mycode.leetcode;

import java.util.Arrays;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pan
 * @create 2019-12-02-9:43
 */
public class Test134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
//        int i = canCompleteCircuit(gas, cost);
        canCompleteCircuit1(gas, cost);
    }

    /**
     * 12.2思路：利用贪心原理：找出能加最多油的加油站，从这个加油站出发环绕一周，如果能回到起点，则认为有解，
     * 否则找加油次多的加油站，循环，找不到则认为无解
     * 仿佛不好实现且鸡肋？
     */

    /**
     * 遍历：
     * 每次经过加油站油量剩余 s=s+gas[i]-cost[i]
     * s>0,则可以通过此加油站，s<0，则不能通过
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            //起点的加油量少于油耗量
            if (gas[i] < cost[i]) {
                continue;
            }
            int s = 0;
            int j = 0;
            for (; j < len; j++) {
                s = s + gas[(i + j) % len] - cost[(i + j) % len];
                if (s < 0) {
                    break;
                }
            }
            if (j == len) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int[] ints = Arrays.copyOf(gas, gas.length);
        int totalTank = 0, curTank = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank = totalTank + gas[i] - cost[i];
            curTank = curTank + gas[i] - cost[i];
            if (totalTank < 0) {
                startIndex = i + 1;
                totalTank = 0;
            }
        }
        return curTank >= 0 ? startIndex : -1;
    }
}
