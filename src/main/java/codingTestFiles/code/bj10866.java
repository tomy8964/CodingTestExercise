package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj10866 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();
            switch (instruction) {
                case "push_front": {
                    int num = Integer.parseInt(st.nextToken());
                    queue.addFirst(num);
                    break;
                }
                case "push_back": {
                    int num = Integer.parseInt(st.nextToken());
                    queue.addLast(num);
                    break;
                }
                case "pop_front": {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.pollFirst());
                    } else System.out.println(-1);
                    break;
                }
                case "pop_back": {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.pollLast());
                    } else System.out.println(-1);
                    break;
                }
                case "size": {
                    System.out.println(queue.size());
                    break;
                }
                case "empty": {
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                }
                case "front": {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peekFirst());
                    } else System.out.println(-1);
                    break;
                }
                case "back": {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peekLast());
                    } else System.out.println(-1);
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
