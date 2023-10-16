package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj24313 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int a1 = Integer.parseInt(split[0]);
        int a2 = Integer.parseInt(split[1]);

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int answer = 1;

        for (int i = n0; i < 100; i++) {
//            f(n) = a1 * i + a2
//            c = c
//            g(n) = i
            if ((a1 * i + a2) > (c * i)) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
