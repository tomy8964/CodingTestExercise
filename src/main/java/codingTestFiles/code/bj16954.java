package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class bj16954 {

    static Queue<player> queue = new LinkedList<>();
    static int ANSWER = 0;
    static char[][] map = new char[8][8];
    static int[] xMove = {1, -1, 0, 0, 1, 1, -1, -1, 0};
    static int[] yMove = {0, 0, -1, 1, 1, -1, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = charArray[j];
            }
        }

        bfs(new player(7, 0));

        System.out.println(ANSWER);
        br.close();
    }

    public static void bfs(player start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            // 각 위치에서 파생된 위치만큼 확인하고 벽을 한칸 내려야 한다.
            int sameDepth = queue.size();
            for (int s = 0; s < sameDepth; s++) {
                player current = queue.poll();
                // 벽에 먹힌 위치면 건너뜀
                if (map[current.x][current.y] == '#') continue;

                for (int i = 0; i < 9; i++) {
                    int newX = current.x + xMove[i];
                    int newY = current.y + yMove[i];

                    if (newX < 0 || newY < 0 || newX >= 8 || newY >= 8) continue;

                    // 도착
                    if (newX == 0 && newY == 7) {
                        ANSWER = 1;
                        return;
                    }

                    // 이동할 곳이 벽이 아니면 이동
                    if (map[newX][newY] != '#') {
                        queue.add(new player(newX, newY));
                    }
                }
            }
            wallDown();
        }
    }

    public static void wallDown() {
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
    }

    public static class player {
        int x;
        int y;

        public player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

