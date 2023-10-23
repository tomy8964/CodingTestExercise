package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class bj1874 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > start) {
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    result.add("+");
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            result.add("-");
        }

        for (String s : result) {
            System.out.println(s);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
