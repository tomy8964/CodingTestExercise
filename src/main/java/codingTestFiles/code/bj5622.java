package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj5622 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().trim();
        char[] charArray = line.toCharArray();
        int time = 0;
        for (char c : charArray) {
            int ascii = c;
            if (ascii < 68) {
                time = time + 3;
            } else if (ascii < 71) {
                time = time + 4;
            } else if (ascii < 74) {
                time = time + 5;
            } else if (ascii < 77) {
                time = time + 6;
            } else if (ascii < 80) {
                time = time + 7;
            } else if (ascii < 84) {
                time = time + 8;
            } else if (ascii < 87) {
                time = time + 9;
            } else if (ascii < 91) {
                time = time + 10;
            } else {
                time = time + 11;
            }
        }

        bw.write(time + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}