package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj3009 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> xarr = new ArrayList<>();
        List<Integer> yarr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            xarr.add(x);
            yarr.add(y);
        }

        for (int x : xarr) {
            int count = 0;
            for (int i = 0; i < xarr.size(); i++) {
                if (xarr.get(i).equals(x)) {
                    count++;
                }
            }
            if (count == 1) System.out.print(x);
        }
        for (int y : yarr) {
            int count = 0;
            for (int i = 0; i < yarr.size(); i++) {
                if (yarr.get(i).equals(y)) {
                    count++;
                }
            }
            if (count == 1) System.out.print(" " + y);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
