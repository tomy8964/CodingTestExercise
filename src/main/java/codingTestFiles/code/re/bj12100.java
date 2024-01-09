package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj12100 {

    public static int N, MIN = 10;
    public static int[][] board;
    public static boolean[][] visited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String[] split = line1.split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0);

        bw.write(MIN + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 4; i++) {

        }

    }
}

