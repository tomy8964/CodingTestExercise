package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj27893_특별한_트롭킥 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        line = br.readLine();
        char[] road = line.toCharArray();

        // 동호는 x = i 에 있다.
        // i + 1 에 장애물이 없을 시 이동한다. 1 시간 소요
        // i + 1부터 연속하여 존재하는 모든 장애물을 제거하고 가장 뒤에 있는 장애물의 x 좌표로 이동한다. 2 시간 소요

        // 동호는 1~N까지의 좌표 중 장애물이 없는 i 를 골라서 장애물을 설치하는 행동을 최대 M 번 할 수 있다.
        // 동호가 N 좌표에 도착하는데 걸리는 최소 시간을 구하시오.

        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = 0;
        right[N - 1] = 0;
        int max = 0;
        int maxX = 0;
        for (int i = 0; i < N; i++) {
            if (road[i] == 'X') continue;
            int leftCount = 0;
            for (int j = i - 1; j > -1; j--) {
                if (road[j] == 'X') leftCount++;
                else break;
            }
            left[i] = leftCount;
            int rightCount = 0;
            for (int j = i + 1; j < N; j++) {
                if (road[j] == 'X') rightCount++;
                else break;
            }
            right[i] = rightCount;
            if (max < rightCount + leftCount) {
                maxX = i;
            }
        }

        while (M > 0) {
            road[maxX] = 'X';
            
            M--;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (road[i] == '.') {
                answer++; // 장애물 없이 이동
            } else {
                // 장애물을 만나면, 다음 '.'까지 이동하는데 2시간 소요
                while (i < N && road[i] == 'X') {
                    i++;
                }
                answer += 2;
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
