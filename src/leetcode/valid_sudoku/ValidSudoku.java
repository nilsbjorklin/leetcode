package leetcode.valid_sudoku;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        int currentNumber;
        int blockNumber;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 46) {
                    currentNumber = board[i][j] - 49;
                    blockNumber = i / 3 * 3 + j / 3;
                    if (rows[i][currentNumber]) {
                        return false;
                    } else {
                        rows[i][currentNumber] = true;
                    }
                    if (cols[j][currentNumber]) {
                        return false;
                    } else {
                        cols[j][currentNumber] = true;
                    }
                    if (blocks[blockNumber][currentNumber]) {
                        return false;
                    } else {
                        blocks[blockNumber][currentNumber] = true;
                    }
                }
            }
        }
        return true;
    }

}