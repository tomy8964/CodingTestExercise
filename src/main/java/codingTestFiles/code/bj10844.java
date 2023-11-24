package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj10844 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long MOD = 1000000000;
        /*
        먼저 자리 값에 따라 경우의 수가 달라진다. (자리 수가 아닌 자리의 값)
        0 일 경우: 그 다음에 올 수 있는 자리 값은 1 밖에 없다.
        9 일 경우: 그 다음에 올 수 있는 자리 값은 8 밖에 없다.
        */
        int N = Integer.parseInt(br.readLine());

        // 자리 값마다 경우의 수가 다르기 때문에
        // 자리 값마다의 경우의 수를 다 구한 다음에 합을 답으로 한다.
        // N 자리 수의 각각의 자리 값(0~9)을 표현하는 배열 생성
        long[][] dp = new long[N + 1][10];

        // 먼저 N이 1일때의 경우를 보자
        // 1 자리 수의 계단 수는 각각의 자리값(0~9)이 오는 경우의 수이다.
        // 예) dp[1][0]이란 것은 1 자리 수에서 첫번째 자리 값이 0인 경우 -> 계단 수 1개
        // 즉, 1 자리 수의 계단수는 dp[1][0~9]의 계단수의 합이다.
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 그 다음 2부터 N 자리수까지의 계단 수를 구해보자.
        // i 번째 자리 수에 자리값이 j일 때의 계단 수는
        // i-1 번째 자리 수(그 전의 자릿수)의 자리 값이 j-1 일때와 j+1 일때 계단 수의 합이다.
        // f(i)(j) = f(i-1)(j-1) + f(i-1)(j+1)
        // 예) 2 번째 자리 수의 자리 값이 2일 때의 계단 수는 1번째 자리 수의 자리 값이 1이나 3일때 계단 수의 합이다.
        // 예) f(2)(2) = f(1)(1) + f(1)(3)
        for (int i = 2; i < N + 1; i++) { // 2 자리 수부터 N 자리 수까지 반복
            for (int j = 0; j < 10; j++) { // 자리 값이 0일 때 부터 9일 때까지 반복
                // 하지만 i 번째 자리 수의 자리 값인 j가 0이거나 9일때의 경우를 생각해야 한다.
                // 예) 2 번째 자리 수의 자리 값이 0일 때, 1번째 자리 수의 자리 값은 1이다.
                // 예) f(2)(0) = f(1)(1)
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % MOD;
                }
                // 예) 2 번째 자리 수의 자리 값이 9일 때, 1번째 자리 수의 자리 값은 8이다.
                // 예) f(2)(9) = f(1)(8)
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                } 
                // 나머지 자리 값(1~8)일 경우
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;

        // 각 자릿값마다의 경우의 수를 모두 더해준다.
        // 이 때, 0으로 시작하는 수는 계단수가 아니기 때문에 i는 1부터 시작한다.
        for(int i = 1; i < 10; i++) {
            result += dp[N][i];
        }

        bw.write(result % MOD + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
