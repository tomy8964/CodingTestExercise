package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj11650 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(arr, (arr1, arr2) -> {
                    if (arr1[0] == arr2[0]) {
                        return arr1[1] - arr2[1];
                    } else return arr1[0] - arr2[0];
                }
        );

        for (int[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
