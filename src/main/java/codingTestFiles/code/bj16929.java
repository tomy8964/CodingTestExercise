package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj16929 {

    public static boolean cycle = false;
    public static int M, N;
    public static Character[][] box;
    public static boolean[][] visited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split2 = line.split(" ");
        N = Integer.parseInt(split2[0]);
        M = Integer.parseInt(split2[1]);

        box = new Character[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < M; j++) {
                box[i][j] = charArray[j];
            }
        }

        for (int i = 0; i < N; i++) {
            if (cycle) break;
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (cycle) break;
                    dfs(new spot(i, j), new spot(-1, -1));
                }
            }
        }

        if (cycle) {
            bw.write("Yes" + "\n");
        } else {
            bw.write("No" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(spot start, spot last) {
        // 방문 처리
        visited[start.x][start.y] = true;

        // 나의 상하좌우 살피기
        for (int i = 0; i < 4; i++) {
            if (cycle) break;
            int newX = start.x + xMove[i];
            int newY = start.y + yMove[i];
            // 주어진 칸 안에 있는 곳 일때
            if (newX >= 0 && newX < N) {
                if (newY >= 0 && newY < M) {
                    if (box[newX][newY].equals(box[start.x][start.y])) {
                        if ((visited[newX][newY]) && (last.x != newX || last.y != newY)) {
                            cycle = true;
                        } else if (!visited[newX][newY]) dfs(new spot(newX, newY), start);
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

