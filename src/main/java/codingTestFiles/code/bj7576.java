package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj7576 {

    public static int M, N;
    public static int[][] box;
    public static boolean[][] visited;
    public static Queue<spot> queue = new LinkedList<>();
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split2 = line.split(" ");
        M = Integer.parseInt(split2[0]);
        N = Integer.parseInt(split2[1]);

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String[] split = line1.split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(split[j]);
                if (box[i][j] == 1) queue.add(new spot(i, j));
            }
        }

        bfs();

        boolean work = true;
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) work = false;
                max = Math.max(max, box[i][j]);
            }
        }

        if (work) {
            bw.write((max - 1) + "\n");
        } else {
            bw.write((-1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            spot start = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + xMove[i];
                int newY = start.y + yMove[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < M) {
                        // 탐색하는 곳에 토마토가 있다면
                        if (box[newX][newY] != -1) {
                            // 그 전의 토마토에서 익는 게 빠른지 이 토마토에서 익는게 빠른지 확인
                            if (box[newX][newY] == 0 || box[newX][newY] > box[start.x][start.y] + 1) {
                                queue.add(new spot(newX, newY));
                                box[newX][newY] = box[start.x][start.y] + 1;
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

