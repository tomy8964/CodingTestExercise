package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj14502 {

    static final int[] xMove = {0, 0, 1, -1};
    static final int[] yMove = {1, -1, 0, 0};
    public static Queue<Virus> queue = new LinkedList<>();
    public static int N, M, MAX = -1;
    public static boolean[][] visited;
    public static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] read = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(read[j]);
            }
        }

        makeWallDFS(0);
        bfs();

        bw.write(MAX + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void makeWallDFS(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWallDFS(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int safeZone = 0;
        int[][] cloneMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 2) queue.add(new Virus(i, j));
            }
        }
        while (!queue.isEmpty()) {
            Virus current = queue.poll();
            visited[current.x][current.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = current.x + xMove[i];
                int newY = current.y + yMove[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;

                if (cloneMap[newX][newY] == 0) {
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        cloneMap[newX][newY] = 2;
                        queue.add(new Virus(newX, newY));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        MAX = Math.max(MAX, safeZone);
    }

    public static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

