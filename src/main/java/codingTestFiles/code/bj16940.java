package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj16940 {

    public static int N;
    public static boolean[] visited;
    public static int[] inputAnswer;
    public static int childIndex;
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

        boolean checkBFS = checkBFS();

        if (inputAnswer[0] != 1) checkBFS = false;

        if (checkBFS) sb.append(1);
        else sb.append(0);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    // 부모 정점에 따라 자식 정점이 오는 순서가 달라진다.
    // 간선의 정보에 따라 판별한다.
    // 무조건 1로 시작하므로
    // 1 다음에 오는 숫자들은 1과 연결된 것들이다.
    // 1 2 3 4
    // 1의 child set
    private static boolean checkBFS() {
        int start = 1;
        visited[start] = true;
        queue.add(start);
        childIndex = 1;

        while (!queue.isEmpty()) {
            start = queue.poll();
            int childCount = 0;
            for (int to : edgeList.get(start)) {
                if (!visited[to]) {
                    visited[to] = true;
                    childCount++;
                }
            }

            for (int i = childIndex; i < childIndex + childCount; i++) {
                // 자식 노드들은 방문 처리를 했으므로
                if (!visited[inputAnswer[i]]) {
                    return false;
                } else queue.add(inputAnswer[i]);
            }
            childIndex += childCount;
        }
        return true;
    }
}

