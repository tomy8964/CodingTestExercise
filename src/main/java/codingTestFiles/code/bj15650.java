package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj15650 {

    public static int[] numArr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        visited = new boolean[N + 1];
        numArr = new int[M];

        dfs(0, 0, N, M);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int num, int depth, int n, int m) {
        if (depth == m) {
            for (int number : numArr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = num + 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numArr[depth] = i;
                dfs(i, depth + 1, n, m);
                visited[i] = false;
            }
        }
    }
}
