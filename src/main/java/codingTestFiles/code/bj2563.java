package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2563 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[][] arr = new int[100][100];

        String N = br.readLine();
        int n = Integer.parseInt(N);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            for (int j = x; j < x + 10; j++) {
                for (int z = y; z < y + 10; z++) {
                    arr[j][z] = 1;
                }
            }
        }

        int count = 0;
        for (int[] a : arr) {
            for (int b : a) {
                if (b == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}
