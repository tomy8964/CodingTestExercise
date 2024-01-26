package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj11047 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = N - 1; i > -1; i--) {
            answer += K / cost[i];
            K %= cost[i];
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

