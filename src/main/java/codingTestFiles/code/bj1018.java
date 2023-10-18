package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1018 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Boolean[][] arr = new Boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line1 = br.readLine();
            char[] charArray = line1.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == 'W') {
                    arr[i][j] = true;
                } else arr[i][j] = false;
            }
        }

        int min = m * n;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int count = 0;
                Boolean firstColor = arr[i][j];
                for (int x = i; x < 8 + i; x++) {
                    for (int y = j; y < 8 + j; y++) {
                        if (arr[x][y] != firstColor) {
                            count++;
                        }
                        firstColor = !firstColor;
                    }
                    firstColor = !firstColor;
                }
                if (min > count) {
                    min = Math.min(count, 64 - count);
                }
            }
        }

        System.out.println(min);

        bw.flush();
        bw.close();
        br.close();
    }
}
