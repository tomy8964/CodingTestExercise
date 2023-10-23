package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj10828 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();
            switch (instruction) {
                case "push": {
                    int pushNum = Integer.parseInt(st.nextToken());
                    stack.add(pushNum);
                    break;
                }
                case "top": {
                    if (stack.size() - 1 >= 0) {
                        Integer topNum = stack.get(stack.size() - 1);
                        System.out.println(topNum);
                    } else System.out.println(-1);
                    break;
                }
                case "size": {
                    System.out.println(stack.size());
                    break;
                }
                case "empty": {
                    int size = stack.size();
                    if (size != 0) {
                        System.out.println(0);
                    } else System.out.println(1);
                    break;
                }
                case "pop": {
                    if (stack.size() - 1 >= 0) {
                        Integer topNum = stack.get(stack.size() - 1);
                        System.out.println(topNum);
                        stack.remove(stack.lastIndexOf(topNum));
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
