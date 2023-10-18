package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj2587 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            arr.add(n);
            sum += n;
        }

        Object[] array = arr.toArray();
        Arrays.sort(array);

        System.out.println(sum / 5);
        System.out.println(array[2]);

        bw.flush();
        bw.close();
        br.close();
    }
}
