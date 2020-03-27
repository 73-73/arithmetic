package mycode.exam.wind;


/**
 * @author pan
 * @create 2020-02-24-16:30
 */
public class Test1 {
    public MyListNode solution(MyListNode list1, MyListNode list2) {
        MyListNode head = merge(list1, list2);
        MyListNode listNode = reverseList(head);
        return listNode;
    }

    /**
     * 合并链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public MyListNode merge(MyListNode list1, MyListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
            /*左节点更小时，用左节点做头节点返回，否则用list2，
             递归使用Merge方法，找到后面较小的节点使当前节点的next域指向这个节点*/
        else {
            if (list1.val <= list2.val) {
                list1.next = merge(list1.next, list2);
                return list1;
            } else {
                list2.next = merge(list1, list2.next);
                return list2;
            }
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public MyListNode reverseList(MyListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        MyListNode pre = null;
        MyListNode cur = head;
        MyListNode next = head.next;
        while (true) {
            //修改当前指针的next
            cur.next = pre;
            if (next == null) {
                return cur;
            }
            //三个节点都往下移一位
            pre = cur;
            cur = next;
            next = next.next;
        }
    }
}

class MyListNode {
    int val;
    MyListNode next;

    public MyListNode(int value) {
        this.val = value;
    }
}