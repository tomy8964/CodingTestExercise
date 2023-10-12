package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2292 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 2;
//        1 = 1 1
//        2 ~ 7 = 2 (6)
//        8 ~ 19 = 3 (12)
//        20 ~ 37 = 4 (18)

        while (range <= n) {
            range = range + count * 6;
            count++;
        }
        if (n == 1) System.out.println(1);
        else System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}
