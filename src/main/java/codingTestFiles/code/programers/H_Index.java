package codingTestFiles.code.programers;

import java.util.Arrays;

public class H_Index {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        // 0, 1, 3, 5, 6
        // 3, 4, 5, 6, 7
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }
        return answer;
    }
}
