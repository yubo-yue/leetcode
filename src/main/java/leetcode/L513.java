package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

public class L513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }
        
        return cur.val;
    }
}
