package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj1783 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int answer = 0;
        // N == 1 세로 한칸일 경우 움직일 수 있는 경우의 수가 없으므로
        if (N == 1) {
            answer = 1;
        }
        // N >= 2 세로 두칸일 경우 2, 3번 조건으로만 움직일 수 있으며
        // 문제에 조건에 따라 모든 조건으로 움직일 수 없으므로
        // 최대 4칸 방문 가능 (시작지점 포함)
        else if (N == 2) {
            // 2, 3번 조건은 오른쪽으로 2칸씩 움직이므로
            answer = Math.min((M + 1) / 2, 4);
        }
        // M < 7 인 경우
        // 모든 조건으로 움직일 수는 없다
        // 그러면 총 최대 4칸까지만 방문할 수 있다.
        // 최대로 많이 움직이기 위해 오른쪽으로 1칸만 움직이는
        // 1, 3번 조건으로만 움직이면 총 M 칸을 움직일 수 있다.
        else if (M < 7) {
            answer = Math.min(M, 4);
        }
        // M >= 7 인 경우
        // 모든 조건으로 움직일 수 있으며
        // 최대한 많은 칸을 움직이려면 오른쪽으로 2칸 가는
        // 2, 3번 조건은 한번씩만 사용하고
        // 나머지는 오른쪽으로 한칸씩만 움직이는
        // 1, 4번 조건으로 움직인다.
        else {
            answer = M - 2;
        }

        System.out.println(answer);
        br.close();
    }
}