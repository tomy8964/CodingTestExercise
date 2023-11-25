package codingTestFiles.code.kakao;

import java.util.ArrayList;
import java.util.List;

public class kakao2 {

    public static void main(String[] args) throws Exception {
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };

        int n = dice.length;
        int k = n / 2;

        // A가 가져간 N / 2 개의 주사위 조합에서 나올 수 있는 수
        // 남겨진 주사위 중 N / 2 개의 주사위를 가져가서 나올 수 있는 수 비교

        List<List<Integer>> combinations = generateSplitCombinations(n);

        // Print and save the combinations to a file, database, etc.
        System.out.println("Split Combinations:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
            for (int i = 0; i < n / 2; i++) {

            }
        }
    }

    private static List<List<Integer>> generateSplitCombinations(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        // Populate the numbers from 1 to n
        for (int i = 0; i <= n - 1; i++) {
            numbers.add(i);
        }

        generateSplitCombinationsHelper(numbers, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSplitCombinationsHelper(List<Integer> remainingNumbers, int start,
                                                        List<Integer> currentCombination, List<List<Integer>> result) {
        if (currentCombination.size() == remainingNumbers.size() / 2) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < remainingNumbers.size(); i++) {
            currentCombination.add(remainingNumbers.get(i));
            generateSplitCombinationsHelper(remainingNumbers, i + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1); // Backtrack
        }
    }
}
