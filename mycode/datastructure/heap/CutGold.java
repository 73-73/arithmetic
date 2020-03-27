package mycode.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/418d2fcdf7f24d6f8f4202e23951c0da
 * 来源：牛客网
 * <p>
 * 给定一个正数数组arr，arr的累加和代表金条的总长度，arr的每个数代表金条要分成的长度。规定长度为k的金条分成两块，费用为k个铜板。返回把金条分出arr中的每个数字需要的最小代价。
 * [要求]
 * 时间复杂度为O(n \log n)O(nlogn)，空间复杂度为O(n)O(n)
 *
 * @author pan
 * @create 2020-03-13-18:20
 */
public class CutGold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] array = new long[n];
        String[] strs = scanner.nextLine().split("\\s");
        for(int i = 0;i<n;i++){
            array[i] = Long.parseLong(strs[i]);
        }
        long minCast = getMinCast(array);
        System.out.println(minCast);
    }

    /**
     * 思路：贪心算法，从金块的碎片组合到整个金块这个过程来看，每次组合选择两块最小的金块，组合它们花费的代价最小
     * 若每次花费m，组合成一块金块的时候，总花费sum就是把金块切割成数组长度花费最小的代价
     * 实现：1、构造小根堆，每次都从堆中拿出两个最小的数进行组合，把组合的代价记录并累加，再把组合后的数加入堆中，直到堆为空
     * 2、如果对数组排序，那组合后的数要加回去，岂不是又打乱了原有顺序？下次取又要排序后再选择最小的两个数，实现多麻烦
     * 堆就是为这个场景而生的
     *
     * @param arr
     * @return
     */
    public static long getMinCast(long[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        long result = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }
        //对数组构造出了一个最小堆
        while (heap.size() > 1) {
            long x1 = heap.poll();
            long x2 = heap.poll();
            long sum = x1 + x2;
            heap.offer(sum);
            result += sum;
        }
        return result;
    }

}
