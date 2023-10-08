package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Maximum {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        int max = 0;
        int maxIndex = 0;

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) {
                break;
            } else {
                int num = Integer.parseInt(line);
                index++;
                if (num > max) {
                    max = num;
                    maxIndex = index;
                }
            }
        }

        bw.write(max + "\n" + maxIndex);

        bw.flush();
        bw.close();
        br.close();
    }
}