package codingTestFiles.code.re;

import java.io.*;

public class bj11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] split = line.split(" ");
        int[] arr = new int[N + 1];
        int[] max = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(split[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                max[i] = Math.max(max[i], max[i - j] + arr[j]);
            }
        }

        bw.write(max[N] + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
