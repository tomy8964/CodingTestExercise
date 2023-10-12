package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj2720 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            int q = money / 25;
            int d = (money % 25) / 10;
            int n = ((money % 25) % 10) / 5;
            int p = (((money % 25) % 10) % 5);
            System.out.println(q + " " + d + " " + n + " " + p);
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
