package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class bj1339 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            int position = 1;
            for (int j = charArray.length - 1; j >= 0; j--) {
                alphabet[charArray[j] - 'A'] += position;
                position *= 10;
            }
        }

        Arrays.sort(alphabet);
        int index = 9;
        int sum = 0;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0) {
                break;
            }
            sum += alphabet[i] * index;
            index--;
        }


        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

