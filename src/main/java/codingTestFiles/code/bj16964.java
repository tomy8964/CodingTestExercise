package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bj16964 {

    public static int N;
    public static boolean[] visited;
    public static boolean answer = true;
    public static int[] inputAnswer;
    public static int childIndex = 1;
    public static Queue<Integer> queue = new LinkedList<>();
    public static ArrayList<ArrayList<Integer>> edgeList;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        inputAnswer = new int[N];

        edgeList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String line1 = br.readLine();
            String[] split1 = line1.split(" ");
            int from = Integer.parseInt(split1[0]);
            int to = Integer.parseInt(split1[1]);
            edgeList.get(from).add(to);
            edgeList.get(to).add(from);
        }

        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            inputAnswer[i] = Integer.parseInt(split[i]);
        }

        checkDFS(1);

        if (inputAnswer[0] != 1) answer = false;

        if (answer) sb.append(1);
        else sb.append(0);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    // 1 2 4 3 5
    // 1 3 5 2 4

    private static void checkDFS(int start) {
        if (visited[start]) return;

        // start 정점 방문
        visited[start] = true;
        HashSet<Integer> set = new HashSet<>();
        for (int to : edgeList.get(start)) {
            // 자식 노드면
            if (!visited[to]) set.add(to);
        }

        // 자식이 없으면 더 탐색할 필요가 없으므로 종료
        if (set.isEmpty()) return;

        if (set.contains(inputAnswer[childIndex])) {
            checkDFS(inputAnswer[childIndex++]);
        } else answer = false;
    }
}

