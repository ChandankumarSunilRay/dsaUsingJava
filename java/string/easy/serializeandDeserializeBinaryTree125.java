package string.easy;

import java.util.*;

public class serializeandDeserializeBinaryTree125 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Codec {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("N,");
                return;
            }

            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }

        public TreeNode deserialize(String data) {
            Queue<String> queue =
                    new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {
            String curr = queue.poll();

            if (curr.equals("N")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(curr));
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);

            return node;
        }
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(curr.val + " ");

            q.offer(curr.left);
            q.offer(curr.right);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();

        String serialized = codec.serialize(root);
        System.out.println("Serialized:");
        System.out.println(serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);

        System.out.println("\nLevel Order After Deserialization:");
        printLevelOrder(deserializedRoot);
    }
}