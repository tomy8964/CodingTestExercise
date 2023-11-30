package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj1107 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수빈이가 지금 보고 있는 채널은 100번이다.

        // 채널 번호 N
        int N = Integer.parseInt(br.readLine());
        // 고장난 버튼 수 M
        int M = Integer.parseInt(br.readLine());
        if (M == 0) {
            int count = Math.abs(100 - N);
            System.out.println(Math.min(String.valueOf(N).length(), count));
        }
        else {
            // 고장난 버튼들 배열 buttons
            List<Integer> buttons2 = new ArrayList<>();
            // 안고장난 버튼들 배열 buttons
            List<Integer> buttons = new ArrayList<>();

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                buttons2.add(Integer.parseInt(split[i]));
            }
            for (int i = 0; i < 10; i++) {
                if (!buttons2.contains(i)) buttons.add(i);
            }
            // 현재 채널 번호 100과 이동하려는 채널과의 차이
            int count = Math.abs(100 - N);

            // 버튼들로 만들 수 있는 채널 번호에 가장 가까운 수 구하기
            int closeNum = 0;
            for (int i = 0; i < 1000000; i++) {
                // 더 가까운 수를 찾았을 때
                if ((Math.abs(N - i) + String.valueOf(i).length()) < count) {
                    // 그 수를 이루고 있는 수들 중 망가진 버튼의 수는 없는지 확인
                    char[] charArray = String.valueOf(i).toCharArray();
                    boolean breakButtons = false;
                    for (char c : charArray) {
                        // 망가진 버튼이다
                        if (!buttons.contains(Integer.parseInt(String.valueOf(c)))) {
                            breakButtons = true;
                            break;
                        }
                    }
                    // 검증 후
                    if (!breakButtons) {
                        closeNum = i;
                        count = Math.abs(N - i) + String.valueOf(closeNum).length();
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
