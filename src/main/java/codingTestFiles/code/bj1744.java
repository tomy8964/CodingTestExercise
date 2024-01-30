package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj1744 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> pn = new ArrayList<>();
        List<Integer> nn = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pn.add(num);
            } else nn.add(num);
        }

        // 큰 수부터 곱하기
        pn.sort(Collections.reverseOrder());
        // 절대값이 큰 수부터 곱하기
        Collections.sort(nn);

        int answer = 0;
        for (int i = 0; i < pn.size(); i++) {
            if (i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i + 1) != 1) {
                answer += pn.get(i) * pn.get(i + 1);
                i++;
            } else answer += pn.get(i);
        }
        for (int i = 0; i < nn.size(); i++) {
            if (i + 1 < nn.size()) {
                answer += nn.get(i) * nn.get(i + 1);
                i++;
            } else answer += nn.get(i);
        }

        System.out.println(answer);
        br.close();
    }
}

