package codingTestFiles.code.re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17299 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[1000001];
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = st.nextToken();
            arr[i] = Integer.parseInt(line);
            count[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty()&&(count[arr[stack.peek()]] < count[arr[i]])){
                    result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for(int i=0; i<result.length; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
