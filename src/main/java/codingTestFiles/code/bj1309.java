package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1309 {

    private static final int MOD = 9901;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사자는 가로 세로 붙어 있게 배치할 수 없다
        // -> 경우의 수가 그 전의 사자의 위치에 따라 다르다
        int N = Integer.parseInt(br.readLine());

        // dp[N+1][3]에서
        // dp[n][0]은 사자가 n행에 한 마리도 없을 때
        // dp[n][1]은 사자가 n행에서 왼쪽칸에 한 마리 있을 때
        // dp[n][2]은 사자가 n행에서 오른쪽칸에 한 마리 있을 때를 의미한다.
        int[][] dp = new int[N + 1][3];

        // N = 1일 때
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        // N이 2일때를 보자

        // dp[2][0]: N=2 -> 사자 0마리:
        // 이 경우는 사자를 놓지 않기 때문에 1번째 칸에 영향을 받지 않는다!!
        // dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2]

        // dp[2][1]: N=2 -> 사자를 왼쪽 칸에 놓는 경우:
        // 이 경우 첫번째 칸에 사자는 없거나 오른쪽 칸에 있어야 한다
        // dp[2][1] = dp[1][0] + dp[1][2]

        // dp[2][2]: N=2 -> 사자를 오른쪽 칸에 놓는 경우:
        // 이 경우 첫번째 칸에 사자는 없거나 왼쪽 칸에 있어야 한다
        // dp[2][2] = dp[1][0] + dp[1][1]

        // 이것을 점화식으로 바꿔보면
        // dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1][2]
        // dp[n][1] = dp[n-1][0] + dp[n-1][2]
        // dp[n][2] = dp[n-1][0] + dp[n-1][1] 이다.

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        bw.write((dp[N][0] + dp[N][1] + dp[N][2]) % MOD + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}