package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj9506 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            List<Integer> arr = new ArrayList<>();
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    arr.add(i);
                }
            }
            int count = 0;
            for (int n : arr) {
                count += n;
            }
            if (count == num) {
                System.out.print(num + " = ");
                for (int n : arr) {
                    System.out.print(n);
                    if (arr.indexOf(n) == arr.size()-1) {
                        System.out.println();
                    } else {
                        System.out.print(" + ");
                    }
                }
            } else System.out.println(num + " is NOT perfect.");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
