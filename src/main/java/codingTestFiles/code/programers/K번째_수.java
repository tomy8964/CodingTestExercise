package codingTestFiles.code.programers;

import java.util.Arrays;

public class K번째_수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array, commands);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] newArray = new int[j - i + 1];
            for (int q = 0; q <= j - i; q++) {
                newArray[q] = array[i + q - 1];
            }
            Arrays.sort(newArray);
            answer[a] = newArray[k - 1];
        }

        return answer;
    }
}
