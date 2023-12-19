package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj16197 {

    public static int M, N, MIN = 10;
    public static Character[][] board;
    public static boolean[][][][] visited;
    public static boolean hasAnswer;
    public static Coin coin = new Coin();
    public static Queue<Coin> queue = new LinkedList<>();
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split2 = line.split(" ");
        N = Integer.parseInt(split2[0]);
        M = Integer.parseInt(split2[1]);

        board = new Character[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = charArray[j];
                if (board[i][j].equals('o')) {
                    if (coin.coin1 == null) {
                        coin.coin1 = new spot(i, j);
                    } else coin.coin2 = new spot(i, j);
                }
            }
        }

        queue.add(coin);
        bfs();

        if (MIN >= 10) bw.write(-1 + "\n");
        else bw.write(MIN + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Coin now = queue.poll();
            spot coin1 = now.coin1;
            spot coin2 = now.coin2;
            int count = now.count;
            visited[coin1.x][coin1.y][coin2.x][coin2.y] = true;
            if (hasAnswer) break;
            for (int i = 0; i < 4; i++) {
                int coin1NewX = coin1.x + xMove[i];
                int coin1NewY = coin1.y + yMove[i];
                int coin2NewX = coin2.x + xMove[i];
                int coin2NewY = coin2.y + yMove[i];
                if (hasAnswer) break;
                // 모든 코인을 움직였을때
                // coin1이 밖으로 떨어지는 경우
                if ((coin1NewX < 0 || coin1NewX >= N) || (coin1NewY < 0 || coin1NewY >= M)) {
                    // coin2는 안떨어졌을 경우
                    if (coin2NewX >= 0 && coin2NewX < N) {
                        if (coin2NewY >= 0 && coin2NewY < M) {
                            MIN = Math.min(MIN, count + 1);
                            hasAnswer = true;
                        }
                    }

                }
                // coin2가 밖으로 떨어지는 경우
                else if ((coin2NewX < 0 || coin2NewX >= N) || (coin2NewY < 0 || coin2NewY >= M)) {
                    // coin1은 안떨어졌을 경우
                    MIN = Math.min(MIN, count + 1);
                    hasAnswer = true;
                }
                // 둘다 안 떨어지는 경우
                else {
                    // 벽인지 아닌지 판별하여 큐에 삽입
                    if (board[coin1NewX][coin1NewY].equals('#')) {
                        // coin1이 움직일려는 곳만 벽
                        if (!board[coin2NewX][coin2NewY].equals('#')) {
                            if (!visited[coin1NewX][coin1NewY][coin2NewX][coin2NewY]) {
                                queue.add(new Coin(now.coin1, new spot(coin2NewX, coin2NewY), count + 1));
                            }

                        }
                    } else if (board[coin2NewX][coin2NewY].equals('#')) {
                        // coin2이 움직일려는 곳만 벽
                        if (!board[coin1NewX][coin1NewY].equals('#')) {
                            if (!visited[coin1NewX][coin1NewY][coin2NewX][coin2NewY]) {
                                queue.add(new Coin(new spot(coin1NewX, coin1NewY), now.coin2, count + 1));

                            }
                        }
                    }
                    // 둘다 벽 아님
                    else {
                        if (!visited[coin1NewX][coin1NewY][coin2NewX][coin2NewY]) {
                            queue.add(new Coin(new spot(coin1NewX, coin1NewY), new spot(coin2NewX, coin2NewY), count + 1));
                        }
                    }
                }
            }
        }
    }

    static class spot {
        int x;
        int y;

        spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Coin {
        spot coin1;
        spot coin2;
        int count;

        public Coin() {
            coin1 = null;
            coin2 = null;
            count = 0;
        }

        public Coin(spot coin1, spot coin2, int count) {
            this.coin1 = coin1;
            this.coin2 = coin2;
            this.count = count;
        }
    }
}

