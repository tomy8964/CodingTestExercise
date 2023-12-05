package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj14501 {

    public static int N;
    public static boolean[] visited;
    public static int[] dayArr;
    public static int[] costArr;
    public static int[] answerArr;
    public static int MAX = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dayArr = new int[N + 1];
        costArr = new int[N + 1];
        answerArr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            dayArr[i] = Integer.parseInt(split[0]);
            costArr[i] = Integer.parseInt(split[1]);
        }

        dfs(1);

        bw.write(MAX + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int day) {
        if (day > N) {
            int sum = 0;
            for (int answer : answerArr) {
                sum += answer;
            }
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int i = day; i < N + 1; i++) {
            day = i;
            if (!visited[i]) {
                if (day + dayArr[i] > N + 1) {
                    dfs(day + dayArr[i]);
                } else {
                    visited[i] = true;
                    answerArr[day] = costArr[i];
                    dfs(day + dayArr[i]);
                    answerArr[day] = 0;
                    visited[i] = false;
                }
            }
        }
    }
}
