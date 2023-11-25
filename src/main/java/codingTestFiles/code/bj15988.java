package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj15988 {

    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1000001];

        // n = 1
        // 1

        // n = 2
        // 1+1
        // 2

        // n = 3
        // 1+1+1
        // 1+2
        // 2+1
        // 3

        // n = 4
        // 1+1+1+1
        // 1+1+2
        // 1+2+1
        // 2+1+1
        // 2+2
        // 1+3
        // 3+1

        // 자세히 보면
        // n 을 1, 2, 3의 합으로 나타내는 방법은
        // n-1을 1, 2, 3의 합으로 나타내는 방법 뒤에 +1을 한 방법들과
        // n-2을 1, 2, 3의 합으로 나타내는 방법 뒤에 +2을 한 방법들과
        // n-3을 1, 2, 3의 합으로 나타내는 방법 뒤에 +3을 한 방법으로 이루어져 있다.
        // 즉, 방법의 수 점화식은 dp[n] = dp[n-1] + dp[n-2] + dp[n-3]

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write((dp[num]) % MOD + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
