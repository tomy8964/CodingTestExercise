package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj11725 {

    public static int N;
    public static int[] parent;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<Integer>> edgeList;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        edgeList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int n = 0; n < N - 1; n++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            edgeList.get(num1).add(num2);
            edgeList.get(num2).add(num1);
        }

        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            visited[start] = true;

            for (int to : edgeList.get(start)) {
                if (!visited[to]) {
                    parent[to] = start;
                    queue.add(to);
                }
            }
        }
    }
}

