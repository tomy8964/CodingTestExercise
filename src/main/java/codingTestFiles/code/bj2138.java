package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2138 {

    static int N, answer = Integer.MAX_VALUE;
    static int[] goal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] current = new int[N];
        goal = new int[N];

        char[] charArray = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            current[i] = charArray[i] - '0';
        }

        charArray = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            goal[i] = charArray[i] - '0';
        }

        // i 번째 스위치를 사용해서 i-1 번째 전구의 최종 상태를 결정한다.
        // 1 번째 스위치를 킬지 말지는 그 전의 전구가 없으므로 고를 수 없다.
        // 1 번째 스위치를 킬지 말지 두 가지 상황에 대해 알고리즘을 적용한다.

        // 1 번째 스위치를 안킨다 (그냥 진행)
        int[] tmp;
        tmp = current.clone();
        int count = 0;
        greedy(1, count, tmp);

        // 1 번째 스위치를 킨다
        current[0] = (current[0] == 0 ? 1 : 0);
        current[1] = (current[1] == 0 ? 1 : 0);
        count = 1;
        greedy(1, count, current);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }

    public static void greedy(int index, int count, int[] arr) {
        if (index == N) {
            if (arr[index - 1] == goal[index - 1]) {
                answer = Math.min(answer, count);
            }
            return;
        }

        // index-1 번째 전구의 상태가 다르면
        // index 번째 스위치를 눌러서 바꿔야 한다.
        if (arr[index - 1] != goal[index - 1]) {
            // index 번째 스위치 사용
            for (int i = index - 1; i <= index + 1; i++) {
                if (i >= N || i < 0) continue;
                arr[i] = (arr[i] == 0) ? 1 : 0;
            }
            greedy(index + 1, count + 1, arr);
        } else greedy(index + 1, count, arr);
    }
}

