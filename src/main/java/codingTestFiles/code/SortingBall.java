package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SortingBall {

    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);

        int[] array = new int[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int f = 0; f < M; f++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> tmp = new ArrayList<>();
            for (int k = j; k >= i; k--) {
                tmp.add(array[k]);
            }
            for (int k = 0; k < tmp.size(); k++) {
                array[i + k] = tmp.get(k);
            }
        }

        for (int j : array) {
            System.out.print(j + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}