package codingTestFiles.code.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class kakao1 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int[] result = new int[friends.length];
        int[][] dp = new int[friends.length][friends.length];
        for (String g : gifts) {
            String[] split = g.split(" ");
            String from = split[0];
            String to = split[1];
            int fromIndex = 0;
            int toIndex = 0;
            for (int i = 0; i < friends.length; i++) {
                if (friends[i].equals(from)) {
                    fromIndex = i;
                } else if (friends[i].equals(to)) {
                    toIndex = i;
                }
            }
            dp[fromIndex][toIndex]++;
        }

        int[][] giftPoint = new int[friends.length][3];

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i==j) continue;
                giftPoint[i][0] += dp[i][j];
                giftPoint[i][1] += dp[j][i];
            }
        }

        for (int i = 0; i < friends.length; i++) {
            giftPoint[i][2] = giftPoint[i][0] - giftPoint[i][1];
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i==j) continue;
                // i가 j에게 준 선물 갯수가 받은 갯수보다 많을 때
                // i = 0, j = 2
                if (dp[i][j] > dp[j][i]) {
                    result[i]++;
                } else if (((dp[i][j] == 0) && (dp[j][i] == 0)) || (dp[i][j] == dp[j][i])) {
                    if (giftPoint[i][2] > giftPoint[j][2]) {
                        result[i]++;
                    }
                }
            }
        }

        System.out.println(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
