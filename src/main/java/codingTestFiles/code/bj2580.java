package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2580 {

    public static int N = 9;
    public static int[][] board = new int[N][N];

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0);

        bw.write(board + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int row, int col) {
        // 제일 오른쪽 칸까지 다 채웠다.
        if (col == N) {
            dfs(row + 1, 0);
            return;
        }

        // 제일 아래
        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        // 값을 채워야 한다.
        if (board[row][col] == 0) {
            for (int value = 1; value <= 9; value++) {
                // 값을 넣을 수 있다.
                if (validNum(row, col, value)) {
                    // 값 변경
                    board[row][col] = value;
                    // 다음 칸으로 이동
                    dfs(row, col + 1);
                }
            }
            // 잘못된 방법이었으므로 다시 0으로 초기화
            board[row][col] = 0;
            return;
        }

        // 다른 값이 이미 채워져 있으면 다음 칸으로 이동
        dfs(row, col + 1);
    }

    // 값이 들어갈 수 있는지 확인
    public static boolean validNum(int row, int col, int value) {
        // 같은 row에 값이 있는지 확인
        for (int i = 0; i < N; i++) {
            // 같은 값이 있으면 false
            if (board[row][i] == value) {
                return false;
            }
        }
        // 같은 col에 값이 있는지 확인
        for (int i = 0; i < N; i++) {
            // 같은 값이 있으면 false
            if (board[i][col] == value) {
                return false;
            }
        }
        // 3*3 칸에 값이 있는지 확인
        int row3 = (row / 3) * 3;
        int col3 = (col / 3) * 3;

        for (int i = row3; i < row3 + 3; i++) {
            for (int j = col3; j < col3 + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}

