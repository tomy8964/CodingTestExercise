package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj9086 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            char c1 = charArray[0];
            System.out.print(c1);
            char c2 = charArray[charArray.length - 1];
            System.out.println(c2);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}