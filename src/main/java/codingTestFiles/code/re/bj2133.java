package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2133 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
        // 그림을 그려보면
        // n 은 짝수일 때만 성립한다.
        // n = 4 일 때를 보면 n = 2 일 때의 방법에서 x 3 개의 방법이 나오는 것을 확인할 수 있다.
        // 추가적으로 예외적인 모양으로 2 개가 더 나온다는 것을 알 수 있다.
        // n = 6 일 때를 보자
        // (n = 4 일 때의 방법 수) * (n = 2 일때의 방법 수)
        // + (n = 2 일 때의 방법 수) * (n = 4 일 때의 예외 타일 갯수)
        // + (n = 6 일 때의 예외 타일 갯수)

        // 즉, dp[n] = dp[n-2] * dp[2] + dp[n-4] * 2 + ... + dp[0] * 2

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;

        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}