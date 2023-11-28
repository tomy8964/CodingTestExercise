package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11054 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1. 증가하는 수열 2. 감소하는 수열 3. 증가하다가 감소하는 수열 들 중 가장 길이가 긴 수열을 구하시오
        // 증가하는 수열은 내 왼쪽을 보면서 구하고
        // 감소하는 수열은 내 오른쪽을 보면서 구한다
        // 그 후 i 번째 수를 기준으로 i 번째 전으로 가장 긴 증가하는 수열의 길이 + 후로 가장 긴 감소하는 수열의 길이
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 세 가지의 경우의 수에 따라 구할 수 있는 수열이 다르며 길이 또한 달라진다
        // 0 : 증가하는 수열
        // 1 : 감소하는 수열
        // 2 : 증가하다가 감소하는 수열

        // 각 숫자의 수열의 길이
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            // 가장 초기의 수열은 자기 자신이며 그 길이는 1이다.
            dp[i][0] = 1;
            dp[i][1] = 1;
            dp[i][2] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            // 왼쪽을 보면서
            for (int j = 1; j < i; j++) {
                // 증가하는 수열
                if (arr[i] > arr[j]) {
                    // 그 전의 수열에 내가 붙어서 새로운 수열을 만들었을 때
                    // 그 수열의 길이가 지금 내 수열의 길이보다 길면
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                    }
                }
            }
        }
        // 감소하는 수열
        // 오른쪽부터 역순으로 시작하면 -> 증가하는 수열을 구하면 된다.
        for (int i = N; i > 0; i--) {
            for (int j = N; j > i; j--) {
                if (arr[j] < arr[i]) {
                    if (dp[j][1] + 1 > dp[i][1]) {
                        dp[i][1] = dp[j][1] + 1;
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i][2] = dp[i][0] + dp[i][1] - 1;
        }

        // 1 5 2 1 4 3 4 5 2 1
        // i = 2 일때
        // arr[i] = 5이며
        // i + 1 부터 N까지의 수 들중 arr[i] 보다 작은 수는
        // 2 1 4 3 4 2 1 이며
        // 여기 있는 수로 만들 수 있는 가장 긴 감소하는 수열의 길이 + 1 이
        // 5로 시작하는 가장 긴 감소하는 수열의 길이 이다.

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dp[i][2] > answer) {
                answer = dp[i][2];
            }
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}