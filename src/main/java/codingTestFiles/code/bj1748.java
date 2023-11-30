package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1748 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        // num 이 몇 자리 수인 지 봐야 한다.
        // num = 120
        char[] charArray = num.toCharArray();
        // 3
        int length = charArray.length;

        int answer = 0;
        int mul = 1;
        while (mul < length) {
            double pow = Math.pow(10, mul);
            answer += (int) (mul * (pow - Math.pow(10, mul - 1)));
            mul++;
        }

        answer += ((int) (Integer.parseInt(num) - Math.pow(10, length - 1) + 1) * length);

        bw.write(answer + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
