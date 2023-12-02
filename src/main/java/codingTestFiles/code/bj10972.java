package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj10972 {

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

        if (nextPermutation()) {
            for (int num : numArr) {
                sb.append(num).append(" ");
            }
            bw.write(sb + "");
        } else bw.write(-1 + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean nextPermutation() {
        int startDescendingIndex = 0;
        int startSwapIndex = 0;
        int swapIndex = 0;

        // 내림차순 시작 위치와 숫자 바꾸기를 시작할 위치 찾기
        // --> 7 2 3 6 5 4 1
        // 6 5 4 1 로 가장 긴 감소하는 수열이 만들어진다.
        // numArr[startDescendingIndex] = 6
        // numArr[startSwapIndex] = 3
        for (int i = N - 1; i > 0; i--) {
            if (numArr[i - 1] < numArr[i]) {
                startDescendingIndex = i;
                startSwapIndex = i - 1;
                break;
            }
        }

        // 내림차순의 시작이 제일 앞이면 가장 마지막 순열이란 뜻이므로 다음 순열은 없다
        if (startDescendingIndex == 0) {
            return false;
        }

        // 이 순열을 다음 순열로 바꾸기 위해
        // 감소하는 순열 6 5 4 1 의 다음 수는 없으므로
        // numArr[startSwapIndex] = 3 을 다음으로 큰 수로 바꿔야 한다.
        // --> 7 2 3 6 5 4 1
        for (int i = N - 1; i > startSwapIndex; i--) {
            if (numArr[startSwapIndex] < numArr[i]) {
                swapIndex = i;
                break;
            }
        }

        // --> 7 2 4 6 5 3 1
        int temp = numArr[startSwapIndex];
        numArr[startSwapIndex] = numArr[swapIndex];
        numArr[swapIndex] = temp;

        // 6 5 3 1 을 이제 swap 해준다
        // --> 7 2 4 1 3 5 6
        int j = N - 1;
        for (int i = startDescendingIndex; i < j; i++) {
            temp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = temp;
            j--;
        }
        return true;
    }
}
