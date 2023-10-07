package codingTestFiles.code;

import java.io.*;
import java.util.StringTokenizer;

public class AplusBminus5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (num1 != num2 || num1 != 0) {
                System.out.println(num1 + num2);
            } else {
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
