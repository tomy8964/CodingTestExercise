package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1157 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().toUpperCase();
        char[] charArray = line.toCharArray();
        int[] count = new int[26];

        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'A';
            count[index]++;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            } else if (max == count[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
