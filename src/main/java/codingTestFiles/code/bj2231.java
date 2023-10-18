package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj2231 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        n = x%10 + x/10 + x/100 +x/1000 + x/10000 + x/100000 + x/1000000 + x;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
