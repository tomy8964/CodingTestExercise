package codingTestFiles.code.leetCode;

import java.util.List;

public class MaximumDepthofNArrTree {
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
            Node root = new Node(1,
                List.of(
                        new Node(2),
                        new Node(3,
                                List.of(
                                        new Node(6),
                                        new Node(7,
                                                List.of(
                                                        new Node(11,
                                                                List.of(
                                                                        new Node(14)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        new Node(4,
                                List.of(
                                        new Node(8,
                                                List.of(
                                                        new Node(12)
                                                )
                                        )
                                )
                        ),
                        new Node(5,
                                List.of(
                                        new Node(9,
                                                List.of(
                                                        new Node(13)
                                                )
                                        ),
                                        new Node(10)
                                )
                        )
                )
        );

        maxDepth(root);
        System.out.println(answer);
    }

    public static void maxDepth(Node root) {
        dfs(root, 1);
    }

    private static void dfs(Node root, int depth) {
        if (root.children.isEmpty()) {
            answer = Math.max(answer, depth);
            return;
        }
        for (Node child : root.children) {
            dfs(child, depth + 1);
        }
    }


    /**
     * Definition for a Node
     **/
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
