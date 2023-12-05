package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj11723 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 20이 집합에 있을 수 있는 가장 큰 수이다.
        // 즉 21비트 짜리 정수로 표현할 수 있다.
        // int 자료형은 4바이트 (8bit * 4 = 32bits) 이므로
        // int 자료형 변수 하나를 선언한다.

        int a = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            switch (split[0]) {
                case "add": {
                    a = a | (1 << Integer.parseInt(split[1]));
                    break;
                }
                case "check": {
                    if (0 < (1 << Integer.parseInt(split[1]) & a)) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                }
                case "remove": {
                    a = a & ~(1 << Integer.parseInt(split[1]));
                    break;
                }
                case "toggle": {
                    if (0 < (1 << Integer.parseInt(split[1]) & a)) {
                        a = a & ~(1 << Integer.parseInt(split[1]));
                    } else {
                        a = a | (1 << Integer.parseInt(split[1]));
                    }
                    break;
                }
                case "all": {
                    a = a | (1 << 21) - 1;
                    break;
                }
                case "empty": {
                    a = 0;
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

