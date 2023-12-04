package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj1759 {

    public static int L;
    public static int C;
    public static Character[] vowel = {'a', 'e', 'i', 'o', 'u'};
    public static String[] charArr;
    public static String[] answerArr;
    public static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        answerArr = new String[L];
        charArr = new String[C];
        visited = new boolean[C];

        String line1 = br.readLine();
        String[] split1 = line1.split(" ");

        for (int i = 0; i < C; i++) {
            charArr[i] = split1[i];
        }

        Arrays.sort(charArr);

        dfs(0, 0);

        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int index) {
        if (depth == L) {
            String s = "";
            int vowelCount = 0;
            int elseCount = 0;
            for (String str : answerArr) {
                s += str;
            }
            s += "\n";
            char[] charArray = s.toCharArray();
            for (Character c : charArray) {
                if (c.equals('a')) {
                    vowelCount++;
                } else if (c.equals('e')) {
                    vowelCount++;
                } else if (c.equals('i')) {
                    vowelCount++;
                } else if (c.equals('o')) {
                    vowelCount++;
                } else if (c.equals('u')) {
                    vowelCount++;
                } else if (c.equals('\n')) {
                    break;
                }
                else elseCount++;
            }
            if (vowelCount >= 1 && elseCount >= 2) sb.append(s);
            return;
        }
        for (int i = index; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerArr[depth] = charArr[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
