package codingTestFiles.code;

import java.io.*;
import java.util.StringTokenizer;

public class bj9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            long count = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            for (int x = 0; x < arr.length - 1; x++) {
                for (int y = x + 1; y < arr.length; y++) {
                    count += gcd(arr[x], arr[y]);
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
