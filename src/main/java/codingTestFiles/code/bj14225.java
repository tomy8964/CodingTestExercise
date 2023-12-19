package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14225 {

    public static int N;
    public static int[] numArr;
    public static boolean[] visited, answer;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        answer = new boolean[2000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        int num = 1;
        while (true) {
            visited = new boolean[N];
            dfs(0, num, 0);
            if (!answer[num]) {
                bw.write(num + "\n");
                break;
            }
            num++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int sum, int num, int index) {
        answer[sum] = true;
        if (sum == num) {
            answer[num] = true;
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(sum + numArr[i], num, i + 1);
                if (answer[num]) break;
                visited[i] = false;
            }
        }
    }
}
