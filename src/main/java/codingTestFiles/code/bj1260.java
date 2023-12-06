package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class bj1260 {

    public static int N;
    public static int M;
    public static int start;
    public static ArrayList<Integer>[] edgeList;
    public static boolean[] visited;
    public static int[] dfsArr;
    public static Queue<Integer> bfs = new ArrayDeque<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        start = Integer.parseInt(split[2]);
        dfsArr = new int[N];
        edgeList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String line1 = br.readLine();
            String[] split1 = line1.split(" ");
            int from = Integer.parseInt(split1[0]);
            int to = Integer.parseInt(split1[1]);
            edgeList[from].add(to);
            edgeList[to].add(from);
            // 작은 수 부터 탐색하기 위해
            Collections.sort(edgeList[from]);
            Collections.sort(edgeList[to]);

        }

        dfs(start);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(start);

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int to : edgeList[start]) {
            if (!visited[to]) {
                dfs(to);
            }
        }
    }

    private static void bfs(int start) {
        bfs.add(start);
        visited[start] = true;

        while (!bfs.isEmpty()) {
            start = bfs.poll();
            sb.append(start).append(" ");
            for (int to : edgeList[start]) {
                if (!visited[to]) {
                    bfs.add(to);
                    visited[to] = true;
                }
            }
        }

    }
}

