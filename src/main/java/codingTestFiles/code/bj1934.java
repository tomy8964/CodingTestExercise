package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1934 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int j = 0; j < N; j++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int max = 1;

            for (int i = 1; i <= num1; i++) {
                if (num1 % i == 0 && num2 % i == 0) {
                    if (i > max) {
                        max = i;
                    }
                }
            }

            int min = num1 * num2 / max;

            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
