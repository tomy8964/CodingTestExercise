package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj14442 {

    public static Queue<player> queue = new LinkedList<>();
    public static int N, M, K, ANSWER = -1;
    public static boolean[][][] visited;
    public static int[][] map;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        visited = new boolean[N][M][K + 1];

        bfs(new player(0, 0, 1, 0));

        bw.write(ANSWER + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(player start) {
        queue.add(start);
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            player current = queue.poll();
            if (current.x == N - 1 && current.y == M - 1) {
                ANSWER = current.count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = current.x + xMove[i];
                int newY = current.y + yMove[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;

                // 벽이 아니면
                if (map[newX][newY] != 1) {
                    if (!visited[newX][newY][current.breakWallNum]) {
                        visited[newX][newY][current.breakWallNum] = true;
                        queue.add(new player(newX, newY, current.count + 1, current.breakWallNum));
                    }
                } // 벽이면
                else {
                    // 지금까지 부신 벽의 개수가 K 개를 안넘었을 때
                    if (current.breakWallNum < K) {
                        if (!visited[newX][newY][current.breakWallNum + 1]) {
                            visited[newX][newY][current.breakWallNum + 1] = true;
                            queue.add(new player(newX, newY, current.count + 1, current.breakWallNum + 1));
                        }
                    }
                }
            }
        }
    }

    public static class player {
        int x;
        int y;
        int count;
        int breakWallNum;

        public player(int x, int y, int count, int breakWallNum) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breakWallNum = breakWallNum;
        }
    }

}

