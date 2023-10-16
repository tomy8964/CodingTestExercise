package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj24266 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());
        System.out.println(n * n * n);
        System.out.println(3);

        bw.flush();
        bw.close();
        br.close();
    }
}
