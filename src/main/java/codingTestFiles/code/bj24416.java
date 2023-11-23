package codingTestFiles.code;

import java.io.*;

public class bj24416 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        System.out.print(fibo(N) + " ");
        System.out.print(N - 2);

        br.close();
        bw.flush();
        bw.close();
    }

    public static int fibo(int x) {
        int[] fibos = new int[x + 1];
        fibos[1] = fibos[2] = 1;
        for (int i = 3; i < x + 1; i++) {
            fibos[i] = fibos[i - 1] + fibos[i - 2];
        }
        return fibos[x];
    }
}
