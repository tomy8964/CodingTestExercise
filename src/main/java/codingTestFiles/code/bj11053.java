package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11053 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 숫자들 배열
        int[] arr = new int[N];
        // 각 숫자의 수열의 길이 배열
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자 배열을 돌면서 수열의 길이를 구한다.
        for (int i = 0; i < N; i++) {
            //먼저 모든 수열은 길이가 1이상이므로 1로 초기화한다.
            dp[i] = 1;
            // arr[i] 왼쪽에 있는 수(arr[j])들을 보면서 arr[i] 보다 작은 수가 있는지 확인
            for (int j = 0; j < i; j++) {
                // 나보다 작은 수가 있다 &&
                // 이 작은 수 다음으로 내가 와서 수열을 만들었을 때
                // 이 수열이 현재 내 수열보다 더 긴 수열이 되는지 본다.
                // (내가 다음으로 와서 만든 수열의 길이) > (현재 나의 수열 길이)
                // 내가 다음으로 와서 만든 수열의 길이 = 전의 수열의 길이 + 1 = dp[j] + 1
                // 현재 나의 수열 길이 = dp[i]
                // -> dp[j] + 1 > dp[i]
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    // 더 길어지면 나의 수열의 길이(dp[i]) 수정
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 만들어진 수열의 길이들 중 가장 긴 길이를 찾는다.
        int max = 0;
        for (int l : dp) {
            if (max < l) {
                max = l;
            }
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
