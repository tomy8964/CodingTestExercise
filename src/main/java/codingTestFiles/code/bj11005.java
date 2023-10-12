package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class bj11005 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int num = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        List<Integer> arr = new ArrayList<>();
        while (num != 0) {
            arr.add(num % B);
            num /= B;
        }

        for (int i = (arr.size() - 1); i > -1; i--) {
            Integer n = arr.get(i);
            if (n <= 9) {
                System.out.print(n);
            } else {
                System.out.print((char) (n + 55));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
