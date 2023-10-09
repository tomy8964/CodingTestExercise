package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2444 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char[] charArray = line.toCharArray();
        int p = 1;
        for (int i = 0; i < charArray.length/2; i++) {
            if (charArray[i] != charArray[charArray.length - i-1]) {
                p = 0;
            }
        }

        System.out.println(p);

        bw.flush();
        bw.close();
        br.close();
    }
}
