package codingTestFiles.code;

import java.io.*;
import java.math.BigInteger;

public class bj1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();
        // number 스트링을 2진수로 받기
        BigInteger binary = new BigInteger(number, 2);

        String answer = binary.toString(8);


        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
