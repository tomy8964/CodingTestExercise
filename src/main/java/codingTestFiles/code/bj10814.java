package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj10814 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][3];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            arr[i][0] = split[0];
            arr[i][1] = split[1];
            arr[i][2] = String.valueOf(i);
        }

        Arrays.sort(arr, (arr1, arr2) -> {
            int n1 = Integer.parseInt(arr1[0]);
            int n2 = Integer.parseInt(arr2[0]);
            int n3 = Integer.parseInt(arr1[2]);
            int n4 = Integer.parseInt(arr2[2]);
            if (n1 == n2) {
                return n3 - n4;
            } else {
                return n1 - n2;
            }
        });

        for (String[] s : arr) {
            System.out.println(s[0] + " " + s[1]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
