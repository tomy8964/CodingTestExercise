package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountNum {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String array = br.readLine();
        String[] numArray = array.split(" ");

        int countNum = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < num; i++) {
            if (countNum == Integer.parseInt(numArray[i])) {
                count++;
            }
        }

        System.out.println(count);

//        bw.flush();
        bw.close();
        br.close();
    }
}
