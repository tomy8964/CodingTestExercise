package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj10809 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        StringBuilder sb1 = new StringBuilder(split[0]);
        StringBuilder sb2 = new StringBuilder(split[1]);
        StringBuilder reverse1 = sb1.reverse();
        StringBuilder reverse2 = sb2.reverse();
        int num1 = Integer.parseInt(reverse1.toString());
        int num2 = Integer.parseInt(reverse2.toString());

        if (num1 > num2) {
            bw.write(num1 + "\n");
        } else bw.write(num2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}