package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj3085 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] candy = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < N; j++) {
                candy[i][j] = charArray[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽에 다른 색의 캔디일 때
                if (j != N - 1) {
                    if (candy[i][j] != candy[i][j + 1]) {
                        // 캔디 체인지
                        changeCandyRight(j, candy[i]);
                        // 그때 먹을 수 있는 사탕의 최대 개수
                        answer = countCandy(N, candy, answer);
                        // 원상 복구
                        changeCandyRight(j, candy[i]);
                    }
                }
                // 아래쪽에 다른 색의 캔디일 때
                if (i != N - 1) {
                    if (candy[i][j] != candy[i + 1][j]) {
                        // 캔디 체인지
                        changeCandyBottom(candy[i], j, j, candy[i + 1]);
                        // 그때 먹을 수 있는 사탕의 최대 개수
                        answer = countCandy(N, candy, answer);
                        // 원상 복구
                        changeCandyBottom(candy[i], j, j, candy[i + 1]);
                    }
                }
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int countCandy(int N, char[][] candy, int answer) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 먹는 사탕의 갯수 카운트
                int count = 1;
                // 오른쪽으로 먹을 때
                for (int q = y + 1; q < N; q++) {
                    if (candy[x][y] == candy[x][q]) {
                        count++;
                    } else break;
                }
                if (count > answer) answer = count;
                // 아래로 먹을 때
                count = 1;
                for (int q = x + 1; q < N; q++) {
                    if (candy[x][y] == candy[q][y]) {
                        count++;
                    } else break;
                }
                if (count > answer) answer = count;
            }
        }
        return answer;
    }

    private static void changeCandyBottom(char[] candy, int j, int j1, char[] candy1) {
        char temp = candy[j];
        candy[j] = candy1[j1];
        candy1[j1] = temp;
    }

    private static void changeCandyRight(int j, char[] candy) {
        changeCandyBottom(candy, j, j + 1, candy);
    }
}
