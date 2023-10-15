package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj14215 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int maxN = 0;
        maxN = Math.max(a, b);
        maxN = Math.max(maxN, c);

        if (a + b + c - maxN > maxN) System.out.println(a + b + c);
        else System.out.println((a + b + c - maxN) * 2 - 1);

        bw.flush();
        bw.close();
        br.close();
    }
}
