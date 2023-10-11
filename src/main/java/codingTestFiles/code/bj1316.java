package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class bj1316 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = n;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < charArray.length; j++) {
                if (!list.contains(charArray[j])) {
                    list.add(charArray[j]);
                } else {
                    if (Math.abs(list.lastIndexOf(charArray[j]) - j) > 1) {
                        count--;
                        break;
                    } else {
                        list.add(charArray[j]);
                    }
                }
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
