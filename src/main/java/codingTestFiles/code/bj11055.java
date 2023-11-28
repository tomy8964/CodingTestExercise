package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11055 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 증가하는 부분 수열 중 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
        // 수열을 만들고 그 수열을 만들었을 때의 누적합을 구하면 되지 않을까?

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 숫자의 수열의 합
        int[] dp = new int[N + 1];

        // 내 왼쪽에 나보다 더 작은 수가 있다
        // 그 수에 내가 붙어서 수열을 만들었을 때의 합이 더 큰가?
        dp[1] = arr[1];
        for (int i = 2; i < N + 1; i++) {
            // 가장 초기의 수열은 자기 자신이다
            // 그 수열의 합은 자기 자신이다.
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // 그 전의 수열에 내가 붙어서 새로운 수열을 만들었을 때
                    // 그 수열의 합이 지금 내 수열의 합보다 크면
                    if (dp[i] < dp[j] + arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
        }

        int answer = 0;
        for (int a : dp) {
            if (a > answer) {
                answer = a;
            }
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}