package mycode.exam.kuaishou;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author pan
 * @create 2020-03-22-19:13
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        String[] split = s.split("\\s");
        if (split.length == 0 || split[0].equals("")) {
            System.out.print(-1);
            return;
        }
        maxHeap.add(Integer.parseInt(split[0]));
        for (int i = 1; i < split.length; i++) {
            Integer x = Integer.parseInt(split[i]);
            //如果前面的数大于当前数
            if (!maxHeap.isEmpty() && maxHeap.peek() > x) {
                Integer poll = maxHeap.poll();
                //再次判断堆最大元素是否小于等于当前元素
                if (!maxHeap.isEmpty() && maxHeap.peek() <= x) {
                    list.add(i);
                } else {
                    maxHeap.add(poll);
                }
            }
            maxHeap.add(x);
        }
        if (list.isEmpty()) {
            System.out.print(-1);
            return;
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
