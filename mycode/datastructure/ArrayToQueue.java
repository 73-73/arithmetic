package mycode.datastructure;


/**
 * 用一个给定大小的数组，实现一个队列
 * 一个头指针start，一个尾指针end 分别指向模拟队列的头和尾 初始都为0
 * 一个size变量判断当前队列的大小，当size == 0说明队列为空 size == 数组大小 说明队列满
 * 添加操作：往arr[end]添加，size++，end++ （注意，这时end应该可以循环，即到数组最后一位，+1后又回到数组第一位），size == 数组大小时，队列满
 * 取出操作：取出arr[start],start++,size--（此时start也应该可以循环） size == 0队列为空
 * peek操作：返回arr[start]
 * @author pan
 * @create 2020-03-12-14:38
 */
public class ArrayToQueue {
    private int[] arr;
    int size , start , end , capacity;
    public ArrayToQueue(int capacity){
        if(capacity <= 0 ){
            throw  new ArrayIndexOutOfBoundsException("初始大小参数错误");
        }
        this.arr = new int[capacity];
        this.capacity = capacity;
        size = 0;start = 0;end = 0;
    }
    public void add(int n) throws Exception {
        if(size < capacity){
            arr[end] = n ;
            size++;
            end = end == capacity-1 ? 0 : end+1;
        }else{
            throw  new Exception("队列满");
        }
    }
    public int poll() throws Exception {
        if(size > 0){
            int result = arr[start];
            size--;
            start = start == capacity-1 ? 0 : start+1;
            return result;
        }else{
            throw  new Exception("队列空");
        }
    }
    public int peek() throws Exception {
        if(size > 0){
            return arr[start];
        }else{
            throw  new Exception("队列空");
        }
    }

    public static void main(String[] args) {
        ArrayToQueue queue = new ArrayToQueue(2);
        try {
            queue.poll();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        queue.add(3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            queue.add(4);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
