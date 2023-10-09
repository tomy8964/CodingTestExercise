package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj25083 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int k = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);
        int l = Integer.parseInt(split[2]);
        int v = Integer.parseInt(split[3]);
        int n = Integer.parseInt(split[4]);
        int p = Integer.parseInt(split[5]);

        System.out.print(1-k);
        System.out.print(" ");
        System.out.print(1-q);
        System.out.print(" ");
        System.out.print(2-l);
        System.out.print(" ");
        System.out.print(2-v);
        System.out.print(" ");
        System.out.print(2-n);
        System.out.print(" ");
        System.out.print(8-p);

        bw.flush();
        bw.close();
        br.close();
    }
}