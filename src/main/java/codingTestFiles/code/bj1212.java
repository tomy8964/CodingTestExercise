package codingTestFiles.code;

import java.io.*;
import java.math.BigInteger;

public class bj1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        BigInteger number = new BigInteger(num, 8);
        String answer = number.toString(2);

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
