package codingTestFiles.code;

import java.io.*;

public class bj15990 {

    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        /*
        dp[n][1] = dp[n-1][2] + dp[n-1][3]
        dp[n][2] = dp[n-2][1] + dp[n-1][3]
        dp[n][3] = dp[n-3][1] + dp[n-3][2]
        1 = 1                                   --> 1
        2 = 2                                   --> 1
        3 = 1 + 2, 2 + 1, 3                     --> 3
        4 = 1 + 2 + 1, 1 + 3, 3 + 1             --> 3
        5 = 2 + 1 + 2, 1 + 3 + 1, 2 + 3, 3 + 2  --> 4
         */

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int n = 4; n < N + 1; n++) {
                dp[n][1] = dp[n - 1][2] + dp[n - 1][3] % MOD;
                dp[n][2] = dp[n - 2][1] + dp[n - 2][3] % MOD;
                dp[n][3] = dp[n - 3][1] + dp[n - 3][2] % MOD;
            }
            bw.write((dp[N][1] + dp[N][2] + dp[N][3]) % MOD + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
