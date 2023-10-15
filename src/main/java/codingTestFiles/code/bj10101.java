package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj10101 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        if ((n1 + n2 + n3) != 180) System.out.println("Error");
        else if (n1 == n2) {
            if (n1 == 60) System.out.println("Equilateral");
            else System.out.println("Isosceles");
        } else if (n2 == n3) {
            if (n2 == 60) System.out.println("Equilateral");
            else System.out.println("Isosceles");
        } else if (n3 == n1) {
            if (n3 == 60) System.out.println("Equilateral");
            else System.out.println("Isosceles");
        } else System.out.println("Scalene");

        bw.flush();
        bw.close();
        br.close();
    }
}
