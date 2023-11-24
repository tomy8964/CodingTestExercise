package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2225 {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[][] dp = new int[N+1][K+1];

        // N=1
        // K=1 : 1 (1)
        // K=2 : 2 (1+0, 0+1)
        // K=3 : 3 (0+1+1, 1+0+1, 1+1+0)

        // N=2
        // K=1 : 1 (2)
        // K=2 : 3 (2+0, 0+2, 1+1)
        // K=3 : 6 (2+0+0, 0+2+0, 0+0+2, 0+1+1, 1+0+1, 1+1+0)

        // N=3
        // K=1 : 1 (3)
        // K=2 : 4 (2+1, 1+2, 3+0, 0+3)
        // K=3 : 10 (3+0+0, 0+3+0, 0+0+3, 1+1+1, 2+0+1, 1+0+2, 0+1+2, 0+2+1, 1+2+0, 2+1+0)

        // 즉, 점화식은 dp[N][K] = dp[N-1][K] + dp[N][K-1]

        // 0개로 N을 만들 수 있는 경우의 수는 0
        // 1개로 N을 만들 수 있는 경우의 수는 1
        for (int i = 0; i < N + 1; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // N이 1일 때의 경우의 수는 K개 이다
        for (int i = 0; i < K + 1; i++) {
            dp[1][i] = i;
        }

        // 2 부터 N 까지
        for (int i = 2; i < N + 1; i++) {
            // 1 부터 K 까지
            for (int j = 1; j < K + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        bw.write(dp[N][K] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
