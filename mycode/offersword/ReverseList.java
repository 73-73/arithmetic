package mycode.offersword;

/**
 * @author pan
 * @create 2019-11-20-16:48
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        ListNode listNode1 = reverseList(listNode);
        return;
    }

    /**
     * 输入一个链表，反转链表后，输出链表的所有元素
     * 1-2-3-4-5-null
     * 5-4-3-2-1-null
     *
     * @param head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;

        while (curNode != null) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return preNode;
    }
}
