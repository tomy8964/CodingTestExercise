package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class bj17413 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] charArray = line.toCharArray();
        boolean check = false;

        for (Character c : charArray) {
            if (c.equals('<')) {
                check = true;
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
            } else if (c.equals('>')) {
                check = false;
                sb.append(c);
            } else if (check) {
                sb.append(c);
            } else {
                if (c.equals(' ')) {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else stack.push(c);
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
