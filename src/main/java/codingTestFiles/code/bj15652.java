package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj15652 {

    public static boolean[] visited;
    public static int[] numArr;
    public static int[] nArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        String line1 = br.readLine();
        String[] split1 = line1.split(" ");
        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(split1[i]);
        }
        Arrays.sort(nArr);

        numArr = new int[M];
        visited = new boolean[N];

        dfs(0, N, M);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int n, int m) {
        if (depth == m) {
            for (int number : numArr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i =0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numArr[depth] = nArr[i];
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }
}
