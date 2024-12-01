package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode makeListNode(int[] a) {
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int i = 0; i < a.length; i++) {
            ListNode cur = new ListNode(a[i]);
            pre.next = cur;
            pre = cur;
        }
        return head.next;
    }

    public static void printListNodes(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
