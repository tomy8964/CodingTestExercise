package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2941 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char[] charArray = line.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'c' && i + 1 < charArray.length) {
                if (charArray[i + 1] == '=' || charArray[i + 1] == '-') {
                    i++;
                }
            }
            if (charArray[i] == 'd' && i + 1 < charArray.length) {
                if (charArray[i + 1] == '-') {
                    i++;
                } else if (charArray[i + 1] == 'z' && i + 2 < charArray.length) {
                    if (charArray[i + 2] == '=') {
                        i += 2;
                    }
                }
            }
            if (charArray[i] == 'l' && i + 1 < charArray.length) {
                if (charArray[i + 1] == 'j') {
                    i++;
                }
            }
            if (charArray[i] == 'n' && i + 1 < charArray.length) {
                if (charArray[i + 1] == 'j') {
                    i++;
                }
            }
            if (charArray[i] == 's' && i + 1 < charArray.length) {
                if (charArray[i + 1] == '=') {
                    i++;
                }
            }
            if (charArray[i] == 'z' && i + 1 < charArray.length) {
                if (charArray[i + 1] == '=') {
                    i++;
                }
            }
            count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
