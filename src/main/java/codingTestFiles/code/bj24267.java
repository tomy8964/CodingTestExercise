package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj24267 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());
//        i -> [1, n-2]
//        j -> [i+1, n-1]
//        k -> [j+1, n]
//        nC3
        System.out.println(n * (n - 1) * (n - 2) / 6);
        System.out.println(3);

        bw.flush();
        bw.close();
        br.close();
    }
}
