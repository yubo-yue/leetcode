package leetcode;

import utils.TreeNode;

import java.util.*;

public class L199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int i = 0;
            while (i < sz) {
                TreeNode cur = queue.poll();
                i++;
                if (i == sz) ans.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return ans;
    }
}
