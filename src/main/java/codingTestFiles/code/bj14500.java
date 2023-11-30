package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj14500 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // i 번째 줄 j 번째 칸일 때

        // 5 가지의 경우가 있다.

        // 1. 오른쪽으로 4칸인거
        // - arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3]
        // j+3 < N

        // 2. 오른쪽으로 2칸 아래로 2칸
        // - arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1]
        // j+1 < N, i+1 < N

        // 3. 아래로 3칸, 오른쪽으로 1칸
        // - arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1]
        // i+2 < N, j+1<N

        // 4. 아래로 2칸, 오른쪽으로 2칸, 아래로 1칸
        // - arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+1]
        // i+2 < N, j+1<N

        // 5. 오른쪽으로 2칸 아래로 한칸 오른쪽으로 한칸
        // - arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i][j+2]
        // j+2 < N, i+1<N


        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1 오른쪽으로
                if (j + 3 < M) {
                    if (max < (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]))
                        max = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
                }
                // 1 아래쪽으로
                if (i + 3 < N) {
                    if (max < (arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j]))
                        max = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
                }
                // 2
                if (i + 1 < N && j + 1 < M) {
                    if (max < (arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1]))
                        max = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                }
                // i + 2 < N, j + 1 < M 안에 범위
                if (i + 2 < N && j + 1 < M) {
                    // 1, 3, 4, 7, 14
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 2][j]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j]));
                }
                // i + 2 < N, j > 0 안에 범위
                if (i + 2 < N && j > 0) {
                    // 2, 8, 16
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j - 1]));
                }
                // i + 1 < N, j + 2 < M
                if (i + 1 < N && j + 2 < M) {
                    // 5, 6, 9, 11
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i + 1][j + 2] + arr[i][j + 1] + arr[i][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2]));
                }
                // i > 0, j + 2 < M
                if (i > 0 && j + 2 < M) {
                    // 10, 12, 13, 15
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i - 1][j + 2]));
                    max = Math.max(max, (arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i][j + 2]));
                    max = Math.max(max, (arr[i-1][j] + arr[i-1][j + 1] + arr[i - 1][j + 2] + arr[i][j + 1]));
                    }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
