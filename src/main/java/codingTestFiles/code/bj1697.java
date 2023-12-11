package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class bj1697 {

    public static int N, K;
    public static boolean[] visited = new boolean[100001];
    public static int[] answer = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static int MIN = 11;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        bfs(N);

        bw.write(answer[K] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            visited[start] = true;
            int moveLeft = start - 1;
            int moveRight = start + 1;
            int teleport = start * 2;
            if (teleport <= 100000) {
                // 방문 안했으면 값 업데이트
                if (!visited[teleport]) {
                    queue.add(teleport);
                    answer[teleport] = answer[start] + 1;
                    visited[teleport] = true;
                } else {
                    // 방문했었지만
                    // 지금 방법이 더 빠른 경우
                    if (answer[teleport] > answer[start] + 1) {
                        queue.add(teleport);
                        answer[teleport] = answer[start] + 1;
                    }
                }
            }
            if (moveLeft >= 0){
                // 방문 안했으면 값 업데이트
                if (!visited[moveLeft]) {
                    queue.add(moveLeft);
                    answer[moveLeft] = answer[start] + 1;
                    visited[moveLeft] = true;
                } else {
                    // 지금 방법이 더 빠른 경우
                    if (answer[moveLeft] > answer[start] + 1) {
                        queue.add(moveLeft);
                        answer[moveLeft] = answer[start] + 1;
                    }
                }
            }
            if (moveRight <= 100000) {
                // 방문 안했으면 값 업데이트
                if (!visited[moveRight]) {
                    queue.add(moveRight);
                    answer[moveRight] = answer[start] + 1;
                    visited[moveRight] = true;
                } else {
                    // 지금 방법이 더 빠른 경우
                    if (answer[moveRight] > answer[start] + 1) {
                        queue.add(moveRight);
                        answer[moveRight] = answer[start] + 1;
                    }
                }
            }
        }
    }

}

