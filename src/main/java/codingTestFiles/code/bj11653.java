package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj11653 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        while (num != 1) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    System.out.println(i);
                    num /= i;
                    break;
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
