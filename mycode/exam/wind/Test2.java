package mycode.exam.wind;
import mycode.offersword.ListNode;
import java.util.ArrayList;

/**
 * @author pan
 * @create 2020-02-24-16:45
 */
public class Test2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        solution2(node, 3);
    }

    //未对输入进行限制
    public static void solution2(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag1 = true, flag2 = true;
        //一次遍历将链表中的数全部加入list中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int right = list.size() - 1;
        int left = 0;
        //前后指针判断是否回文
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                flag1 = false;
            }
            left++;
            right--;
        }
        right = list.size() - 1;
        //倒数第K个位置节点映射在list上的下标
        int index = right - k + 1;
        left = 0;
        while (left < right) {
            //跳过第k个节点
            if (left == index) {
                left++;
            }
            if (right == index) {
                right--;
            }
            if (list.get(left) != list.get(right)) {
                flag2 = false;
            }
            left++;
            right--;
        }
        System.out.println(flag1 + "," + flag2);
    }
}
