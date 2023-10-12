package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1193 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        (0,0)(1,0)(0,1)(0,2)(1,1)(2,0)(3,0)(2,1)(1,2)(0,3)
//          1    2    3    4    5    6    7    8    9   10
//        {1/1, 1/2, 2/1, 3/1, 2/2, 1/3, 1/4, 2/3, 3/2, 4/1}
// T        2    3    3    4    4    4    5    5    5    5

        int tNum = 0;
        int countNum = 0;

        if (n == 1) {
            System.out.println("1/1");
        } else {
            while (countNum < n) {
                tNum++; // 다음 대각선 그룹으로 이동
                countNum = tNum * (tNum + 1) / 2; // 지금 대각선 그룹까지의 원소의 갯수
            }

            int index = n - (tNum * (tNum - 1) / 2); // 지금 대각선 그룹에서 몇 번째 index에 위치한지 계산 (입력 받은 숫자 - 전 번째 대각선 그룹까지의 원소 갯수)

            // 짝수 대각선 그룹이면 위에서 부터 시작
            // 대각선 그룹의 분자 + 분모 합 = 대각선 그룹의 순서 +1
            if (tNum % 2 == 0) {
                int top = index;
                int bottom = tNum + 1 - top;
                System.out.println(top + "/" + bottom);
            } else {
                int bottom = index;
                int top = tNum + 1 - bottom;
                System.out.println(top + "/" + bottom);
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
