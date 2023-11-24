package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj14002 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 숫자들 배열
        int[] arr = new int[N];
        // 각 숫자의 수열의 길이 배열
        int[] dp = new int[N];
        // 각 숫자의 수열
        String[] str = new String[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자 배열을 돌면서 수열의 길이를 구한다.
        for (int i = 0; i < N; i++) {
            // 먼저 모든 수열은 길이가 1이상이므로 1로 초기화한다.
            dp[i] = 1;
            // 수열도 자기 자신으로 초기화 한다.
            str[i] = String.valueOf(arr[i]);
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
                    // i 번째 수열의 정보는 j번째의 수열에 i번째 수를 넣은 수열로 수정
                    str[i] = str[j] + " " + arr[i];
                }
            }
        }

        // 만들어진 수열의 길이들 중 가장 긴 길이를 찾는다.
        int max = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }

        bw.write(max + "\n");
        bw.write(str[index] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
