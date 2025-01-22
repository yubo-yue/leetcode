package leetcode;

import utils.ListNode;

public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        int nodeCount = 0;
        while (currentNode != null) {
            nodeCount++;
            currentNode = currentNode.next;
        }
        if (nodeCount < k) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        for (int i = 0; i <k-1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
