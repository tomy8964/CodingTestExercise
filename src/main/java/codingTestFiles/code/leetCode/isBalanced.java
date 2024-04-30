package codingTestFiles.code.leetCode;

public class isBalanced {

    public static void main(String[] args) {
        // root = [1,2,2,3,null,null,3,4,null,null,4]
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean answer = false;
        if (root.left != null) {
            answer = isBalanced(root.left);
            if (!answer) {
                return false;
            }
        }
        if (root.right != null) {
            answer = isBalanced(root.right);
            if (!answer) {
                return false;
            }
        }
        answer = Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;

        return answer;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
