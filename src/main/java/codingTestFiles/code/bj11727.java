package codingTestFiles.code;

import java.io.*;

public class bj11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i < N + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
        }

        bw.write(arr[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
