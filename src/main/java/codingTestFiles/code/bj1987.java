package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class bj1987 {

    public static int R, C, answer = 1;
    public static String[][] board;
    public static int[] xMove = {0, 0, 1, -1};
    public static int[] yMove = {1, -1, 0, 0};
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String[] split1 = line1.split(" ");
        R = Integer.parseInt(split1[0]);
        C = Integer.parseInt(split1[1]);
        board = new String[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = String.valueOf(charArray[j]);
            }
        }

        dfs(0, 0, 0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int row, int col, int count) {
        // 이미 지난 적이 있는 알파벳에 도달한 경우
        if (set.contains(board[row][col])) {
            answer = Math.max(count, answer);
            return;
        }
        set.add(board[row][col]);
        for (int i = 0; i < 4; i++) {
            int newX = row + xMove[i];
            int newY = col + yMove[i];
            if (newX >= 0 && newX < R) {
                if (newY >= 0 && newY < C) {
                    dfs(newX, newY, count + 1);
                }
            }
        }
        set.remove(board[row][col]);
    }

}

