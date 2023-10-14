package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1978 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] split = line.split(" ");

        int count = n;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(split[i]);
            if (num == 1) {
                count--;
                continue;
            }
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}
