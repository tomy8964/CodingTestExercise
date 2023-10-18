package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj2798 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);


        String line2 = br.readLine();
        String[] split2 = line2.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < split2.length; i++) {
            numbers.add(Integer.parseInt(split2[i]));
        }

        int max = 0;

        for (int i : numbers) {
            for (int j : numbers) {
                if (i == j) continue;
                for (int z : numbers) {
                    if (z == i) continue;
                    else if (z == j) continue;
                    else {
                        if ((i + j + z <= m) && ((i + j + z > max))) {
                            max = (i + j + z);
                        }
                    }
                }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
