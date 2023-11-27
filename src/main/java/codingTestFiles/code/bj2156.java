package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2156 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연속해서 3잔을 마실 수 없다
        // n 번째 잔을 마실 수 있는지 없는지는
        // 연속으로 3 번째 잔인지 아닌지에 달려 있다
        // 연속으로 3 번째 잔인지 아는 방법은?
        // 그 전잔이 연속 2번째 잔인지 아는 방법은?
        // 배열에 저장한다?

        int N = Integer.parseInt(br.readLine());
        int[] quantity = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            quantity[i] = Integer.parseInt(br.readLine());
        }

        // 0 : n 번째 잔을 안마신다
        // 1 : n 번째 잔을 처음으로 마신다
        // 2 : n 번째 잔을 연속으로 두번째로 마신다
        int[][] dp = new int[N + 1][3];

        // dp[n][0] = Math.max(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        // dp[n][1] = dp[n-1][0] + quantity[n]
        // dp[n][2] = dp[n-1][1] + quantity[n]

        dp[1][0] = 0;
        dp[1][1] = quantity[1];

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + quantity[i];
            dp[i][2] = dp[i - 1][1] + quantity[i];
        }

        int answer = Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]);
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}