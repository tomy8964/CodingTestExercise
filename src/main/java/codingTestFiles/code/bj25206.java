package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj25206 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        double sum = 0;
        double sumHakJum = 0;

        while (true) {
            line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            String name = st.nextToken();
            String num1 = st.nextToken();
            String num2 = st.nextToken();
            double n1 = Double.parseDouble(num1);
            double n2 = 0;
            switch (num2) {
                case "A+":
                    n2 = 4.5;
                    break;
                case "A0":
                    n2 = 4.0;
                    break;
                case "B+":
                    n2 = 3.5;
                    break;
                case "B0":
                    n2 = 3.0;
                    break;
                case "C+":
                    n2 = 2.5;
                    break;
                case "C0":
                    n2 = 2.0;
                    break;
                case "D+":
                    n2 = 1.5;
                    break;
                case "D0":
                    n2 = 1.0;
                    break;
                case "P":
                    n2 = 5.0;
                    break;
            }
            if (n2 != 5.0) {
                sumHakJum += n1;
                sum = sum + n1 * n2;
            }
        }

        bw.write(sum / sumHakJum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
