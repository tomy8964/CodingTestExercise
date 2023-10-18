package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj19532 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int d = Integer.parseInt(split[3]);
        int e = Integer.parseInt(split[4]);
        int f = Integer.parseInt(split[5]);

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (((a * i + b * j) == c) && ((d * i + e * j) == f)) {
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
