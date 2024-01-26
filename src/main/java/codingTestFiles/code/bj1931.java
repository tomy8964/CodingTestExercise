package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class bj1931 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            time[i][0] = Integer.parseInt(split[0]);
            time[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(time, (o1, o2) -> {

            // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int nowTime = 0, answer = 0;

        for (int i = 0; i < N; i++) {
            // 직전 회의 종료 시간 이후에 시작하는 회의인지 확인
            if (time[i][0] >= nowTime) {
                nowTime = time[i][1];
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}

