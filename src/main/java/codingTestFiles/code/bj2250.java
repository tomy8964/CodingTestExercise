package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class bj2250 {

    public static int N = 0, x, maxLevel;
    public static Node rootNode;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Node> tree = new ArrayList<>();
    static int[] levelMinX;
    static int[] levelMaxX;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        levelMaxX = new int[N + 1];
        levelMinX = new int[N + 1];

        // 모든 노드의 부모 -1로 초기화 하여 생성
        for (int i = 0; i <= N; i++) {
            tree.add(new Node(i, null, null));
            // 최대한 큰 수로 초기화
            levelMinX[i] = N;
        }
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int value = Integer.parseInt(split[0]);
            Node node = tree.get(value);

            int leftValue = Integer.parseInt(split[1]);
            if (leftValue != -1) {
                tree.get(leftValue).parent = value;
                node.left = tree.get(leftValue);
            }

            int rightValue = Integer.parseInt(split[2]);
            if (rightValue != -1) {
                tree.get(rightValue).parent = value;
                node.right = tree.get(rightValue);
            }
        }

        for (Node node : tree) {
            if (node.value != 0) {
                if (node.parent == -1) {
                    rootNode = node;
                    break;
                }
            }
        }

        x = 1;
        inorder(rootNode, 1);

        int answerLevel = 0;
        int answerWidth = 0;
        for (int level = 1; level <= maxLevel; level++) {
            if (answerWidth < (levelMaxX[level] - levelMinX[level] + 1)) {
                answerWidth = (levelMaxX[level] - levelMinX[level] + 1);
                answerLevel = level;
            }
        }

        sb.append(answerLevel).append(" ").append(answerWidth);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void inorder(Node node, int level) {
        if (node == null){
            return;
        }

        maxLevel = Math.max(level, maxLevel);

        if (node.left != null) {
            inorder(node.left, level + 1);
        }
        // 가장 왼쪽의 노드일 때
        levelMinX[level] = Math.min(levelMinX[level], x);
        // 현재 노드가 가장 큰 x 좌표이므로
        levelMaxX[level] = x;
        // 그 다음으로 탐색하는 노드의 x 좌표는 + 1 이므로
        x++;
        if (node.right != null) {
            inorder(node.right, level + 1);
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        int parent;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }

}

