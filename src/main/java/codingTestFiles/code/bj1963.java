package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class bj1963 {
    static boolean[] prime = new boolean[10000], visited;
    static boolean yesAnswer;
    static String ANSWER = "Impossible", A, B;
    static Queue<num> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 소수는 false
        // 0 과 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true; // 소수 아님

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            yesAnswer = false;
            String line = br.readLine();
            String[] split = line.split(" ");
            A = split[0];
            B = split[1];

            visited = new boolean[10000];
            bfs(new num(A, 0), new num(B, 0));

            bw.write(ANSWER + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(num A, num B) {
        queue.add(A);

        while (!queue.isEmpty()) {
            num current = queue.poll();

            if (current.num.equals(B.num)) {
                if (!yesAnswer) {
                    ANSWER = String.valueOf(current.count);
                    yesAnswer = true;
                } else {
                    ANSWER = String.valueOf(Math.min(Integer.parseInt(ANSWER), current.count));
                }
            }

            char[] charArray = current.num.toCharArray();
            for (int i = 0; i < 4; i++) {
                int number = charArray[i] - '0';
                // 항상 네 자리 수를 유지 (제일 앞에 0은 안됨)
                for (int j = (i == 0) ? 1 : 0; j < 10; j++) {
                    // 같은 숫자는 바꾸는 것이 아니므로 패스
                    if (j == number) continue;
                    char changeNum = Character.forDigit(j, 10);

                    StringBuilder sb = new StringBuilder(current.num);
                    sb.setCharAt(i, changeNum);
                    String string = sb.toString();
                    int newNumber = Integer.parseInt(string);
                    // 바꾼 숫자가 소수인지 확인
                    if (!prime[newNumber]) {
                        // 이미 만들어진 숫자인지 확인
                        if (!visited[newNumber]) {
                            visited[newNumber] = true;
                            queue.add(new num(String.valueOf(newNumber), current.count + 1));
                        }
                    }
                }
            }
        }
    }

    public static class num {
        String num;
        int count;

        public num(String num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}

