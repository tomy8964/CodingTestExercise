package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj1261 {

    public static int M, N, count;
    public static int[][] room;
    public static int[][] answer;
    public static boolean[][] visited;
    static int[] xMove = {0, 0, -1, 1};
    static int[] yMove = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);

        visited = new boolean[N][M];
        room = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        bfs(0, 0);

        bw.write(answer[N - 1][M - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<spot> queue = new LinkedList<>();
        queue.add(new spot(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            spot start = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + xMove[i];
                int newY = start.y + yMove[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < M) {
                        // 아직 방문하지 않은 곳이라면
                        if (!visited[newX][newY]) {
                            if (room[newX][newY] == 1) {
                                answer[newX][newY] = answer[start.x][start.y] + 1;
                            } else answer[newX][newY] = answer[start.x][start.y];
                            queue.add(new spot(newX, newY));
                            visited[newX][newY] = true;
                        } // 방문했지만 벽을 더 적게 부수고 갈 수 있는 길이라면
                        else {
                            // 목적지가 벽을 부셔서 가야한다면
                            if (room[newX][newY] == 1) {
                                if (answer[newX][newY] > answer[start.x][start.y] + 1) {
                                    answer[newX][newY] = answer[start.x][start.y] + 1;
                                    queue.add(new spot(newX, newY));
                                }
                            } // 벽을 안부셔도 갈 수 있다면
                            else {
                                if (answer[newX][newY] > answer[start.x][start.y]) {
                                    answer[newX][newY] = answer[start.x][start.y];
                                    queue.add(new spot(newX, newY));
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    static class spot {
        int x;
        int y;

        spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

