package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class bj16946 {

    public static int N, M;
    public static boolean[][] visited;
    public static int[][] map, cloneMap;
    public static HashMap<Integer, Integer> zeroGroup = new HashMap<>();
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        cloneMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 0 그룹 구하기
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(new player(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    foundZeroGroup(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] % 10);
            }
            if (i != N - 1) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void foundZeroGroup(int i, int j) {
        int zeroNum = 1;
        Set<Integer> foundedZeroGroup = new HashSet<>();
        for (int q = 0; q < 4; q++) {
            int newX = i + xMove[q];
            int newY = j + yMove[q];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;

            if (map[newX][newY] == 0) {
                if (!foundedZeroGroup.contains(cloneMap[newX][newY])) {
                    zeroNum += zeroGroup.get(cloneMap[newX][newY]);
                    foundedZeroGroup.add(cloneMap[newX][newY]);
                }
            }
        }
        map[i][j] = zeroNum;
    }

    public static void bfs(player start) {
        Queue<player> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        cloneMap[start.x][start.y] = zeroGroup.size() + 1;
        int count = 1;

        while (!queue.isEmpty()) {
            player current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + xMove[i];
                int newY = current.y + yMove[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;

                if (!visited[newX][newY]) {
                    if (map[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.add(new player(newX, newY));
                        cloneMap[newX][newY] = zeroGroup.size() + 1;
                        count++;
                    }
                }
            }
        }
        zeroGroup.put(zeroGroup.size() + 1, count);
    }

    public static class player {
        int x;
        int y;

        public player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

