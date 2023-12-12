package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class bj14226 {

    public static int S;
    public static boolean[][] visited = new boolean[2001][2001];
    public static Queue<Emoticon> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        S = Integer.parseInt(br.readLine());

        bfs(new Emoticon(0, 1, 0));

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Emoticon start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            if (start.display == S) {
                sb.append(start.time);
                break;
            }
            // 1. 화면에 있는 이모티콘 갯수 클립보드에 덮어쓰기
            // 1개를 덮어쓰고 큐에 삽입 -> 또 1개를 덮어쓰고 큐에 삽입 : 반복
            if (!visited[start.display][start.display]) {
                visited[start.display][start.display] = true;
                queue.add(new Emoticon(start.display, start.display, start.time + 1));
            }
            // 2. 클립보드에서 불러와서 화면에 붙여넣기
            // 0개를 붙여 넣는건 의미없으며 시간만 늘어나므로 패스
            // 붙여넣었을 때 문제의 조건인 2000개를 넘어가면 안되므로 패스
            if (start.clipboard != 0 && start.display + start.clipboard <= 2000) {
                if (!visited[start.display + start.clipboard][start.clipboard]) {
                    visited[start.display + start.clipboard][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display + start.clipboard, start.time + 1));
                }
            }
            // 3. 화면에 있는 이모티콘 1개 삭제
            // 화면에 이모티콘이 없으면 삭제할 수 없으므로
            if (start.display > 0) {
                // 삭제하여 만들어진 상태가 이미 있는 상태이면 더 오래 걸리는 방법이므로 패스
                if (!visited[start.display - 1][start.clipboard]) {
                    visited[start.display - 1][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display - 1, start.time + 1));
                }
            }
        }
    }

    public static class Emoticon {
        int clipboard;
        int display;
        int time;

        public Emoticon(int clipboard, int display, int time) {
            this.clipboard = clipboard;
            this.display = display;
            this.time = time;
        }
    }

}

