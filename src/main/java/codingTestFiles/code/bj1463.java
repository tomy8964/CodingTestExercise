package codingTestFiles.code;

import java.io.*;

public class bj1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            // 1을 빼는 경우
            arr[i] = arr[i - 1] + 1;
            // 2로 나누는 경우
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i - 1] + 1, arr[i / 2] + 1);
            }
            // 3으로 나누는 경우
            if (i % 3 == 0) {
                int min = 0;
                if (i % 2 == 0){
                    min = Math.min(arr[i - 1] + 1, arr[i / 2] + 1);
                } else min = arr[i - 1] + 1;
                arr[i] = Math.min(min, arr[i / 3] + 1);
            }
        }

        bw.write(arr[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
