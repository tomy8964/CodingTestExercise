package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class bj16236 {
    static int[][] map;
    static boolean[][] visited;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, -1, 0, 1};
    static int N, sharkSize = 2, eatCount = 0, time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        point start = null;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 9) {
                    start = new point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        bfs(start);

        System.out.println(time);
        br.close();
    }

    public static void bfs(point start) {
        while (true) {
            Queue<point> shark = new LinkedList<>();
            List<point> preyList = new ArrayList<>();
            visited = new boolean[N][N];
            shark.add(start);
            visited[start.x][start.y] = true;

            // 현재 상어의 크기로 먹을 수 있는 먹이 리스트 찾기
            while (!shark.isEmpty()) {
                point current = shark.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = current.x + xMove[i];
                    int newY = current.y + yMove[i];

                    if (newX < 0 || newY < 0 || newX >= N || newY >= N || visited[newX][newY]) continue;

                    // 갈 곳의 물고기의 크기가 상어보다 크다면 갈 수 없으므로 패스
                    if (map[newX][newY] > sharkSize) continue;

                    // 갈 곳의 물고기의 크기가 상어보다 작으면 먹을 수 있으므로 먹이 목록에 추가
                    if (map[newX][newY] < sharkSize && map[newX][newY] != 0) {
                        preyList.add(new point(newX, newY, current.time + 1));
                        visited[newX][newY] = true;
                    } // 같은 크기의 물고기라 이동만 할 수 있다면 그저 이동
                    else {
                        shark.add(new point(newX, newY, current.time + 1));
                        visited[newX][newY] = true;
                    }
                }
            }
            // 찾아낸 먹이 리스트 확인
            // 먹을 수 있는 먹이가 없다면 종료
            if (preyList.isEmpty()) {
                break;
            } // 문제의 조건에 따라 먹어야 하는 먹이 정하기
            else {
                // 먹을 수 있는 먹이가 1개보다 많다면 가장 최단 거리 중 왼쪽 위의 먹이를 먹어야 한다.
                if (preyList.size() > 1) {
                    preySort(preyList);
                }

                // 먹이 먹기
                point prey = preyList.get(0);
                // 먹이 칸 0으로 초기화
                map[prey.x][prey.y] = 0;
                // 지금까지 걸린 시간에 이번 먹이를 먹는데 걸린 시간 합
                time += prey.time;
                // 다시 출발하는 아기 상어의 위치 변경
                // 또한 다시 출발하는 상어 위치부터 걸린 시간을 재야 하므로 시간은 0으로 생성
                start = new point(prey.x, prey.y, 0);
                // 먹이 먹은 갯수 + 1
                eatCount++;
                // 상어의 크기만큼 먹이를 먹었으면 상어의 크기 + 1 & 먹이 먹은 갯수 0으로 초기화
                if (eatCount == sharkSize) {
                    sharkSize++;
                    eatCount = 0;
                }
            }
        }
    }

    static void preySort(List<point> list) {
        list.sort((o1, o2) -> {
            // 1. 가장 가까운(move) 2. 가장 위 (x) , 3.가장 왼쪽(y)
            if (o1.time == o2.time) {
                if (o1.x == o2.x) {
                    // 가장 왼쪽
                    return o1.y - o2.y;
                } else {
                    // 가장 위
                    return o1.x - o2.x;
                }
            } else {
                // 가장 가까운 곳
                return o1.time - o2.time;
            }
        });
    }

    public static class point {
        int x;
        int y;
        int time;

        public point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}

