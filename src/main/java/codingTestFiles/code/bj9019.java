package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj9019 {

    public static int A, B;
    public static boolean[] visited;
    public static String[] command;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            A = Integer.parseInt(split[0]);
            B = Integer.parseInt(split[1]);

            visited = new boolean[10001];
            command = new String[10001];
            Arrays.fill(command,"");

            bfs(A, B);

        }


        br.close();
    }

    public static void bfs(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        visited[A] = true;

        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            if (n == B) {
                System.out.println(command[n]);
                break;
            }
            // D
            int D = (n * 2) % 10000;
            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                command[D] = command[n] + "D";
            }
            // S
            int S = n - 1;
            if (n == 0) {
                S = 9999;
            }
            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                command[S] = command[n] + "S";
            }
            // L
            int L = n % 1000 * 10 + n / 1000;
            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                command[L] = command[n] + "L";
            }
            // R
            int R = n / 10 + n % 10 * 1000;
            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                command[R] = command[n] + "R";
            }
        }
    }

}

