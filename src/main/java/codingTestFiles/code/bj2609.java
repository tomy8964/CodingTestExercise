package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2609 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[1]);
        int min = num1 * num2;
        int max = 1;

        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                if (i > max) {
                    max = i;
                }
            }
        }

        for (int i = num1 * num2; i >= num1; i--) {
            if (i % num1 == 0 && i % num2 == 0) {
                if (i < min) {
                    min = i;
                }
            }
        }

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
