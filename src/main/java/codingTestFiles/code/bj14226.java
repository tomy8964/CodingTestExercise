package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class bj14226 {

    public static int S, clipboard, display, time;
    public static boolean[] visited = new boolean[2001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        S = Integer.parseInt(br.readLine());

        bfs(1);

        bw.write(time + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;
        display = start;
        clipboard = 0;
        time = 0;

        while (!queue.isEmpty()) {
            start = queue.poll();
            visited[start] = true;
            // 화면에 있는 이모티콘 갯수 클립보드에 덮어쓰기
            // 클립보드에서 불러와서 화면에 붙여넣기
            // 화면에 있는 이모티콘 -1
        }
    }

}

