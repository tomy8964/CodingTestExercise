package codingTestFiles.code.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

    public static boolean[][] visited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static boolean answer = false;

    public static void main(String[] args) {
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
        answer = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        // board = [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//        exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS");
//        answer = exist(new char[][]{{'a'}}, "a");
        System.out.println(answer);
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    visited = new boolean[m][n];
                    dfs(board, word, i, j, 0);
                    if (answer) {
                        return true;
                    }
                }
            }
        }
        return answer;
    }

    private static void dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            answer = true;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + xMove[k];
            int y = j + yMove[k];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && board[x][y] == word.charAt(index + 1)) {
                dfs(board, word, x, y, index + 1);
                if (answer) {
                    return;
                }
            }
        }
        visited[i][j] = false;
    }
}
