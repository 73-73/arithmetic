package mycode.datastructure.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数。
 * 请设计一个名叫MedianHolder的结构，MedianHolder可以随时取得之前吐出所有数的中位数。
 * 准备一个大根堆和一个小根堆，数据流中的数据大于大根堆的值时，存入小根堆，小于大根堆的值时，存入大根堆
 * 做到两个堆分别存储更小的和更大的一半数据
 * 当两个堆大小相差大于1的时候，更大的堆堆顶元素往更小的堆移，同时更新两个堆
 * 取出中位数的时候：判断两个堆大小是否一样，一样中位数为：（大根堆堆顶元素+小根堆堆顶元素）/2
 * 堆这个结构在java中可以用优先队列来表示PriorityQueue
 *
 * @author pan
 * @create 2020-03-13-16:21
 */
public class MedianHolder {
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 2, 4, 8, 0};
//        for(int i :arr){
//            minHeap.offer(i);
//            maxHeap.offer(i);
//        }
//        for(int i =0;i<arr.length;i++){
//            System.out.print(minHeap.poll()+" ");
//        }
//        System.out.println();
//        for(int i =0;i<arr.length;i++){
//            System.out.print(maxHeap.poll()+"  ");
//        }
        int median = getMedian(arr);
        System.out.println(median);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int getMedian(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() == 0 || arr[i] < maxHeap.peek()) {
                maxHeap.offer(arr[i]);
                update();
            } else {
                minHeap.offer(arr[i]);
                update();
            }
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }

    /**
     * 如果两个堆大小相差大于1，则平衡两堆的大小
     */
    public static void update() {
        if (Math.abs(maxHeap.size() - minHeap.size()) <= 1) {
            return;
        }
        //大顶堆更多
        else if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        //小顶堆更多
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

}
