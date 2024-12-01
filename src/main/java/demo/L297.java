package demo;

import utils.TreeNode;

import java.util.LinkedList;

public class L297 {
    public static final String SEP = ",";
    public static final String NULL = "#";

    public static class Codec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return null;
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            String first = nodes.removeFirst();
            if (first.equals(NULL)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }
    }
}
