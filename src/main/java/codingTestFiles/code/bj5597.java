package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj5597 {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[30];

        for (int i = 0; i < 28; i++) {
            int student = Integer.parseInt(br.readLine());
            arr[student-1] = 1;
        }

        for (int i = 0; i < 30; i++) {
            if (arr[i] != 1) {
                bw.write(i + 1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}