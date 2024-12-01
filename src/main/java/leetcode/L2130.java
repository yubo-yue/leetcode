package leetcode;

import utils.ListNode;

public class L2130 {

    public static void main(String[] args) {
        L2130 solution = new L2130();
        ListNode head = ListNode.makeListNode(new int[]{5,4,2,1});
        int r = solution.pairSum(head);
        System.out.println(r);
    }
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        if (head.next == null) {
            return head.val;
        }

        ListNode p = head, q = head.next;
        while (q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        p = p.next;
        p = reverse(p);

        q = head;
        int ans = Integer.MIN_VALUE;
        while (q != null && p != null) {
            ans = Math.max(q.val + p.val, ans);
            q = q.next;
            p = p.next;
        }

        return ans;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
