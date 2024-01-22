package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class bj6087 {
    static char[][] map;
    static int[][][] visited;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, -1, 0, 1};
    static int W, H, ANSWER = 100000;
    static Queue<point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        W = Integer.parseInt(split[0]);
        H = Integer.parseInt(split[1]);

        map = new char[H][W];
        visited = new int[H][W][4];

        point start = null;

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = charArray[j];
                if (map[i][j] == 'C') {
                    start = new point(i, j, 0, 0);
                }
            }
        }

        bfs(start);

        System.out.println(ANSWER);
        br.close();
    }

    public static void bfs(point start) {
        queue.add(start);
        for (int i = 1; i < 4; i++) {
            queue.add(new point(start.x, start.y, start.count, i));
        }

        while (!queue.isEmpty()) {
            point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + xMove[i];
                int newY = current.y + yMove[i];

                if (newX < 0 || newY < 0 || newX >= H || newY >= W) continue;

                if (map[newX][newY] == '*') continue;

                if (map[newX][newY] == 'C') {
                    if (i != current.direction) {
                        ANSWER = Math.min(ANSWER, current.count + 1);
                    } else {
                        ANSWER = Math.min(ANSWER, current.count);
                    }
                    continue;
                }

                if (visited[newX][newY][i] > current.count) {
                    visited[newX][newY][i] = current.count;
                    // 같은 방향으로 가는게 아니라면 거울을 하나 더 사용해야 하므로
                    // count + 1
                    // direction 변경
                    if (i != current.direction) {
                        // 180 회전이라면 패스
                        if (i - current.direction == 2) continue;
                        queue.add(new point(newX, newY, current.count + 1, i));
                    } else {
                        queue.add(new point(newX, newY, current.count, current.direction));
                    }
                }
            }
        }
    }

    public static class point {
        int x;
        int y;
        int count;
        // 0, 1, 2, 3
        // 상, 하, 좌, 우
        int direction;

        public point(int x, int y, int count, int direction) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.direction = direction;
        }
    }
}

