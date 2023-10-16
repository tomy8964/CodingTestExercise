package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj24264 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());
        System.out.println(n*n);
        System.out.println(2);

        bw.flush();
        bw.close();
        br.close();
    }
}
