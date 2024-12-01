package leetcode;

import utils.ListNode;

public class L328 {
    public static void main(String[] args) {
        L328 solution = new L328();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode nodes = ListNode.makeListNode(arr);
        ListNode.printListNodes(nodes);
        solution.oddEvenList(nodes);
        ListNode.printListNodes(nodes);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
                return head;
        ListNode o = head, e = head.next;

        ListNode p = head, q = head.next;
        while (p != null && q != null & p.next != null && q.next != null) {
            p.next = q.next;
            p = q.next;
                q.next = p.next;
                q = p.next;
        }
        p.next = e;

        return o;
    }
}
