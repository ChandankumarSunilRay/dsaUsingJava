package string.easy;
import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths100 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        dfs(root, "", ans);

        return ans;
    }

    private void dfs(TreeNode node, String path, List<String> ans) {

        if (node == null) {
            return;
        }

        path += node.val;

        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }
        path += "->";

        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
    }
    public static void main(String[] args) {

        binaryTreePaths100 solution = new binaryTreePaths100();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = solution.binaryTreePaths(root);

        System.out.println("Binary Tree Paths:");

        for (String path : result) {
            System.out.println(path);
        }
    }
}