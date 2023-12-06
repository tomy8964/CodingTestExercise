package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj1707 {

    public static int V;
    public static int E;
    public static ArrayList<ArrayList<Integer>> edgeList;
    public static int[] color;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {

            String line = br.readLine();
            String[] split = line.split(" ");

            V = Integer.parseInt(split[0]);
            E = Integer.parseInt(split[1]);
            // 레드 : 1, 블루 : -1, 아직 색칠하지 않음 : 0
            color = new int[V + 1];

            edgeList = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                edgeList.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                String line1 = br.readLine();
                String[] split1 = line1.split(" ");
                int from = Integer.parseInt(split1[0]);
                int to = Integer.parseInt(split1[1]);
                edgeList.get(from).add(to);
                edgeList.get(to).add(from);
            }
            boolean yes = false;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    yes = bfs(i);
                }
                if (!yes) break;
            }

            if (yes) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            start = queue.poll();
            for (int to : edgeList.get(start)) {
                // 같은 색으로 칠해져 있으면 이분 그래프가 아니므로 종료
                if (color[to] == color[start]) {
                    return false;
                }
                // 아직 색칠이 되지 않았으면
                if (color[to] == 0) {
                    queue.add(to);
                    color[to] = color[start] * -1;
                }
            }
        }
        return true;
    }
}

