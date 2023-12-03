package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj6603 {

    public static int K;
    public static int[] numArr;
    public static int[] answerArr = new int[6];
    public static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"0".equals(line = br.readLine())) {
            String[] split = line.split(" ");
            K = Integer.parseInt(split[0]);

            visited = new boolean[K];
            numArr = new int[K];
            for (int i = 0; i < K; i++) {
                numArr[i] = Integer.parseInt(split[i + 1]);
            }

            Arrays.sort(numArr);

            dfs(0, 0);
            sb.append("\n");

        }

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int index) {
        if (depth == 6) {
            for (int num : answerArr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerArr[depth] = numArr[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
