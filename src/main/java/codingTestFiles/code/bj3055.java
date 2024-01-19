package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class bj3055 {

    static Queue<point> queue = new LinkedList<>();
    static Queue<point> waterQueue = new LinkedList<>();
    static String ANSWER = "KAKTUS";
    static char[][] map;
    static boolean[][] visited, waterVisited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        map = new char[R][C];
        visited = new boolean[R][C];
        waterVisited = new boolean[R][C];

        point D = null, S = null, water = null;

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = charArray[j];
                if (map[i][j] == 'D') {
                    D = new point(i, j, 0);
                } else if (map[i][j] == 'S') {
                    S = new point(i, j, 0);
                } else if (map[i][j] == '*') {
                    water = new point(i, j, 0);
                    waterQueue.add(water);
                }
            }
        }

        bfs(D, S);

        System.out.println(ANSWER);
        br.close();
    }

    public static void bfs(point end, point start) {
        queue.add(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            int sameMinutes = queue.size();
            for (int s = 0; s < sameMinutes; s++) {
                point current = queue.poll();
                if (map[current.x][current.y] == '*') continue;

                for (int i = 0; i < 4; i++) {
                    int newX = current.x + xMove[i];
                    int newY = current.y + yMove[i];

                    if (newX < 0 || newY < 0 || newX >= R || newY >= C) continue;

                    // 도착
                    if (newX == end.x && newY == end.y) {
                        ANSWER = "" + (current.count + 1);
                        return;
                    }

                    // 이동할 곳이 돌이거나 물이 아니면 이동
                    if (map[newX][newY] != 'X' && map[newX][newY] != '*') {
                        if (!visited[newX][newY]) {
                            visited[newX][newY] = true;
                            queue.add(new point(newX, newY, current.count + 1));
                        }
                    }
                }
            }
            // 1분 지남 물 움직임
            waterFlow();
        }
    }

    public static void waterFlow() {
        int sameMinutes = waterQueue.size();
        for (int s = 0; s < sameMinutes; s++) {
            point current = waterQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + xMove[i];
                int newY = current.y + yMove[i];

                if (newX < 0 || newY < 0 || newX >= R || newY >= C) continue;

                // 이동할 곳이 돌이 아니면 물이 참
                if (map[newX][newY] != 'X' && map[newX][newY] != 'D') {
                    if (!waterVisited[newX][newY]) {
                        map[newX][newY] = '*';
                        waterVisited[newX][newY] = true;
                        waterQueue.add(new point(newX, newY, 0));
                    }
                }
            }
        }
    }

    public static class point {
        int x;
        int y;
        int count;

        public point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

