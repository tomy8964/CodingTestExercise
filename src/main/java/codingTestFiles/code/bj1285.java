package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1285 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = N * N;
        char[][] coins = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < N; j++) {
                coins[i][j] = charArray[j];
            }
        }

        // 아무 행도 뒤집지 않은 공집합(0)부터
        // 모든 행을 뒤집은 (1<<N)-1까지
        // 모든 행을 뒤집는 선택을 탐색한다
        for (int bit = 0; bit < (1 << N); bit++) {
            // 이번 선택에 대해 열을 순회하며 T가 더 많은 열을 뒤집는다
            int sumT = 0;
            for (int j = 0; j < N; j++) {
                int colTCount = 0;
                for (int i = 0; i < N; i++) {
                    char tmp = coins[i][j];
                    // 예) bit가 010 이면 i가 1일때 값이 1이 되므로
                    // i는 1 즉, 두번째 행을 뒤집는다.
                    if ((bit & (1 << i)) != 0) {
                        tmp = (tmp == 'T') ? 'H' : 'T';
                    }
                    if (tmp == 'T') colTCount++;
                }
                // T가 더 많으면 뒤집어줌
                // 뒤집는다고 생각하고 적은 갯수를 더해줌
                sumT += Math.min(N - colTCount, colTCount);
            }
            answer = Math.min(answer, sumT);
        }

        System.out.println(answer);
        br.close();
    }
}

