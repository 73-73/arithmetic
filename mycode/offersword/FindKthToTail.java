package mycode.offersword;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * @author pan
 * @create 2019-11-20-14:10
 */
public class FindKthToTail {


    /**
     * 对于n长度的链表，倒数第1个节点，需要指针p从head跑n次，倒数第二个节点，需要指针p从head跑n-1次
     * 对于倒数第k个节点，需要指针从head跑n-(k-1)次，即n-k+1次
     *
     * @param head
     * @param n    倒数第n个元素
     * @return
     */
    public ListNode findNthNode(ListNode head, int n) {
        ListNode firstP = head;
        ListNode secondP = head;
        int count = 0;//记录链表长度
        //让firstP指到n-1位置
        for (int i = 0; i < n - 1; i++) {
            firstP = firstP.next;
            count++;
        }
        //开始让secondP跑起来，跑N-(n-1)次，即N-n+1次，找到倒数第n个节点
        for (int i = 0; firstP.next != null; i++) {
            firstP = firstP.next;
            secondP = secondP.next;
            count++;
        }
        if (count < n || n <= 0) return null;
        return secondP;
    }
}

