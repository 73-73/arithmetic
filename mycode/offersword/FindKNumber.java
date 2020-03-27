package mycode.offersword;

import java.util.Scanner;

/**
 * @author pan
 * @create 2020-02-06-22:01
 */
public class FindKNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println(findValue(k));
    }

    public static Integer findValue(int k) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 0; i < 6; i++) {
            node.next = new ListNode(node.val++);
            node = node.next;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int i = 0;
        while (node1.next != null) {
            if (i == k) {
                node1 = node1.next;
                node2 = node2.next;
            }
            node1 = node1.next;
            i++;
        }
        return node2.val;
    }

}
