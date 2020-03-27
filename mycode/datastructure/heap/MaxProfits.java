package mycode.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/cbe887812d3041669fc93a0cf5235f63
 * 来源：牛客网
 * <p>
 * 给定两个整数W和K，W代表你拥有的初始资金，K代表你最多可以做K个项目。再给定两个长度为N的正数数组costs[]和profits[]，代表一共有N个项目，costs[i]和profits[i]分别表示第i号项目的启动资金与做完后的利润(注意是利润，如果一个项目的启动资金为10，利润为4，代表该项目最终的收入为14)。你不能并行只能串行地做项目，并且手里拥有的资金大于或等于某个项目的启动资金时，你才能做这个项目。该如何选择做项目，能让你最终的收益最大？返回最后能获得的最大资金
 * [要求]
 * 时间复杂度为O(k \log n)O(klogn)，空间复杂度为O(n)O(n)
 *
 * @author pan
 * @create 2020-03-13-21:13
 */
public class MaxProfits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] casts = new int[n];
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            casts[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }
        long maxGains = getMaxGains(casts, profits, k, w);
        System.out.println(maxGains);
    }

    /**
     * @param casts   项目所需花费
     * @param profits 项目利润
     * @param k       可做项目个数
     * @param w       初始资金
     * @return
     */
    public static long getMaxGains(int[] casts, int[] profits, int k, int w) {
        long maxResult = w;
        //堆中存放索引，在数组中查找对应的利润和成本，可以把两个数组串联起来省去创建对象，优雅！
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //小根堆，根据casts数组
                return casts[o1] - casts[o2];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //大根堆，根据profits数组
                return profits[o2] - profits[o1];
            }
        });
        for (int i = 0; i < casts.length; i++) {
            minHeap.offer(i);
        }
        //当堆不为空且堆顶元素花费小于等于成本时,把他转到利润堆中
        while (!minHeap.isEmpty() && casts[minHeap.peek()] <= w) {
            maxHeap.offer(minHeap.poll());
        }
        for (int i = 0; i < k; i++) {
            int profit = profits[maxHeap.poll()];
            maxResult += profit;
            w += profit;
            //更新堆
            while (!minHeap.isEmpty() && casts[minHeap.peek()] <= w) {
                maxHeap.offer(minHeap.poll());
            }
        }
        return maxResult;
    }
}
