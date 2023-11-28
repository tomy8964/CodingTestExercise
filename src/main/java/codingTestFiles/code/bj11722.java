package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11722 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 감소하는 부분 수열 중 길이가 가장 긴 수열을 길이를 구하시오
        // 수열을 만들고 그 수열을 만들 었을 때의 길이가 더 길어지는지 본다?

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 숫자의 수열의 길이
        int[] dp = new int[N + 1];

        // 내 왼쪽에 나보다 더 큰 수가 있다
        // 그 수에 내가 붙어서 감소하는 수열을 만들 었을 때의 길이가 더 길어지는지?

        for (int i = 1; i < N + 1; i++) {
            // 가장 초기의 수열은 자기 자신이며 그 길이는 1이다.
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j]) {
                    // 그 전의 수열에 내가 붙어서 새로운 수열을 만들었을 때
                    // 그 수열의 길이가 지금 내 수열의 길이보다 길면
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
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