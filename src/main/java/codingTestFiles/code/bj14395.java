package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class bj14395 {
    static long s, t, ANSWER = -1;
    static boolean yesAnswer = false;
    static String answer;
    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        s = Integer.parseInt(split[0]);
        t = Integer.parseInt(split[1]);

        if (s == t) {
            System.out.println(0);
            System.exit(0);
        } else {
            bfs(new node(s, ""), new node(t, ""));

            if (!yesAnswer) {
                bw.write(ANSWER + "");
            } else {
                bw.write(answer);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(node s, node t) {
        Queue<node> queue = new LinkedList<>();
        queue.add(s);
        set.add(s.num);

        while (!queue.isEmpty()) {
            node current = queue.poll();

            if (current.num == t.num) {
                yesAnswer = true;
                answer = current.cul;
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    long newNum = current.num * current.num;
                    if (newNum < 1 || newNum > 1000000000) continue;
                    if (!set.contains(newNum)) {
                        set.add(newNum);
                        queue.add(new node(newNum, current.cul + "*"));
                    }
                } else if (i == 1) {
                    long newNum = current.num + current.num;
                    if (newNum < 1 || newNum > 1000000000) continue;
                    if (!set.contains(newNum)) {
                        set.add(newNum);
                        queue.add(new node(newNum, current.cul + "+"));
                    }
                } else if (i == 2) {
                    long newNum = current.num - current.num;
                    if (newNum < 1 || newNum > 1000000000) continue;
                    if (!set.contains(newNum)) {
                        set.add(newNum);
                        queue.add(new node(newNum, current.cul + "-"));
                    }
                } else {
                    if (current.num == 0) continue;
                    long newNum = current.num / current.num;
                    if (newNum < 1 || newNum > 1000000000) continue;
                    if (!set.contains(newNum)) {
                        set.add(newNum);
                        queue.add(new node(newNum, current.cul + "/"));
                    }
                }
            }
        }
    }

    public static class node {
        long num;
        String cul;

        public node(long num, String cul) {
            this.num = num;
            this.cul = cul;
        }
    }
}

