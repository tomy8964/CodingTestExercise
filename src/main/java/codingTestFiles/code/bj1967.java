package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj1967 {

    public static int N, MAX = 0;
    public static int farFrom1 = 1;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<int[]>> edgeList;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edgeList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int n = 0; n < N - 1; n++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int length = Integer.parseInt(split[2]);
            edgeList.get(from).add(new int[]{to, length});
            edgeList.get(to).add(new int[]{from, length});
        }

        // 1 에서 가장 먼 노드를 찾는다.
        visited = new boolean[N + 1];
        dfs(1, 0);


        visited = new boolean[N + 1];
        dfs(farFrom1, 0);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int sum) {
        visited[start] = true;
        if (sum > MAX) {
            MAX = sum;
            farFrom1 = start;
        }

        for (int[] arr : edgeList.get(start)) {
            int to = arr[0];
            int length = arr[1];
            if (!visited[to]) {
                dfs(to, sum + length);
            }
        }
    }
}

