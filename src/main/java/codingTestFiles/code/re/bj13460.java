package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj13460 {

    public static int M, N, MIN = 10;
    public static Character[][] board;
    public static boolean[][][][] visited;
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
                if (board[i][j].equals('R')) {
                    coin.red = new spot(i, j);
                } else if (board[i][j].equals('B')) {
                    coin.blue = new spot(i, j);
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
            spot red = now.red;
            spot blue = now.blue;
            int count = now.count;
            visited[red.x][red.y][blue.x][blue.y] = true;
            for (int i = 0; i < 4; i++) {
                int redNewX = red.x + xMove[i];
                int redNewY = red.y + yMove[i];
                int blueNewX = blue.x + xMove[i];
                int blueNewY = blue.y + yMove[i];
                boolean redIn = false;
                boolean blueIn = false;
                while (true) {
                    if (redNewX >= 0 && redNewX < N) {
                        if (redNewY >= 0 && redNewY < M) {
                            if (board[redNewX][redNewY].equals('O')) {
                                redIn = true;
                                board[redNewX - xMove[i]][redNewY - yMove[i]] = '.';
                                break;
                            } // 벽이거나 R로 막힐때
                            else if (!board[redNewX][redNewY].equals('.')) {
                                redNewX -= xMove[i];
                                redNewY -= yMove[i];
                                break;
                            }
                            // '.'일 때
                            else {
                                board[redNewX][redNewY] = 'R';
                                board[redNewX - xMove[i]][redNewY - yMove[i]] = '.';
                                redNewX += xMove[i];
                                redNewY += yMove[i];
                            }
                        }
                    }
                }
                while (true) {
                    if (blueNewX >= 0 && blueNewX < N) {
                        if (blueNewY >= 0 && blueNewY < M) {
                            if (board[blueNewX][blueNewY].equals('O')) {
                                visited[redNewX][redNewY][blueNewX][blueNewY] = true;
                                blueIn = true;
                                board[blueNewX - xMove[i]][blueNewY - yMove[i]] = '.';
                                break;
                            } // 벽이거나 R로 막힐때
                            else if (!board[blueNewX][blueNewY].equals('.')) {
                                blueNewX -= xMove[i];
                                blueNewY -= yMove[i];
                                break;
                            }
                            // '.'일 때
                            else {
                                board[blueNewX][blueNewY] = 'B';
                                board[blueNewX - xMove[i]][blueNewY - yMove[i]] = '.';
                                blueNewX += xMove[i];
                                blueNewY += yMove[i];
                            }
                        }
                    }
                }
                if (redIn && !blueIn) {
                    MIN = Math.min(MIN, count + 1);
                }
                board[red.x][red.y] = 'R';
                board[blue.x][blue.y] = 'B';
                if (!visited[redNewX][redNewY][blueNewX][blueNewY]) {
                    visited[redNewX][redNewY][blueNewX][blueNewY] = true;
                    queue.add(new Coin(new spot(redNewX, redNewY), new spot(blueNewX, blueNewY), count + 1));
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
        spot red;
        spot blue;
        int count;

        public Coin() {
            red = null;
            blue = null;
            count = 0;
        }

        public Coin(spot coin1, spot coin2, int count) {
            this.red = coin1;
            this.blue = coin2;
            this.count = count;
        }
    }
}

