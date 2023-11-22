package codingTestFiles.code;

import java.io.*;

public class bj17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[10000001];
        prime[0] = prime[1] = true; // 소수 아님
        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (!prime[j]) {
                    int last = num - j;
                    if ((last >= j)&&(!prime[last])) {
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
