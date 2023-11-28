package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1932 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 다음으로 오는 수는 대각선 왼쪽, 대각선 오른쪽 두 가지 경우의 수가 있다.
        // 각각의 경우에 따라 누적합을 구하면 된다.
        // 대각선이라고 하였는데 계산하기 쉽게 대각선이 아니라
        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5
        // 이 모양 자체의 삼각형이라고 생각하고
        // 7 일때 고를 수 있는 수는 자기 아래와 오른쪽으로 생각하고 문제를 푼다.
        // 4 번째 줄의 7을 선택한다고 생각해보자
        // 현재 7(cost[4번째 줄][2번째 수])을 선택했을 때
        // 선택 됐을 3번째 줄의 수는
        // 8(cost[3][1]), 1(cost[3][2]) 둘 중 하나이다.
        // 즉, 8을 골랐을 때의 누적합과
        // 1을 골랐을 때의 누적합 중 큰 것을 고르고
        // 현재 선택한 7을 더해주면
        // 7을 골랐을 때의 지금까지의 가장 큰 누적합을 구할 수 있다.
        // 점화식으로 표현하자면
        // dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + cost[i][j]

        // n 번째 줄에 나오는 수 들 중 누적합이 가장 큰 것을 출력하면 된다.
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                cost[i][j] = num;
            }
        }

        int[][] dp = new int[N + 1][N + 1];

        // 제일 처음 수의 누적합은 그 칸의 cost 이다.
        dp[1][1] = cost[1][1];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + cost[i][j];
            }
        }

        int answer = 0;

        for (int i = 1; i < N + 1; i++) {
            if (dp[N][i] > answer) answer = dp[N][i];
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}