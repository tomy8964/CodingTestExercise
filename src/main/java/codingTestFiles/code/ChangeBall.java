package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChangeBall {

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
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        for (int j : array) {
            System.out.print(j + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}