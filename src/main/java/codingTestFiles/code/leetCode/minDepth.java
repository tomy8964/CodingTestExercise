package codingTestFiles.code.leetCode;

public class minDepth {
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // root = [2,null,3,null,4,null,5,null,6]
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));// 5

        minDepth(root);
        System.out.println(answer);
    }

    public static void minDepth(TreeNode root) {
        dfs(root, 1);
    }

    public static void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            answer = Math.min(answer, depth);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }

    /**
     * Definition for a binary tree node.
     **/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
