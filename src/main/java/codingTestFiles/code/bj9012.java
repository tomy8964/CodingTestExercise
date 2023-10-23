package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj9012 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            int empty = 0;
            for (Character c : charArray) {
                if (c == '(') {
                    stack.push('(');
                } else {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("NO");
                        empty = 1;
                        break;
                    }
                }
            }
            if (empty == 0) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else System.out.println("NO");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
