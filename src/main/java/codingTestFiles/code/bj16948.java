package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj16948 {

    public static int N;
    public static boolean[][] visited;
    public static int[] xMove = {-2, -2, 0, 0, 2, 2};
    public static int[] yMove = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int r1 = Integer.parseInt(split[0]);
        int c1 = Integer.parseInt(split[1]);
        int r2 = Integer.parseInt(split[2]);
        int c2 = Integer.parseInt(split[3]);

        visited = new boolean[N][N];

        bfs(r1, c1, r2, c2);

        br.close();
    }

    public static void bfs(int r1, int c1, int r2, int c2) {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(new Knight(r1, c1, 0));

        while (!queue.isEmpty()) {
            Knight current = queue.poll();
            visited[current.x][current.y] = true;

            // 도착
            if (current.x == r2 && current.y == c2) {
                System.out.println(current.count);
                return;
            }

            // Move
            for (int i = 0; i < 6; i++) {
                int moveX = current.x + xMove[i];
                int moveY = current.y + yMove[i];
                // 범위 안에 있는 위치이면
                if (moveX >= 0 && moveX < N) {
                    if (moveY >= 0 && moveY < N) {
                        // 아직 방문하지 않았다면
                        if (!visited[moveX][moveY]) {
                            queue.add(new Knight(moveX, moveY, current.count + 1));
                            visited[moveX][moveY] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static class Knight {
        int x;
        int y;
        int count;

        public Knight(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}

