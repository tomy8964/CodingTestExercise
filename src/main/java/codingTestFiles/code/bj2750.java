package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj2750 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        Object[] array = arr.toArray();
        Arrays.sort(array);

        for (Object a : array) {
            System.out.println(a);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
