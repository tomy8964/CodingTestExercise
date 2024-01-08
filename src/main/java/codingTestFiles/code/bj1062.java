package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1062 {

    public static int N, K, answer = 0;
    public static boolean[] alphabet = new boolean[26];
    public static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        words = new String[N];

        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if (K == 26) {
            System.out.println(N);
            System.exit(0);
        }

        // anta + tica
        // a, c, n, t, i -> 5 개는 필수로 알아야 한다.
        alphabet[('a' - 'a')] = true;
        alphabet[('c' - 'a')] = true;
        alphabet[('n' - 'a')] = true;
        alphabet[('t' - 'a')] = true;
        alphabet[('i' - 'a')] = true;

        for (int i = 0; i < N; i++) {
            String str = br.readLine().replaceAll("anta|tica", "");
            words[i] = str;
        }

        dfs(0, 0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index, int depth) {
        if (depth == K - 5) {
            int count = 0;
            for (String word : words) {
                char[] charArray = word.toCharArray();
                boolean canRead = true;
                for (char c : charArray) {
                    if (!alphabet[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) count++;
            }
            answer = Math.max(count, answer);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                dfs(i, depth + 1);
                alphabet[i] = false;
            }
        }
    }

}

