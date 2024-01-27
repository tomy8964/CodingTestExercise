package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1080 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                A[i][j] = charArray[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                B[i][j] = charArray[j] - '0';
            }
        }

        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                // 같지 않아서 뒤집어야 한다
                if (A[i][j] != B[i][j]) {
                    // 뒤집기
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            // 0이면 1로 1이면 0으로 뒤집기
                            A[x][y] = (A[x][y] == 0) ? 1 : 0;
                        }
                    }
                    // 뒤집은 횟수 카운트
                    count++;
                }
            }
        }

        // A를 B로 바꿨는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 같지 않은 곳 확인
                if (A[i][j] != B[i][j]) {
                    count = -1;
                    break;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}

