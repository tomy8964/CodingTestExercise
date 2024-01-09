package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj16928 {

    public static int M, N, MIN = 10;
    public static int[][] board;
    public static boolean[] visited;
    public static Queue<player> queue = new LinkedList<>();
    public static ArrayList<ArrayList<Integer>> edgeList;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split2 = line.split(" ");
        N = Integer.parseInt(split2[0]);
        M = Integer.parseInt(split2[1]);

        board = new int[10][10];
        visited = new boolean[101];
        edgeList = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int n = 0; n < N + M; n++) {
            String line2 = br.readLine();
            String[] split = line2.split(" ");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            edgeList.get(num1).add(num2);
        }

        queue.add(new player(1, 0));
        bfs();

        bw.write(MIN + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            player start = queue.poll();
            if (start.now == 100) {
                MIN = start.count-1;
                break;
            }
            for (int i = 1; i < 7; i++) {
                if (start.now + i <= 100) {
                    // 이동할 곳에 사다리나 뱀이 있으며 아직 방문 하지 않았음
                    if (!edgeList.get(start.now).isEmpty()) {
                        for (int to : edgeList.get(start.now)) {
                            if (!visited[to]) {
                                queue.add(new player(to, start.count + 1));
                            }
                        }
                    } // 사다리나 뱀이 없으며 아직 방문 하지 않음
                    else {
                        if (!visited[start.now + i]) {
                            queue.add(new player(start.now + i, start.count + 1));
                        }
                    }
                }
            }
        }
    }

    public static class player {
        int now;
        int count;

        public player(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }

}

