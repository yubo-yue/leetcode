package demo;

import utils.TreeNode;

public class L114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        //p.right == null
        p.right = right;
    }
}
