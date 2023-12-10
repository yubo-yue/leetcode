package leetcode;

import utils.Node;

public class L116 {
    public Node connect(Node root) {
        if (root == null) return root;

        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;

        //前序位置
        n1.next = n2;
        traverse(n1.left, n1.right);
        traverse(n1.right, n2.left);
        traverse(n2.left, n2.right);
    }
}
