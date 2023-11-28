package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj13398 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 두가지 경우가 있다
        // dp[i][0] : 특정 수를 제거하지 않을 때
        // Math.max(dp[i - 1][0] + arr[i], arr[i])
        // dp[i][1]
        // 1. i 번째 수가 처음으로 제거되는 경우: dp[i-1][0]
        // 2. i 번째 수 전에 제거된 수가 있는 경우: dp[i-1][1] + arr[i]
        int[][] dp = new int[N + 1][2];

        int max = arr[1];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }


        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}