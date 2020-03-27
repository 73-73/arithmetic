package mycode.offersword;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode next() {
        return this.next;
    }

    public int getVal() {
        return this.val;
    }
}
