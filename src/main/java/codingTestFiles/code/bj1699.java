package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1699 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 1;
        // dp[2] = 1^2 + 1^2
        // dp[3] = 1^2 + 1^2 + 1^2
        // dp[4] = 2^2
        // dp[5] = 2^2 + 1^2
        // dp[6] = 2^2 + 1^2 + 1^2
        // dp[12] = 2^2 + 2^2 + 2^2 = 3

        for (int i = 2; i < N + 1; i++) {
            // 최악의 경우의 수인 전부 1^2의 합으로 표현한 경우로 초기화한다.
            dp[i] = i;
            // 2부터 제곱 수가 i보다 작거나 같을 때까지
            for (int j = 2; j * j <= i; j++) {
                // 현재 항의 갯수(dp[i])와
                // 제곱수(항의 개수 = 1) 항과 i에서 제곱수를 뺀 수의 항의 갯수의 합을 비교한다
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(dp[N] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
