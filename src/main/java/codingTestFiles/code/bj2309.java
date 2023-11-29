package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class bj2309 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] h = new int[9];
        for (int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }

        int finish = 0;
        for (int i = 0; i < 8; i++) {
            if (finish == 1) break;
            for (int j = i + 1; j < 9; j++) {
                if (finish == 1) break;
                if (sum - h[i] - h[j] == 100) {
                    h[i] = 0;
                    h[j] = 0;
                    Arrays.sort(h);
                    for (int z = 2; z < 9; z++) {
                        bw.write(h[z] + "\n");
                    }
                    finish = 1;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
