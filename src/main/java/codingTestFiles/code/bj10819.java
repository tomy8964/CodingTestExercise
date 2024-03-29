package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj10819 {

    public static int MAX;
    public static int N;
    public static boolean[] visited;
    public static int[] numArr;
    public static int[] answerArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        answerArr = new int[N];
        visited = new boolean[N];
        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }

        dfs(0);

        bw.write(MAX + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int count = 0;
            for (int i = 0; i < N - 1; i++) {
                count = count + Math.abs(answerArr[i] - answerArr[i + 1]);
            }
            MAX = Math.max(count, MAX);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerArr[depth] = numArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
