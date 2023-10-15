package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1085 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int w = Integer.parseInt(split[2]);
        int h = Integer.parseInt(split[3]);

        if (x <= w - x) {
            if (h - y > x) {
                if (y < x) {
                    System.out.println(y);
                } else {
                    System.out.println(x);
                }
            } else {
                if (h - y < y) {
                    System.out.println(h - y);
                } else System.out.println(y);
            }
        } else {
            if (h - y > w - x) {
                if (y < w - x) {
                    System.out.println(y);
                } else {
                    if (w - x < x) {
                        System.out.println(w - x);
                    } else System.out.println(x);
                }
            } else {
                if (h-y < y){
                    System.out.println(h - y);
                } else System.out.println(y);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
