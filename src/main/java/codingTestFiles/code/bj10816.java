package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class bj10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card = new HashMap<>();
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            if (card.get(num) == null) {
                card.put(num, 1);
            } else {
                card.put(num, card.get(num) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] split1 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            Integer i1 = card.get(Integer.parseInt(split1[i]));
            if (i1 == null) {
                bw.write(0 + " ");
            } else bw.write(i1 + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
