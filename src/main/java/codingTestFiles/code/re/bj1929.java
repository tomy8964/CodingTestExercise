package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1929 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[1]);
        boolean[] prime = new boolean[num2 + 1];

        // true : 소수 아님
        prime[0] = prime[1] = true;

        for (int i = 2; i < Math.sqrt(num2 + 1); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < num2 + 1; j = j + i) {
                prime[j] = true;
            }
        }

        for (int i = num1; i < num2 + 1; i++) {
            if (!prime[i]) System.out.println(i);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
