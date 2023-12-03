package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj10971 {

    public static int N;
    public static int[] cityArr;
    public static boolean[] visited;
    public static long MIN;
    public static int[][] costArr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        cityArr = new int[N];
        costArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < N; j++) {
                costArr[i][j] = Integer.parseInt(split[j]);
                MIN += costArr[i][j];
            }
        }

        dfs(0);

        bw.write(MIN + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int cost = 0;
            for (int i = 0; i < N - 1; i++) {
                cost += costArr[cityArr[i]][cityArr[i + 1]];
            }
            if (costArr[cityArr[N - 1]][cityArr[0]] == 0) return;
            cost += costArr[cityArr[N - 1]][cityArr[0]];
            MIN = Math.min(cost, MIN);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                // "경우에 따라서 도시 i에서 도시 j로 갈 수 없는 경우도 있으며 이럴 경우 W[i][j]=0이라고 하자."
                if (depth > 0) {
                    if (costArr[cityArr[depth - 1]][i] == 0) continue;
                }
                visited[i] = true;
                cityArr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
