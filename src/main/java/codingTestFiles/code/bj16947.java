package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj16947 {

    public static int N;
    public static int[] nodes;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static ArrayList<ArrayList<Integer>> edgeList;
    public static ArrayList<Integer> cycle = new ArrayList<>();
    public static boolean yesCycle = false;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nodes = new int[N + 1];
        visited = new boolean[N + 1];

        edgeList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String[] split1 = line1.split(" ");
            int from = Integer.parseInt(split1[0]);
            int to = Integer.parseInt(split1[1]);
            edgeList.get(from).add(to);
            edgeList.get(to).add(from);
        }

        dfs(1, -1);

        for (int i = 1; i < N + 1; i++) {
            if (edgeList.get(i).size() > 2) {
                if (nodes[i] == 1) queue.add(i);
            }
        }

        visited = new boolean[N + 1];
        bfs();

        for (int i = 1; i < N + 1; i++) {
            if (nodes[i] == 1) {
                sb.append(nodes[i] - 1).append(" ");
            } else sb.append(nodes[i] - 1).append(" ");

        }

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int start = queue.poll();
            visited[start] = true;
            for (int to : edgeList.get(start)) {
                // 순환선이 아니다.
                if (nodes[to] != 1 && !visited[to]) {
                    queue.add(to);
                    nodes[to] = nodes[start] + 1;
                }
            }

        }

    }

    // 순환선을 찾는다.
    // 순환선이면 순환선 안에 속한 노드의 값을 수정한다.
    // 각 역마다 순환선 까지의 거리를 구한다.
    private static void dfs(int start, int last) {
        if (yesCycle) return;
        visited[start] = true;
        cycle.add(start);
        for (int to : edgeList.get(start)) {
            if (!visited[to]) {
                dfs(to, start);
            } // 순환선이다.
            else if (visited[to] && to != last) {
                int cycleStart = cycle.indexOf(to);
                int cycleLast = cycle.lastIndexOf(start);
                for (int i = cycleStart; i <= cycleLast; i++) {
                    Integer index = cycle.get(i);
                    nodes[index] = 1;
                }
                yesCycle = true;
            }
        }
    }
}

