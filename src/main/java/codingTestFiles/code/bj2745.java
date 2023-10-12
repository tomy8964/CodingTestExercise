package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2745 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        String N = split[0];
        int B = Integer.parseInt(split[1]);
        int tmp = 0;
        double sum = 0;

        for (int i = N.length() - 1; i > -1; i--) {
            char c = N.charAt(i);
            if ('0' <= c && c <= '9') {
                sum = sum + (c - 48) * Math.pow(B, tmp);
            } else {
                sum = sum + (c - 55) * Math.pow(B, tmp);
            }
            tmp++;
        }

        bw.write((int) sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
