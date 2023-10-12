package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2869 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int v = Integer.parseInt(split[2]);

        int days = (v - b) / (a - b);

        if ((v - b) % (a - b) != 0) {
            days++;
        }


        bw.write(days + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
