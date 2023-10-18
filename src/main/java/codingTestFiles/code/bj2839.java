package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2839 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n == 4 || n == 7) {
            count = -1;
        } else if (n % 5 == 0) {
            count = (n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) {
            count = (n / 5) + 1;
        } else if (n % 5 == 2 || n % 5 == 4) {
            count = (n / 5) + 2;
        }

        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}
