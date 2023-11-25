package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1149 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int r = Integer.parseInt(split[0]);
            int g = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            cost[i][0] = r;
            cost[i][1] = g;
            cost[i][2] = b;
        }

        // r(0), g(1), b(2) 중 어떤 걸로 칠할지에 따라 다음에 올 수 있는 경우의 수가 달라진다
        // 0 -> 1, 2
        // 1 -> 0, 2
        // 2 -> 0, 1
        // f(n) = f(n-1)

        dp[0][0] = cost[0][0];
        dp[0][2] = cost[0][2];
        dp[0][1] = cost[0][1];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];

            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];

            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];

        }

        int min = Math.min(dp[N - 1][0], dp[N - 1][1]);
        int answer = Math.min(min, dp[N - 1][2]);

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}