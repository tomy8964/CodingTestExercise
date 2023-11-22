package codingTestFiles.code;

import java.io.*;

public class bj17087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int x = Integer.parseInt(split[1]);
        int[] arr = new int[N];

        String line1 = br.readLine();
        String[] split1 = line1.split(" ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(split1[i]);
            int d = Math.abs(x - a);
            arr[i] = d;
        }

        int result = arr[0];
        for (int i = 0; i < N; i++) {
            result = gcd(result, arr[i]);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
