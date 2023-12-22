package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj9663 {

    public static int N, answer = 0;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (Possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}

