package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1546 {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int n = Integer.parseInt(line);

        double[] array = new double[n];

        line = br.readLine();
        st = new StringTokenizer(line);
        double high = 0;
        for (int i = 0; i < n; i++) {
            double num = Integer.parseInt(st.nextToken());
            if (num > high) {
                high = num;
            }
            array[i] = num;
        }
        double sum = 0;
        for (double i : array) {
            sum = sum + i / high * 100;
        }

        bw.write(sum / n + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}