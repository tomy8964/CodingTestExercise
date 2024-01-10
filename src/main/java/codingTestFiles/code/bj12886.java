package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj12886 {

    public static Queue<Stones> queue = new LinkedList<>();
    public static int A, B, C, ANSWER = 0;
    public static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        A = Integer.parseInt(split[0]);
        B = Integer.parseInt(split[1]);
        C = Integer.parseInt(split[2]);

        // 방문 처리 배열을 2차원으로 한 이유
        // -> 연산을 보면 X + X를 한 뒤 Y - X를 하면서 전체 돌의 갯수는 X, Y 와 변함이 없다.
        // -> 즉 A, B, C 중 두 개의 값만 알아도 나머지 하나는 자동으로 알 수 있다.
        visited = new boolean[1501][1501];

        // 합이 3으로 나누어 지지 않으면 돌을 같은 개수로 만들 수 없다
        if ((A + B + C) % 3 != 0) {
            ANSWER = 0;
        } else {
            bfs(new Stones(A, B, C));
        }

        bw.write(ANSWER + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Stones start) {
        queue.add(start);
        while (!queue.isEmpty()) {
            Stones current = queue.poll();
            int a = current.a;
            int b = current.b;
            int c = current.c;

            // 세 개가 모두 같아지면 true 반환
            if (a == b && b == c) {
                ANSWER = 1;
                break;
            }

            // 크기가 같지 않은 두 그룹을 고른다.
            if (a != b) {
                int newA = a > b ? a - b : a + a;
                int newB = a > b ? b + b : b - a;
                if (!visited[newA][newB]) {
                    queue.add(new Stones(newA, newB, c));
                    visited[newA][newB] = true;
                }
            }
            if (b != c) {
                int newB = b > c ? b - c : b + b;
                int newC = b > c ? c + c : c - b;
                if (!visited[newB][newC]) {
                    queue.add(new Stones(a, newB, newC));
                    visited[newB][newC] = true;
                }
            }
            if (a != c) {
                int newA = a > c ? a - c : a + a;
                int newC = a > c ? c + c : c - a;
                if (!visited[newA][newC]) {
                    queue.add(new Stones(newA, b, newC));
                    visited[newA][newC] = true;
                }
            }
        }
    }

    public static class Stones {
        int a;
        int b;
        int c;

        public Stones(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

}

