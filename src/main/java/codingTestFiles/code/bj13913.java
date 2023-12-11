package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class bj13913 {

    public static int N, K;
    public static boolean[] visited = new boolean[100001];
    public static int[] time = new int[100001];
    public static int[] parent = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        bfs(N);

        bw.write(time[K] + "\n");

        // 순서대로 구하기 위해 stack 에 담았다가 다시 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb + "");

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
                    time[teleport] = time[start] + 1;
                    visited[teleport] = true;
                    parent[teleport] = start;
                } else {
                    // 방문했었지만
                    // 지금 방법이 더 빠른 경우
                    if (time[teleport] > time[start] + 1) {
                        queue.add(teleport);
                        time[teleport] = time[start] + 1;
                        parent[teleport] = start;
                    }
                }
            }
            if (moveLeft >= 0){
                // 방문 안했으면 값 업데이트
                if (!visited[moveLeft]) {
                    queue.add(moveLeft);
                    time[moveLeft] = time[start] + 1;
                    visited[moveLeft] = true;
                    parent[moveLeft] = start;
                } else {
                    // 지금 방법이 더 빠른 경우
                    if (time[moveLeft] > time[start] + 1) {
                        queue.add(moveLeft);
                        time[moveLeft] = time[start] + 1;
                        parent[moveLeft] = start;
                    }
                }
            }
            if (moveRight <= 100000) {
                // 방문 안했으면 값 업데이트
                if (!visited[moveRight]) {
                    queue.add(moveRight);
                    time[moveRight] = time[start] + 1;
                    visited[moveRight] = true;
                    parent[moveRight] = start;
                } else {
                    // 지금 방법이 더 빠른 경우
                    if (time[moveRight] > time[start] + 1) {
                        queue.add(moveRight);
                        time[moveRight] = time[start] + 1;
                        parent[moveRight] = start;
                    }
                }
            }
        }
    }

}

