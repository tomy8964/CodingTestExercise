package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj9465 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변을 공유하는 스티커는 사용할 수 없다.
        // 왼쪽부터 스티커를 뗀다고 생각하자
        // 제일 왼쪽 칸에 스티커의 위치를 위를 0 아래를 1 로 생각하자
        // 첫번째 칸에서 0 자리에 있는 스티커를 뗐으면
        // 두번째 칸에서는 1 자리에 있는 스티커를 뗄 수 있다.
        // 즉 전의 스티커를 뗀 위치에 따라 다음 스티커를 정해야 한다.
        // 여기서 중요한 점이 스티커를 아에 안뗏다면
        // 다음 스티커는 아무 스티커를 떼도 된다.
        // 즉 안뗀다 0, 위칸 뗀다 1, 아래칸 뗀다 2로 배열을 정해서 풀어보자

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][N];
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                cost[0][i] = Integer.parseInt(split[i]);
            }
            split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                cost[1][i] = Integer.parseInt(split[i]);
            }

            long[][] dp = new long[N][3];

            // 저장한 cost 값을 통해
            // 첫번째 칸부터
            // 0: 스티커를 안뗏을때
            // 1: 윗칸 스티커를 뗏을때
            // 2: 아래칸 스티커를 뗏을때
            // 다음 칸에서 스티커를 떼는 누적합을 구하면 된다.

            // 일단 제일 처음 칸의 누적합은 그 cost 자체이기 때문에 초기화
            dp[0][0] = 0;
            dp[0][1] = cost[0][0];
            dp[0][2] = cost[1][0];

            // dp[n][0] = Math.max(dp[n-1][0], dp[n-1][1], dp[n-1][2]);
            // dp[n][1] = Math.max(dp[n-1][0], dp[n-1][2]) + cost[0][n-1];
            // dp[n][2] = Math.max(dp[n-1][0], dp[n-1][1]) + cost[1][n-1];
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + cost[0][i];
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + cost[1][i];
            }

            long answer = Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}