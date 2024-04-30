package codingTestFiles.code.leetCode;

public class MergeTree {

    public static void main(String[] args) {
        // root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        TreeNode root1 = null;
        TreeNode root2 = null;

        TreeNode answer = new MergeTree().mergeTrees(root1, root2);
        System.out.println(answer);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode answer = new TreeNode();

        answer = mergeTree(root1, root2, answer);

        return answer;
    }

    public TreeNode mergeTree(TreeNode root1, TreeNode root2, TreeNode root) {
        // Two Tree has val
        if (root1 != null) {
            root.val += root1.val;
        }
        if (root2 != null) {
            root.val += root2.val;
        }
        // all tree are null
        if (root1 == null && root2 == null) {
            return null;
        }
        // some tree is null
        if (root1 == null || root2 == null) {
            if (root1 == null) {
                root1 = new TreeNode();
            }
            if (root2 == null) {
                root2 = new TreeNode();
            }
        }
        // any tree has left child
        if (root1.left != null || root2.left != null) {
            root.left = new TreeNode();
            if (root1.left == null) {
                root1.left = new TreeNode();
            }
            if (root2.left == null) {
                root2.left = new TreeNode();
            }
            mergeTree(root1.left, root2.left, root.left);
        }
        // any tree has right child
        if (root1.right != null || root2.right != null) {
            root.right = new TreeNode();
            if (root1.right == null) {
                root1.right = new TreeNode();
            }
            if (root2.right == null) {
                root2.right = new TreeNode();
            }
            mergeTree(root1.right, root2.right, root.right);
        }
        // two tree right child is all null
        if (root1.right == null && root2.right == null) {
            root.right = null;
        }
        // two tree left child is all null
        if (root1.left == null && root2.left == null) {
            root.left = null;
        }
        return root;
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
