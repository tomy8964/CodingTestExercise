package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj10819 {

    public static int N;
    public static boolean[] visited;
    public static int[] numArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        visited = new boolean[N];
        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }


        Arrays.sort(numArr);
        int[] arr1 = new int[N / 2];
        int[] arr2 = new int[N / 2];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = numArr[i];
        }
        int j = 0;
        for (int i = numArr.length / 2; j < arr2.length; i++) {
            arr2[j] = numArr[i];
            j++;
        }

        int answer = 0;

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                answer -= arr1[x];
                x++;
            } else {
                answer += arr2[y];
                y++;
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
