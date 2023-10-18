package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj1427 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char[] charArray = line.toCharArray();
        int[] arr = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(charArray[i]));
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i > -1; i--) {
            System.out.print(arr[i]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
