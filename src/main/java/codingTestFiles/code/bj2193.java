package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2193 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        먼저 올 수 있는 자리 값은 0, 1이다.
        0으로 시작하지 않는다.
        1을 연속으로 갖지 않는다.
        -> 전의 자릿 수의 값이 1이면 1 불가능
         */

        int N = Integer.parseInt(br.readLine());

        // N의 범위로 보아 long 타입 사용
        long[][] dp = new long[N + 1][2];

        // 먼저 제일 오른쪽 1번째 자리 수에 올 수 있는 자리 값은 1과 0이다.
        // dp[1][0]은 1번째 자리 수에 0이 올 경우의 수가 1이라는 것이다.
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        // 2 부터 N 까지 반복하며 이친수를 구해준다.
        for (int i = 2; i < N + 1; i++) {
            // 자릿 값이 1이면 그 전 자리 수의 자리 값이 1이면 안된다. -> 0일 경우만 고려
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }

        // 0으로 시작하는 것은 이친수가 아니기 때문에
        // N 자리 수의 자리값이 1일 경우만 출력하면 된다.
        bw.write(dp[N][1] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
