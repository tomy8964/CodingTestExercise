package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj15649 {

    public static int[] numArr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        visited = new boolean[N];
        numArr = new int[M];

        dfs(0, N, M);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int n, int m) {
        if (depth == m) {
            for (int num : numArr) {
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numArr[depth] = i + 1;
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }
}
