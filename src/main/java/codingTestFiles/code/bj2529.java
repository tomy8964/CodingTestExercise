package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2529 {

    public static int K;
    public static String MIN;
    public static String MAX;
    public static int[] answerArr;
    public static String[] letters;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        letters = new String[K];
        visited = new boolean[10];
        answerArr = new int[K + 1];
        MIN = String.valueOf((long) Math.pow(10, K + 1));
        MAX = String.valueOf(-1);

        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < K; i++) {
            letters[i] = split[i];
        }

        dfs(0);

        bw.write(MAX + "\n");
        bw.write(MIN + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == K + 1) {
            String str = "";
            for (int num : answerArr) {
                str += num;
            }
            long num = Long.parseLong(str);
            if (Long.parseLong(MAX) < num) {
                MAX = str;
            }
            if (Long.parseLong(MIN) > num) {
                MIN = str;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (depth > 0) {
                    if (letters[depth - 1].equals("<")) {
                        if (answerArr[depth - 1] < i) {
                            visited[i] = true;
                            answerArr[depth] = i;
                            dfs(depth + 1);
                            visited[i] = false;
                        }
                    } else {
                        if (answerArr[depth - 1] > i) {
                            visited[i] = true;
                            answerArr[depth] = i;
                            dfs(depth + 1);
                            visited[i] = false;
                        }
                    }
                } else {
                    visited[i] = true;
                    answerArr[depth] = i;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

