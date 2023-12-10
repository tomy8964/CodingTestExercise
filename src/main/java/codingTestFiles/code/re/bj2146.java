package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class bj2146 {

    public static int N;
    public static boolean[][] visited;
    public static int[][] input;
    public static int[][] landNumber;
    public static Queue<spot> queue = new LinkedList<>();
    public static int MIN = 11;
    public static StringBuilder sb = new StringBuilder();
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        input = new int[N][N];
        landNumber = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(split[j]);
            }
        }

        int landCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && input[i][j] != 0) {
                    findLandBFS(new spot(i, j, landCount), landCount);
                    landCount++;
                }
            }
        }

        for (int i = 1; i < landCount; i++) {
            visited = new boolean[N][N];
            input = new int[N][N];
            bfs(i);
        }


        bw.write(MIN + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findLandBFS(spot start, int landNum) {
        Queue<spot> landQueue = new LinkedList<>();
        landQueue.add(start);

        while (!landQueue.isEmpty()) {
            start = landQueue.poll();
            visited[start.x][start.y] = true;
            landNumber[start.x][start.y] = landNum;
            queue.add(new spot(start.x, start.y, landNum));
            for (int i = 0; i < 4; i++) {
                int newX = start.x + xMove[i];
                int newY = start.y + yMove[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < N) {
                        // 탐색하는 곳이 바다가 아니라면(같은 땅이라면)
                        if (input[newX][newY] != 0) {
                            if (!visited[newX][newY]) {
                                landQueue.add(new spot(newX, newY, landNum));
                            }
                        }
                    }
                }
            }

        }
    }

    private static void bfs(int landNum) {
        queue = new LinkedList<>();
        // 해당 섬을 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (landNumber[i][j] == landNum) {
                    queue.add(new spot(i, j, landNum));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            spot start = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + xMove[i];
                int newY = start.y + yMove[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < N) {
                        if (!visited[newX][newY]) {
                            if (landNumber[newX][newY] == 0) {
                                visited[newX][newY] = true;
                                queue.add(new spot(newX, newY, landNum));
                                input[newX][newY] = input[start.x][start.y] + 1;
                            }
                            // 다른 섬일경우
                            else MIN = Math.min(MIN, input[start.x][start.y]);
                        }
                    }
                }
            }

        }
    }

    static class spot {
        int x;
        int y;
        int landNum;

        spot(int x, int y, int landNum) {
            this.x = x;
            this.y = y;
            this.landNum = landNum;
        }
    }
}

