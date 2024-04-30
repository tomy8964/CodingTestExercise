package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj2805 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        List<Integer> trees = new ArrayList<>();
        String[] treeH = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees.add(Integer.parseInt(treeH[i]));
        }

        Collections.sort(trees);
        int start = 0;
        int end = trees.get(N - 1);

        while (start < end) {
            // 나무 자르는 높이
            int mid = (start + end) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            // 높이를 낮춰서 나무를 더 잘라야 한다.
            if (sum < M) {
                end = mid;
            } else {
                // 높이를 높여서 나무를 덜 잘라야 한다.
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

        bw.flush();
        bw.close();
        br.close();
    }
}
