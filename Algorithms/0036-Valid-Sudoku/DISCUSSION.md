*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->

This function checks if a given 9x9 Sudoku board is valid or not. The function first checks if the input board is valid, which means it is not null and has a length and width of 9. If the board is not valid, it returns false.

If the board is valid, the function iterates through each cell in the board and checks if it contains a digit. If it contains a digit, the function calls the `isValidSudoku` helper function to check if the digit is valid in its row, column, and 3x3 square.

The `isValidSudoku` helper function checks if the digit at the given cell is valid in its row and column by iterating through all the cells in the same row and column and checking if any of them contain the same digit. It also checks if the digit is valid in the 3x3 square by calculating the starting row and column of the 3x3 square and iterating through all the cells in the square and checking if any of them contain the same digit.

If the digit is valid in its row, column, and 3x3 square, the `isValidSudoku` helper function returns true. If the digit is not valid in any of those locations, it returns false.

If the $$isValidSudoku$$ helper function returns false, the main function immediately returns false because the board is not valid. If the function completes the iteration over all the cells and none of them are invalid, it returns true because the board is valid.

# Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `isValidSudoku` function is O(1) because it always checks the same number of cells (i.e., 27 cells) regardless of the size of the input board. The time complexity of the `isValidSudoku` function called within the main function is O(n<sup>2</sup>) where n is the size of the input board. This is because the `isValidSudoku` function iterates over each row, column, and 3x3 square once.

The time complexity of the main function `isValidSudoku` is O(n<sup>2</sup>) because it iterates over each cell in the input board once and calls the `isValidSudoku` helper function once for each cell. Therefore, the total time complexity is O(n<sup>2</sup>).

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the isValidSudoku function is O(1) because it uses a constant amount of space to store variables to check for valid digits. The space complexity of the main function isValidSudoku is also O(1) because it uses only a constant amount of space for its variables. Therefore, the total space complexity is O(1).

# Code
```java []
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.' && !isValidSudoku(board, i, j))
                    return false;

        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int i, int j) {
        for(int k = 0; k < 9; k++)
            if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j]))
                return false;

        int row = (i / 3) * 3, col = (j / 3) * 3;
        for(int k = row; k < row + 3; k++)
            for(int n = col; n < col + 3; n++)
                if(i != k && n != j && board[i][j] == board[k][n])
                    return false;

        return true;
    }
}
```

# DOC Code
```java []
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check if board is null or not 9x9
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        // Check if each cell in the board is valid
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                // Check if cell contains a digit and if the digit is valid in its row, column, and 3x3 square
                if (board[i][j] != '.' && !isValidSudoku(board, i, j))
                    return false;

        // Return true if all cells are valid
        return true;
    }
    
    // Check if the digit in the given cell is valid in its row, column, and 3x3 square
    private boolean isValidSudoku(char[][] board, int i, int j) {
        // Check row and column for duplicate digits
        for(int k = 0; k < 9; k++)
            if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j]))
                return false;

        // Check 3x3 square for duplicate digits
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int k = row; k < row + 3; k++)
            for(int n = col; n < col + 3; n++)
                if(i != k && n != j && board[i][j] == board[k][n])
                    return false;

        // Return true if digit is valid in its row, column, and 3x3 square
        return true;
    }
}
```
