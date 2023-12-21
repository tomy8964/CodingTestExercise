package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj16198 {

    public static int N, MAX;
    public static int[] weight;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        weight = new int[N];

        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(split[i]);
        }

        dfs(0, 0);

        bw.write(MAX + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == N - 2) {
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int leftNum = 0;
                int rightNum = 0;
                // 왼쪽에 있는 수가 제거된 수이면
                if (visited[i - 1]) {
                    for (int j = i - 2; j >= 0; j--) {
                        // 왼쪽에 있는 수들 중 아직 방문하지 않은 수를 더함
                        if (!visited[j]) {
                            leftNum = weight[j];
                            break;
                        }
                    }
                } else {
                    leftNum = weight[i - 1];
                }
                // 오른쪽에 있는 수가 제거된 수이면
                if (visited[i + 1]) {
                    for (int j = i + 2; j < N; j++) {
                        // 오른쪽에 있는 수들 중 아직 방문하지 않은 수를 더함
                        if (!visited[j]) {
                            rightNum = weight[j];
                            break;
                        }
                    }
                } else {
                    rightNum = weight[i + 1];
                }
                sum += leftNum * rightNum;
                dfs(depth + 1, sum);
                sum -= leftNum * rightNum;
                visited[i] = false;
            }
        }

    }

}

