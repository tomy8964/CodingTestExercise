package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj6588 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean prime[] = new boolean[1000001];

        // true : 소수 아님
        prime[0] = prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        int num = Integer.parseInt(br.readLine());
        while (num != 0) {
            boolean isProve = false;
            for (int i = 3; i < num + 1; i += 2) {
                if (!prime[num - i] && !prime[i]) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    isProve = true;
                    break;
                }
            }
            if (!isProve) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
            num = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
