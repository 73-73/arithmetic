package mycode.exam.meicai;

import java.util.*;

/**
 * 有 n 个箱子，编号为0 到 n-1，每个箱子上都标有一个数字，这些数字存在数组 boxs 中。
 * <p>
 * 现在要求你拿走所有的箱子。每当你拿走一个箱子 i 时，你可以获得 boxs[left] * boxs[i] * boxs[right] 个乒乓球。 这里的 left 和 right 代表和 i 相邻的两个箱子的序号。
 * <p>
 * 求所能获得乒乓球的最大数量。
 */
public class Test2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int maxBalls(int[] boxs) {
        //贪心策略，使更大的尽可能的相乘，最先抽掉数组中间更小的数
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return boxs[o1] - boxs[o2];
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < boxs.length - 1; i++) {
            heap.add(i);
        }
        while (!heap.isEmpty()) {
            int i = heap.poll();
            int x = boxs[i];
            int left = i - 1;
            while (left > 0 && list.contains(left)) {
                left--;
            }

            int right = i + 1;
            while (right < boxs.length-1 && list.contains(right)) {
                right++;
            }
            list.add(i);
            sum += x * boxs[left] * boxs[right];
        }
        //处理数组两边
        sum += boxs[0] * boxs[boxs.length - 1];
        sum += Math.max(boxs[0], boxs[boxs.length - 1]);
        return sum;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _boxs_size = 0;
        _boxs_size = Integer.parseInt(in.nextLine().trim());
        int[] _boxs = new int[_boxs_size];
        int _boxs_item;
        for (int _boxs_i = 0; _boxs_i < _boxs_size; _boxs_i++) {
            _boxs_item = Integer.parseInt(in.nextLine().trim());
            _boxs[_boxs_i] = _boxs_item;
        }

        res = maxBalls(_boxs);
        System.out.println(String.valueOf(res));

    }
}

