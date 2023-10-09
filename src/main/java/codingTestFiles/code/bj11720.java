package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11720 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        char[] charArray = line.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            String s = String.valueOf(charArray[i]);
            sum = sum + Integer.parseInt(s);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}