package mycode.offersword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author pan
 * @create 2020-02-06-21:14
 */
public class ReverseList2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        ArrayList<Integer> integers = printListFromTailToHead(listNode1);
        System.out.println(integers);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList();
        }
        ArrayList<Integer> arrayList = new ArrayList();
        Stack<Integer> stack = new Stack();
        stack.push(listNode.val);
        ListNode node = listNode.next;
        while (!(node == null)) {
            stack.push(node.val);
            node = node.next;
        }
        for (int i = 0; i < stack.size(); i++) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
