package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SmallerThanX {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine);

        String secondLine = br.readLine();
        String[] numArray2 = secondLine.split(" ");

        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(numArray2[i]) < min) {
                min = Integer.parseInt(numArray2[i]);
            }
            if (Integer.parseInt(numArray2[i]) > max) {
                max = Integer.parseInt(numArray2[i]);
            }
        }

        bw.write(min + " " + max);

        bw.flush();
        bw.close();
        br.close();
    }
}