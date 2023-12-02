package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj10973 {

    public static int N;
    public static int[] numArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        if (prePermutation()) {
            for (int num : numArr) {
                sb.append(num).append(" ");
            }
            bw.write(sb + "");
        } else bw.write(-1 + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean prePermutation() {
        // 4 2 1 3
        // -> 4 1 2 3
        // -> 4 1 3 2
        int startAscendingIndex = 0;
        int startSwapIndex = 0;
        int swapIndex = 0;
        for (int i = N - 1; i > 0; i--) {
            if (numArr[i] < numArr[i - 1]) {
                startAscendingIndex = i;
                startSwapIndex = i - 1;
                break;
            }
        }

        if (startAscendingIndex == 0) return false;

        for (int i = N - 1; i > startSwapIndex; i--) {
            if (numArr[i] < numArr[startSwapIndex]) {
                swapIndex = i;
                break;
            }
        }

        int temp = numArr[startSwapIndex];
        numArr[startSwapIndex] = numArr[swapIndex];
        numArr[swapIndex] = temp;

        int j = N - 1;
        for (int i = startAscendingIndex; i < j; i++) {
            temp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = temp;
            j--;
        }

        return true;
    }
}
