package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj7562 {

    public static int N, count;
    public static int[][] chessboard;
    public static boolean[][] visited;
    static int[] xMove = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] yMove = {2, 1, -1, -2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] split = line1.split(" ");
            int currentX = Integer.parseInt(split[0]);
            int currentY = Integer.parseInt(split[1]);

            String line2 = br.readLine();
            String[] split1 = line2.split(" ");
            int destinationX = Integer.parseInt(split1[0]);
            int destinationY = Integer.parseInt(split1[1]);

            visited = new boolean[N][N];
            chessboard = new int[N][N];

            bfs(currentX, currentY);

            bw.write(chessboard[destinationX][destinationY] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<spot> queue = new LinkedList<>();
        queue.add(new spot(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            spot start = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = start.x + xMove[i];
                int newY = start.y + yMove[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < N) {
                        // 탐색하는 칸이 땅이며 아직 방문하지 않은 곳이라면
                        if (!visited[newX][newY]) {
                            queue.add(new spot(newX, newY));
                            chessboard[newX][newY] = chessboard[start.x][start.y] + 1;
                            visited[newX][newY] = true;
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
}

