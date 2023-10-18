package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj1181 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (!arr.contains(line)) {
                arr.add(line);
            }
        }

        String[] array = new String[arr.size()];
        array = arr.toArray(array);

        Arrays.sort(array, (arr1, arr2) -> {
            if (arr1.length() == arr2.length()) {
                return arr1.compareTo(arr2);
            } else return arr1.length() - arr2.length();
        });

        for (String s : array) {
            System.out.println(s);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
