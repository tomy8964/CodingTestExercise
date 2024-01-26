package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj11399 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(time);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                answer += time[j];
            }
        }


        System.out.println(answer);
        br.close();
    }
}

