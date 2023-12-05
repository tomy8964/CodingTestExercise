package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1182 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0이면 가로, 1이면 세로
        String line = br.readLine();
        String[] split = line.split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[][] numArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String[] split1 = line1.split(" ");
            for (int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(split1[j]);
            }
        }

        int MAX = -1;
        // 000...000 ~ 111...111 까지 구하면서 최대 값을 구한다.
        for (int i = 0; i < (1 << N * M); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

