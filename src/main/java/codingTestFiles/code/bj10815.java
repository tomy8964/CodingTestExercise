package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            card[i] = (Integer.parseInt(split[i]));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> find = new ArrayList<>();
        String[] split1 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            find.add(Integer.parseInt(split1[i]));
        }

        Arrays.sort(card);

        for (Integer i : find) {
            int result = Arrays.binarySearch(card, i);
            if (result > -1) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }

        }
        br.close();
    }
}
