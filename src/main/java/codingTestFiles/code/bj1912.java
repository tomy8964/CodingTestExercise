package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1912 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 숫자들 배열
        int[] arr = new int[N];
        // 각 숫자의 수열의 합 배열
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 맨 처음 숫자의 수열의 합은 맨 처음 숫자이다.
        dp[0] = arr[0];
        // 숫자 배열을 돌면서 수열의 합을 구한다.
        for (int i = 1; i < N; i++) {
            // 바로 앞의 숫자(연속)(앞의 수도 수열을 완성한 합일 수 있다) + 나의 숫자의 합이 내 숫자보다 크면
            // -> 연속된 숫자이며 합을 최대화 할 수 있다.
            if (dp[i-1] + arr[i] > arr[i]) {
                // 합이 더 크면 나의 수열의 합(dp[i])으로 수정
                dp[i] = dp[i - 1] + arr[i];
            }
        }

        // 만들어진 수열의 합 중 가장 큰 합을 찾는다.
        int max = -1001;

        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
