package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj24265 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());
//        i -> [1, n-1]
//        j -> [i+1, n]
//        (2, 3, 4, ..., n) 번 실행
//        -> (1, ... , n-1) 번 실행
//        -> (n-1) * n / 2 번 실행 (등차수열)
        System.out.println((n-1) * n / 2);
        System.out.println(2);

        bw.flush();
        bw.close();
        br.close();
    }
}
