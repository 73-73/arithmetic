package mycode.datastructure.heap;

/**
 * 最大堆的实现：插入，删除，获取当前堆最大的元素
 * 底层由数组实现，只是逻辑上把它抽象成堆，有以下特点：
 * 根节点index = 0
 * 任意节点的左孩子结点 left = 2*i+1
 * 任意节点的右孩子结点 right = 2*i+2
 * 任意结点的父节点 parent = (i-1)/2
 *
 * @author pan
 * @create 2020-03-13-14:21
 */
public class MyHeap {
    private int[] data;
    private int capacity;
    private int size;

    public MyHeap(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public int peek() {
        return data[0];
    }

    /**
     * 删除顶部元素并且返回
     */
    public int delete() {
        int root  = data[0];
        int index = 0;
        data[0] = data[size-1];
        size--;
        //更新当前堆，把根节点放入到正确的位置
        /*while(index < size){

        }*/
        return root;
    }

    public void add(int n) {
        if (size < capacity) {
            int index = size - 1;
            data[index] = n;
            //更新堆
            while (data[(index - 1) / 2] < data[index] && index > 0) {
                int temp = data[(index - 1) / 2];
                data[(index - 1) / 2] = data[index];
                data[index] = temp;
                index = (index - 1) / 2;
            }
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException("堆已满");
        }
    }
}
