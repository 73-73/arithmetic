package mycode.datastructure;

/**
 * @author pan
 * @create 2020-01-11-17:51
 */
public class StackWhitNode<Item> {

    /**
     * 定义链表
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * 栈顶元素节点
     */
    private Node first;
    private static int N = 0;

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     */
    public Item pop() throws Exception {
        if (!isEmpty()) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        } else {
            throw new Exception("栈为空");
        }
    }

    /**
     * 查看栈顶元素但不弹出
     *
     * @return 栈顶元素
     */
    public Item seek() {
        return first.item;
    }

    /**
     * 压入堆栈
     *
     * @param item
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回栈的大小
     *
     * @return 栈的大小
     */
    public int size() {
        return N;
    }
}
