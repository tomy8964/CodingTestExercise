package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj9093 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = "";

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                try {
                    String line = st.nextToken();
                    StringBuffer sb = new StringBuffer(line);
                    StringBuffer reverse = sb.reverse();
                    System.out.print(reverse + " ");
                } catch (Exception e) {
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
