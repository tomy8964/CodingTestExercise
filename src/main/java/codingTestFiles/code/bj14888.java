package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj14888 {

    private static int N, MAX = -1000000000, MIN = 1000000000;
    public static int[] arr;
    public static int[] calArr = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        line = br.readLine();
        split = line.split(" ");
        for (int i = 0; i < 4; i++) {
            calArr[i] = Integer.parseInt(split[i]);
        }

        dfs(0, arr[0]);

        bw.write(MAX + "\n" + MIN);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == N - 1) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            // 남은 연산자가 있다면
            if (0 < calArr[i]) {
                calArr[i]--;
                // 더하기
                if (i == 0) {
                    dfs(depth + 1, sum + arr[depth + 1]);
                } else if (i == 1) {
                    dfs(depth + 1, sum - arr[depth + 1]);
                } else if (i == 2) {
                    dfs(depth + 1, sum * arr[depth + 1]);
                } else {
                    dfs(depth + 1, sum / arr[depth + 1]);
                }
                calArr[i]++;
            }
        }
    }
}

