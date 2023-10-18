package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class bj18870 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] split = line.split(" ");
        int[] arr = new int[split.length];
        int[] origin = new int[split.length];

        for (int i = 0; i < n; i++) {
            origin[i] = arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        for (int o : origin) {
            Integer value = map.get(o);
            bw.write(value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
