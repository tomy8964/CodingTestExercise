package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj5073 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            int max = -1;
            int maxIndex = 0;
            String[] split = line.split(" ");

            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(split[i]) > max) {
                    max = Integer.parseInt(split[i]);
                    maxIndex = i;
                }
            }
            if (max == 0) break;

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if (i != maxIndex) sum += Integer.parseInt(split[i]);
            }
            if (sum <= Integer.parseInt(split[maxIndex])) {
                System.out.println("Invalid");
            } else {
                int n1 = Integer.parseInt(split[0]);
                int n2 = Integer.parseInt(split[1]);
                int n3 = Integer.parseInt(split[2]);

                if (n1 == n2) {
                    if (n2 == n3) System.out.println("Equilateral");
                    else System.out.println("Isosceles");
                } else if (n1 == n3) {
                    System.out.println("Isosceles");
                } else if (n2 == n3) {
                    System.out.println("Isosceles");
                } else System.out.println("Scalene");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
