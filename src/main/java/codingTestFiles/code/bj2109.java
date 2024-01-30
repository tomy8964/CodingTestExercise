package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2109 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        lecture[] lectures = new lecture[N];

        int lastDay = -1;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split1 = line.split(" ");
            lectures[i] = new lecture(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
            lastDay = Math.max(lastDay, lectures[i].day);
        }

        // 페이가 쎈 것부터 확인
        Arrays.sort(lectures, (o1, o2) -> o2.pay - o1.pay);

        boolean[] day = new boolean[lastDay + 1];
        long answer = 0;
        for (lecture l : lectures) {
            int d = l.day;
            while (d > 0) {
                if (!day[d]) {
                    answer += l.pay;
                    day[d] = true;
                    break;
                }
                --d;
            }
        }

        System.out.println(answer);
        br.close();
    }

    public static class lecture {
        int pay;
        int day;

        public lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
}

