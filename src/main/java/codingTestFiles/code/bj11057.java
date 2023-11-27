package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj11057 {

    private static final int MOD = 10_007;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 오르막수 다음 자리에 오는 수가 같거나 더 큰 경우
        // 0으로 시작 가능
        // 수의 길이 : N
        // 전 자리의 수보다 같거나 더 큰 수가 올 수 있다.
        // n 번째 자리에 오는 수는 n-1 자리의 수와 같은 수부터 9까지 올 수 있다.
        // dp[n] = dp[n-1]

        // N = 1 경우
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        // N = 2 경우
        // 첫번째 자리가 0 인 경우 올 수 있는 수는 0~9
        // 첫번째 자리가 1 인 경우 올 수 있는 수는 1~9
        // 첫번째 자리가 2 인 경우 올 수 있는 수는 2~9
        // 이렇게 전자리의 수(0~9)에 따라 경우의 수가 달라진다.

        // N 번째 자리의 수(0~9)에 따라 경우의 수를 구하기 위해
        // dp[N][10] 즉, dp[N][6]이란 N 번째 자리에 6이 올 수 있는 경우의 수이다.
        // 그리고 점화식은 dp[i][j] = dp[i-1][0~j]의 총합이다.
        int[][] dp = new int[N + 1][10];

        // N = 1인 경우를 초기화 하자
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 2 번째 자리부터 N 번째 자리까지 경우의 수를 구하자
        for (int i = 2; i < N + 1; i++) {
            // i 번째 자리에 0~9가 올 경우의 수를 구하자
            for (int j = 0; j < 10; j++) {
                // i 번째 자리에 j가 온 경우의 수를 구하자
                for (int z = 0; z <= j; z++) {
                    // dp[i][j] : i 번째 자리에 j가 오는 경우의 수는
                    // -> i-1 번째 자리에 j 보다 작거나 같은 수가 오는 경우
                    // -> j보다 작거나 같은수 : z
                    // -> 0 <= z <= j
                    dp[i][j] += (dp[i - 1][z]) % MOD;
                }
            }
        }

        // 0~9까지 오는 경우의 수를 다 더하자
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        bw.write((answer) % MOD + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}