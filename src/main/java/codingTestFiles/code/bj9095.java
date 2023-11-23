package codingTestFiles.code;

import java.io.*;

public class bj9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {

            String line = br.readLine();
            int N = Integer.parseInt(line);
            int[] arr = new int[100];

            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;

            for (int i = 4; i < N + 1; i++) {
                arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            }

            bw.write(arr[N] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
