package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2667 {

    public static int N, count = 0;
    public static boolean[][] house;
    public static boolean[][] visited;
    static int[] xMove = {0, 0, -1, 1};
    static int[] yMove = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        house = new boolean[N][N];
        ArrayList<Integer> countHouse = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(String.valueOf(charArray[j]));
                if (num == 1) {
                    house[i][j] = true;
                } else house[i][j] = false;
            }
        }

        // 인접한 노드들을 탐색하며 방문하지 않았으며 1이라면 같은 단지로 인지하고 count++
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 1 이며 아직 방문하지 않은 집이면 탐색시작
                if (house[i][j] && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    countHouse.add(count);
                }
            }
        }

        Collections.sort(countHouse);

        bw.write(countHouse.size() + "\n");

        for (int count : countHouse) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        // 방문 처리
        visited[x][y] = true;
        count++;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int newX = x + xMove[i];
            int newY = y + yMove[i];
            // 주어진 칸 안에 있는 곳 일때
            if (newX >= 0 && newX < N) {
                if (newY >= 0 && newY < N) {
                    // 탐색하는 칸이 집이 있으며(true) 아직 방문하지 않은 곳이라면
                    if (house[newX][newY] && !visited[newX][newY]) {
                        dfs(newX, newY);
                    }
                }
            }
        }
    }
}

