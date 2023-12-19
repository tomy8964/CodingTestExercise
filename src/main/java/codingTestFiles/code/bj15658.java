package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj15658 {

    public static int N, MIN = 1_000_000_001, MAX = -1_000_000_001;
    public static int[] numArr, calArr = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numArr[0], 1);

        bw.write(MAX + "\n" + MIN);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int sum, int depth) {
        if (depth == N) {
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (calArr[i] > 0) {
                calArr[i]--;
                if (i == 0) dfs(sum + numArr[depth], depth + 1);
                else if (i == 1) dfs(sum - numArr[depth], depth + 1);
                else if (i == 2) dfs(sum * numArr[depth], depth + 1);
                else dfs(sum / numArr[depth], depth + 1);
                calArr[i]++;
            }
        }

    }
}
