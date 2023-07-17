<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT LOGO -->
# LeetCode Published Discussions

This .md file contains discussions of many questions from leetcode I've published.

_Read source-code by Programming Languages:_
[_Java_](https://github.com/ladunjexa/leetcode/search?l=java),
[_C#_](https://github.com/ladunjexa/leetcode/search?l=c%23),
[_Python_](https://github.com/ladunjexa/leetcode/search?l=python),
[_JavaScript_](https://github.com/ladunjexa/leetcode/search?l=javascript),
[_TypeScript_](https://github.com/ladunjexa/leetcode/search?l=typescript)

*☝ Note that this project is meant to be used for learning and researching purposes
only, and it is **not** meant to be used for production.*

# :information_source: Contents

### Table of Discussions
* [35. Search Insert Position](#search-insert-position)
* [36. Valid Sudoku](#valid-sudoku)
* [62. Unique Paths](#unique-paths)
* [63. Unique Paths](#unique-paths-ii)
* [74. Search a 2D Matrix](#search-a-2d-matrix)
* [97. Interleaving String](#interleaving-string)
* [118. Pascal's Triangle](#pascals-triangle)
* [119. Pascal's Triangle II](#pascals-triangle-ii)
* [167. Two Sum II - Input Array Is Sorted](#two-sum-ii)
* [171. Excel Sheet Column Number](#excel-sheet-column-number)
* [189. Rotate Array](#rotate-array)
* [202. Happy Number](#happy-number)
* [222. Count Complete Tree Nodes](#count-complete-tree-nodes)
* [235. Lowest Common Ancestor of a Binary Search Tree](#lowest-common-ancestor-of-a-binary-search-tree)
* [278. First Bad Version](#first-bad-version)
* [283. Move Zeroes](#move-zeroes)
* [289. Game of Life](#game-of-life)
* [326. Power of Three](#power-of-three)
* [344. Reverse String](#reverse-string)
* [380. Insert Delete GetRandom O(1)](#insert-delete-getrandom)
* [542. 01 Matrix](#01-matrix)
* [784. Letter Case Permutation](#letter-case-permutation)
* [977. Squares of a Sorted Array](#squares-of-a-sorted-array)
* [1323. Maximum 69 Number](#maximum-69-number)
* [1572. Matrix Diagonal Sum](#matrix-diagonal-sum)
* [1337. The K Weakest Rows in a Matrix](#the-k-weakest-rows-in-a-matrix)
* [1608. Special Array With X Elements Greater Than or Equal X](#special-array-with-x-elements-greater-than-or-equal-x)
* [2660. Determine the Winner of a Bowling Game](#determine-the-winner-of-a-bowling-game)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Search Insert Position
## Intuition & Approach
The given code implements the binary search algorithm to find the index where a `target` value should be inserted into a sorted array of integers.

The function takes two inputs: an integer array `nums`, which is the sorted array of integers, and an integer `target`, which is the value that needs to be inserted into the array. It starts by initializing three variables, `low`, `high`, and `i`, where `low` is set to `0` (*the first index of the array*), `high` is set to `nums.length - 1` (*the last index of the array*), and `i` is set to `-1` (*an initial value to be updated later*).

The while loop runs until `low` is less than or equal to `high`. In each iteration, the value of `i` is updated as the middle index between `low` and `high`, using the formula `(low + (high - low) / 2)`. This is done to **avoid integer overflow**, as using `(low + high) / 2` can cause overflow if the sum of `low` and `high` is greater than the maximum integer value.

The code then checks whether the value at the i<sup>th</sup> index of the array is equal to the target. If it is, the function *returns the index* `i`.

If the value at the i<sup>th</sup> index is less than the target, the code updates the value of `low` to `i + 1`, indicating that the target value should be inserted to the right of the i<sup>th</sup> index.

If the value at the i<sup>th</sup> index is greater than the target, the code updates the value of `high` to `i - 1`, indicating that the target value should be inserted to the left of the i<sup>th</sup> index.

The loop continues until `low` becomes greater than `high`, at which point the function returns the value of `low`, which represents *the index where the target value should be inserted into the sorted array*.

In summary, the function uses the **binary search algorithm** to efficiently find the index where a target value should be inserted into a sorted array by dividing the array in half at each iteration and updating the search range accordingly based on the result of comparing the value at the middle index to the target value.

## Complexity
- Time complexity: $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, i = -1;

        while(low <= high) {
            i = low + ((high - low) / 2);
            if(nums[i] == target)
                return i;
            if(nums[i] < target)
                low = i + 1;
            else
                high = i - 1;
        }

        return low;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Valid Sudoku
## Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->

This function checks if a given 9x9 Sudoku board is valid or not. The function first checks if the input board is valid, which means it is not null and has a length and width of 9. If the board is not valid, it returns false.

If the board is valid, the function iterates through each cell in the board and checks if it contains a digit. If it contains a digit, the function calls the `isValidSudoku` helper function to check if the digit is valid in its row, column, and 3x3 square.

The `isValidSudoku` helper function checks if the digit at the given cell is valid in its row and column by iterating through all the cells in the same row and column and checking if any of them contain the same digit. It also checks if the digit is valid in the 3x3 square by calculating the starting row and column of the 3x3 square and iterating through all the cells in the square and checking if any of them contain the same digit.

If the digit is valid in its row, column, and 3x3 square, the `isValidSudoku` helper function returns true. If the digit is not valid in any of those locations, it returns false.

If the $$isValidSudoku$$ helper function returns false, the main function immediately returns false because the board is not valid. If the function completes the iteration over all the cells and none of them are invalid, it returns true because the board is valid.

## Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `isValidSudoku` function is O(1) because it always checks the same number of cells (i.e., 27 cells) regardless of the size of the input board. The time complexity of the `isValidSudoku` function called within the main function is O(n<sup>2</sup>) where n is the size of the input board. This is because the `isValidSudoku` function iterates over each row, column, and 3x3 square once.

The time complexity of the main function `isValidSudoku` is O(n<sup>2</sup>) because it iterates over each cell in the input board once and calls the `isValidSudoku` helper function once for each cell. Therefore, the total time complexity is O(n<sup>2</sup>).

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the isValidSudoku function is O(1) because it uses a constant amount of space to store variables to check for valid digits. The space complexity of the main function isValidSudoku is also O(1) because it uses only a constant amount of space for its variables. Therefore, the total space complexity is O(1).

## Code
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

## DOC Code
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Unique Paths
## Intuition
The solution utilizes ***dynamic programming*** to solve the problem efficiently. It uses a recursive approach with memoization to avoid redundant calculations. The function `uniquePaths` takes the dimensions of the grid, the current position `(i, j)`, and a memoization table `dp` as parameters.

## Approach
1. Create a 2D array `dp`of size `m x n` to store the number of unique paths for each cell.
2. Initialize all cells in `dp` with a sentinel value, such as `Integer.MIN_VALUE`, to indicate that the value has not been calculated yet.
3. Call the helper function `uniquePaths` with the initial position `(0, 0)` and the memoization table `dp`.
4. Inside the `uniquePaths` function:
    1. Check if the current position is the bottom-right corner (i.e., `i == m - 1 and j == n - 1`). If so, return `1` because there is only one path to reach the destination.
    2. Check if the current position is outside the grid boundaries (i.e., `i >= m or j >= n`). If so, return `0` because it is an invalid path.
    3. Check if the value for the current position exists in `dp`. If so, return the precalculated value.
    4. Recursively calculate the number of unique paths by moving down `(i + 1, j)` and right `(i, j + 1)`.
    5. Store the result in `dp[i][j]` and return the same value.
5. Finally, return the result of `uniquePaths` function with the initial position `(0, 0)`.

## Complexity
- Time complexity: $$O(m * n)$$

The time complexity of the `uniquePaths` function can be determined by considering the number of unique subproblems it solves. The function explores all possible paths from each cell in the grid. Since the function is implemented recursively, it calculates the number of unique paths for each cell by recursively calling itself for the adjacent cells.

Let's assume the grid has dimensions `m x n`.

*In the worst case*, the function needs to calculate the number of unique paths for each cell in the grid. For each cell, it makes two recursive calls to its adjacent cells (down and right). Therefore, the total number of recursive calls made by the function can be approximated as `O(2^(m+n))`. This exponential time complexity arises from the recursive branching factor.

However, the function uses a memoization technique to store the results of previously solved subproblems in the dp array. Before making a recursive call for a cell, it checks if the result is already present in the dp array. If so, it retrieves the result from the array instead of recalculating it. This optimization significantly reduces the number of redundant recursive calls, resulting in a lower effective time complexity.

Considering the memoization, the time complexity of the `uniquePaths` function can be approximated as `O(m * n)`, where `m` and `n` are the dimensions of the grid.

- Space complexity: $$O(m * n)$$

The space complexity of the `uniquePaths` function is determined by the memory consumed by the `dp` array and the recursive call stack.

The dp array has dimensions `m x n`, which corresponds to the size of the grid. Therefore, it requires `O(m * n)` space.

The depth of the recursion is limited by the dimensions of the grid (`m` and `n`). *In the worst case*, the recursion depth can be `m + n - 2` (when starting from the top-left corner). This is because each recursive call moves either down or right, and the goal is to reach the bottom-right corner. Therefore, the space occupied by the recursive call stack can be approximated as `O(m + n)`.

In conclusion, the space complexity of the uniquePaths function is `O(m * n)` due to the dp array, and the time complexity is approximately `O(m * n)` when considering the memoization optimization.

## Code
```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        return uniquePaths(m, n, 0, 0, dp);
    }

    private int uniquePaths(int M, int N, int i, int j, int[][] dp) {
        if(i == M - 1 && j == N - 1)
            return 1;
        
        if(i >= M || j >= N)
            return 0;
        
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        
        int down = uniquePaths(M, N, i + 1, j, dp);
        int right = uniquePaths(M, N, i, j + 1, dp);
        
        return dp[i][j] = (down + right);
    }
}
```

## DOC Code
```java
class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths for each position
        int[][] dp = new int[m][n];
        
        // Initialize all elements in dp with a sentinel value to indicate that they haven't been calculated yet
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        // Call the recursive helper function to calculate the number of unique paths starting from the top-left position (0, 0)
        return uniquePaths(m, n, 0, 0, dp);
    }

    private int uniquePaths(int M, int N, int i, int j, int[][] dp) {
        // If we have reached the bottom-right position (M-1, N-1), we have found a unique path
        if(i == M - 1 && j == N - 1)
            return 1;
        
        // If we have gone out of bounds, we cannot continue and there are no paths from this position
        if(i >= M || j >= N)
            return 0;
        
        // If the number of unique paths for this position has already been calculated, return it
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        
        // Calculate the number of unique paths by recursively moving down and right from the current position
        int down = uniquePaths(M, N, i + 1, j, dp);
        int right = uniquePaths(M, N, i, j + 1, dp);
        
        // Store the calculated result in dp to avoid redundant calculations
        return dp[i][j] = (down + right);
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Unique Paths II
## Intuition & Approach
The `uniquePathsWithObstacles` function uses a **recursive approach with memoization** to solve the problem of finding the number of unique paths in an obstacle grid. The memoization technique is used *to avoid redundant computations and improve the efficiency of the function*.

The main function `uniquePathsWithObstacles` takes the obstacle grid as input and initializes a memoization array `memo` of the same size as the grid. The function then calls the helper function (*method overloading*) `uniquePathsWithObstacles` with the initial parameters `(0, 0)` representing the *starting position of the robot*.

The helper function `uniquePathsWithObstacles` recursively calculates the number of unique paths from the current position `(i, j)` to the bottom-right corner. It checks three base cases:

1. If the current position is out of bounds or contains an obstacle, the path is invalid, so it *returns `0`*.

2. If the current position is at the bottom-right corner, it means a valid path has been found, so it *returns `1`*.

3. If the result for the current position has already been calculated and stored in the memoization array, it directly *returns the stored result*.

If none of the base cases are met, the function calculates the number of unique paths by recursively moving to the right `(i, j + 1)` and down `(i + 1, j)` from the current position and summing up the results. It stores the result in the memoization array for future use and *returns the result*.

The `isOutOfBounds` function is a helper function that checks if a given position `(i, j)` is *outside the bounds of the grid*.

Overall, the solution efficiently solves the problem of finding the number of unique paths in an obstacle grid by using memoization to avoid redundant computations.

## Complexity
- Time complexity: $$O(M x N)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(M x N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The time complexity of `uniquePathsWithObstacles` function depends on the size of the grid, given by `M x N`. Since each position in the grid is computed once and stored in the memoization array, the time complexity can be considered as `O(M x N)`.

The space complexity of the solution is also `O(M x N)` because of the memoization array, which has the same size as the grid. Additionally, the recursion stack will occupy space proportional to the maximum depth of the recursion, which is equal to the sum of `M` and `N` in the worst case. However, since the solution states that the answer will be less than or equal to `2 * 10^9`, the recursion depth will not exceed a large value.

## Code
``` Java []
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        int[][] memo = new int[M][N];

        for(int[] v : memo)
            Arrays.fill(v, Integer.MIN_VALUE);

        return uniquePathsWithObstacles(obstacleGrid, 0, 0, memo);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if(isOutOfBounds(obstacleGrid, i, j) || obstacleGrid[i][j] == 1)
            return 0;
        
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1)
            return 1;
        
        if(memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];
        
        return memo[i][j] = uniquePathsWithObstacles(obstacleGrid, i + 1, j, memo) + uniquePathsWithObstacles(obstacleGrid, i, j + 1, memo);
    }

    private boolean isOutOfBounds(int[][] mat, int i, int j) {
        return i < 0 || i >= mat.length || j < 0 || j >= mat[0].length;
    }
}
```
``` Java []
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Get the dimensions of the grid
        int M = obstacleGrid.length; // Number of rows
        int N = obstacleGrid[0].length; // Number of columns

        // Create a memoization array to store computed results
        int[][] memo = new int[M][N];

        // Initialize the memoization array with a sentinel value
        // indicating that the value has not been computed yet
        for (int[] v : memo) {
            Arrays.fill(v, Integer.MIN_VALUE);
        }

        // Call the recursive function to find the unique paths
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, memo);
    }

    // Recursive function to find the number of unique paths from (i, j) to the bottom-right corner
    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] memo) {
        // If the current position is out of bounds or an obstacle, return 0
        if (isOutOfBounds(obstacleGrid, i, j) || obstacleGrid[i][j] == 1) {
            return 0;
        }

        // If the current position is at the bottom-right corner, return 1
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }

        // If the result for the current position has already been computed, return it
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        // Calculate the number of unique paths by recursively moving right and down from the current position
        int paths = uniquePathsWithObstacles(obstacleGrid, i + 1, j, memo) +
                    uniquePathsWithObstacles(obstacleGrid, i, j + 1, memo);

        // Store the computed result in the memoization array
        memo[i][j] = paths;

        // Return the number of unique paths from the current position
        return paths;
    }

    // Helper function to check if a given position is out of bounds
    private boolean isOutOfBounds(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Search a 2D Matrix
## Intuition & Approach
The `searchMatrix` function takes a `m x n` integer matrix `matrix` that is sorted row-rise and a integer value `target` as input and returns `true` if `target` is in `matrix` or `false` otherwise.

The approach taken by this code is to use a **modified binary search algorithm**. The binary search is applied to two phases in the algorithm:
* Finding the row that potentially contains the target element
* Searching the potential row for the target element

In the first phase, we apply binary search to search for the row in which the `target` value could be found. We start with the middle row and compare the minimum and maximum values in that row with the `target` value. If the `target` is within the range of the minimum and maximum values, then we perform a binary search on that row to find the `target` value. If the `target` is greater than the minimum value of the middle row, then we know that *the `target` value is in the upper half of the matrix*. Similary, if the `target` is less than the minimum value of the middle row, then we know that *the target value is the lower half of the matrix*.

In the second phase, we apply a *standard implementation of the binary search algorithm* on the potential row to search for the target element, which searches for a `target` value in a sorted array by repeatedly *diving the search interval in half*.

The *time complexity* of the algorithm is $$T(log(m) + log(n)) = T(log(m * n)) = O(log(m * n))$$, where `m` and `n` are the number of rows and columns in the matrix respectively. The *space complexity* is $$O(1)$$ since we are using constant extra space for the variable.

## Complexity
- Time complexity: $$O(log(m * n))$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix[0].length, low = 0, high = matrix.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2,
                min = matrix[mid][0], 
                max = matrix[mid][M - 1];

            if(min <= target && target <= max)
                return binarySearch(matrix[mid], 0, M - 1, target);
            else if(min < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }

    private boolean binarySearch(int[] row, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(row[mid] == target)
                return true;
            else if(row[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Interleaving String
## Intuition & Approach
> `isInterleave` method aims to determine whether a string `s3` can be formed by interleaving characters from strings `s1` and `s2` while preserving the relative order of characters from both strings.

The `isInterleave` function is the main entry point, which initializes the lengths of `s1`, `s2`, and `s3` as `M`, `N`, and `K`, respectively. If the sum of the lengths of `s1` and `s2` is not equal to the length of `s3`, it immediately returns `false`.

Otherwise, it calls the private isInterleave helper function with additional parameters: `s1`, `s2`, `s3`, current indices `i` and `j`, and a memoization array `memo`.

The isInterleave helper function checks whether characters from `s1` and `s2` can be interleaved to form `s3` starting from indices `i` and `j`, respectively. It uses memoization to avoid redundant computations.

The function first checks if the sum of indices `i` and `j` is equal to the length of `s3`. If it is, that means all the characters of `s3` have been formed successfully, so it returns `true`.

Next, it checks if the memoization array already contains a value for the current indices `i` and `j`. If it does, it directly returns the memoized value.

If the above conditions are not met, the function retrieves the character ch from `s3` at the current indices `i` and `j`. It then recursively checks two possibilities:

1. If i is within the bounds of `s1`, the character at index i in `s1` matches ch, and the remaining characters in `s1` can be interleaved to form the remaining characters of `s3`. This is checked by calling isInterleave with incremented `i` and the same `j`. If this condition is satisfied, the function sets the corresponding flag to `true`.

2. If `j` is within the bounds of `s2`, the character at index `j` in `s2` matches `ch`, and the remaining characters in `s2` can be interleaved to form the remaining characters of `s3`. This is checked by calling isInterleave with the same `i` and incremented `j`. If this condition is satisfied, the function sets the corresponding flag to `true`.

Finally, the function assigns the *logical OR* of both `flags` to the current memoization entry `memo[i][j]` and returns it.

## Complexity
- Time complexity: $$O(M * N)$$

The **time complexity** of this solution is `O(M * N)`, where `M` is the length of string `s1` and `N` is the length of string `s2`. This is because each combination of `i` and `j` is visited once, and there are `M * N` possible combinations.

- Space complexity: $$O(M * N)$$

The **space complexity** is `O(M * N)` as well. This is due to the memoization array `memo`, which has dimensions `(M + 1) x (N + 1)` to account for the possible values of `i` and `j`.

## Code
```java
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int M = s1.length(), N = s2.length(), K = s3.length();

        if(N + M != K)
            return false;
        
        return isInterleave(s1, s2, s3, 0, 0, new Boolean[M + 1][N + 1]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if(i + j == s3.length())
            return true;
        
        if(memo[i][j] != null)
            return memo[i][j];

        char ch = s3.charAt(i + j);
        
        boolean[] flags = {
            i < s1.length() && s1.charAt(i) == ch && isInterleave(s1, s2, s3, i + 1, j, memo), 
            j < s2.length() && s2.charAt(j) == ch && isInterleave(s1, s2, s3, i, j + 1, memo)
        };
        
        return memo[i][j] = (flags[0] || flags[1]);
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Pascals Triangle
## Intuition & Approach
The problem of the `generate` function is to to generate the first `numRows` of Pascal's triangle and return *it as a list of lists of integers*.

**Pascal's triangle** is a triangular array of numbers in which the first and last elements of each row are `1`, and each of the other elements is the sum of the two elements directly above it.

To solve this problem, we can use two lists: `current` and `previous`. We start by adding the first row, which is simply the number 1. Then, we iterate from the second row to the `numRows-th` row, adding the first and last elements of each row as `1` and calculating the other elements as the sum of the corresponding elements in the `previous` row. We use the `previous` list to access the elements of the previous row and the `current` list to store the elements of the current row. we add each `current` list to the `pascalTriangle` list as we calculate it.

After calculating each row, we set `previous` equal to `current` and create a new empty `current` list to calculate the next row. Finally, we return *the pascalTriangle list containing all the rows of Pascal's triangle*.

This approach uses **dynamic programming** to store the values of the previous row and avoid unnecessary calculations.

## Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n^2)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The time complexity of this algorithm is $$O(n^2)$$, as we need to calculate each element of each row, and the space complexity is $$O(n^2)$$, as we need to store all the elements of Pascal's triangle, because, number of elements in **i<sup>th</sup>** row is `(i + 1)`, if so, to ***find the number of elements in Pascal's triangle of n rows***, we can sum of the first n natural numbers using the formula: $$n\frac{(n+1)}{2}$$. hence, space complexity is: 
$$n\frac{(n+1)}{2}=\frac{(n^2+n)}{2}=S(\frac{n^2}{2}+\frac{n}{2})=S(\frac{n^2}{2})=O(n^2)$$

## Code
``` java []
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        List<Integer> current = new ArrayList<>(), previous = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++)
                if(i != 0 && j > 0 && j < i)
                    current.add(previous.get(j - 1) + previous.get(j));
                else
                    current.add(1);
            
            pascalTriangle.add(current);
            previous = current;
            current = new ArrayList<>();
        }
        
        return pascalTriangle;
    }
}
```
## DOC Java
``` java []
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Initialize the list of lists that will hold the Pascal's triangle
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Initialize the current and previous rows as empty lists
        List<Integer> current = new ArrayList<>(), previous = new ArrayList<>();

        // Loop through each row of the Pascal's triangle
        for(int i = 0; i < numRows; i++) {
            // Loop through each element of the current row
            for(int j = 0; j <= i; j++) {
                // If the element is not in the first or last column of the row,
                // add the sum of the two elements directly above it to the current row
                if(i != 0 && j > 0 && j < i) {
                    current.add(previous.get(j - 1) + previous.get(j));
                } 
                // Otherwise, add 1 to the current row
                else {
                    current.add(1);
                }
            }
            // Add the current row to the Pascal's triangle
            pascalTriangle.add(current);
            // Set the previous row to be the current row for the next iteration
            previous = current;
            // Clear the current row for the next iteration
            current = new ArrayList<>();
        }
        
        // Return the completed Pascal's triangle
        return pascalTriangle;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Pascals Triangle II
## Intuition & Approach
The `getRow` function takes an integer `rowIndex` as input and returns *the `rowIndex`th row of Pascal's triangle as a list of integers*.

To generate the row, the function iterates over each element in the row, starting from the first element (index 0) up to the `rowIndex`th element. For each element in the row, the function calculates the binomial coefficient `C(rowIndex, k)`, where `k` is the index of the current element.

The binomial coefficient `C(rowIndex, k)` is computed using the formula: 
$$C(n, k) = \frac{n!}{k! * (n - k)!}$$ where `n` is the `rowIndex` and `k` is the *index of the current element in the row*.

To compute `C(rowIndex, k)`, the function initializes a variable `coeff` to `1` and iterates over all values of `j` from 1 to `k`. For each value of j, it multiplies `coeff` by the expression `(rowIndex - k + j) / j` and rounds the result to the nearest integer using `Math.round`.

After computing the binomial coefficient for the current element, the function adds it to a list representing the current row of Pascal's triangle. Once all elements in the row have been computed, the function returns the list representing the row.

This implementation uses **double-precision floating-point arithmetic** to compute the binomial coefficients and then rounds the result to the nearest integer to ensure accuracy.

In terms of optimization, we can note that we are computing the binomial coefficient using multiplication and division. For larger values of `rowIndex`, this computation can become computationally expensive. However, we can optimize this by using the fact that `C(n, k) = C(n, k-1) * (n-k+1) / k`. This allows us to compute each binomial coefficient in `O(1)` time by using the previously computed value, which reduces the time complexity to `O(rowIndex)` - *optimized code below*.

## Complexity
- Time complexity: $$O(n^2)$$ and optimized version is $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$ for both versions
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int k = 0; k <= rowIndex; k++) {
            int coeff = 1;
            // Calculate C(rowIndex, k)
            for(int j = 1; j <= k; j++)
                coeff = (int) Math.round((double) coeff * (rowIndex - k + j) / j);
            
            row.add(coeff);
        }

        return row;
    }
}
```
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long coeff = 1;

        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) coeff);
            coeff = coeff * (rowIndex - k) / (k + 1);
        }

        return row;
    }
}
```
## DOC Java
The **naive solution** implementation uses a nested loop to calculate the binomial coefficients for each index in the row. The outer loop iterates over the row indices, while the inner loop calculates each coefficient using the formula $$C(rowIndex, k) = (rowIndex choose k) = (rowIndex! / (k! * (rowIndex - k)!))$$. The calculation is performed using a variant of the formula that avoids computing large factorials, as described in the earlier.

The coefficients are added to the row list, which is then returned as the final output of the function.
``` java []
public List<Integer> getRow(int rowIndex) {
    // Create a new list to store the row
    List<Integer> row = new ArrayList<>();

    // Iterate over the row and calculate each coefficient
    for (int k = 0; k <= rowIndex; k++) {
        // Set the initial value of the coefficient to 1
        int coeff = 1;

        // Calculate the binomial coefficient C(rowIndex, k)
        for (int j = 1; j <= k; j++) {
            // Multiply the coefficient by (rowIndex - k + j) / j
            // Note: we use Math.round to handle floating-point errors
            coeff = (int) Math.round((double) coeff * (rowIndex - k + j) / j);
        }
        
        // Add the coefficient to the row
        row.add(coeff);
    }

    // Return the completed row
    return row;
}
```
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long coeff = 1; // Initialize coefficient to 1

        for (int k = 0; k <= rowIndex; k++) { // Iterate from 0 to rowIndex
            row.add((int) coeff); // Add coefficient to the current row
            coeff = coeff * (rowIndex - k) / (k + 1); // Calculate next coefficient
        }

        return row; // Return the row
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Two Sum II
## Intuition & Approach
The purpose of the `twoSum` function is to find the indices of two numbers in the given `numbers` array whose **sum equals the given `target` value**. It uses the *two-pointer technique* to efficiently search for the required numbers.

The *two-pointer technique* involves initializing two pointers, `low` and `high`, to the beginning and end of the array, respectively. Then, at each step of the loop, the sum of the numbers at the `low` and `high` indices is calculated and compared to the `target` value. If the sum is **less than** the `target`, the `low` pointer is **incremented** to search for a larger number. If the sum is **greater than** the `target`, the `high` pointer is **decremented** to search for a smaller number. If the sum is equal to the `target`, the indices of the two numbers are returned as an array.

Finally, the function returns an array containing the indices of the two numbers whose sum equals the `target`. The two indices are stored in a new array with the `low` and `high` pointers incremented by 1, since the problem specifies that the indices should be **1-indexed** instead of 0-indexed.


## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1, sum = -1;

        while(low <= high) {
            sum = numbers[low] + numbers[high];
            if(sum < target)
                low++;
            else if(sum > target)
                high--;
            else
                break;
        }

        return new int[]{ low + 1, high + 1 };
    }
}
```

## DOC Code
``` java []
public int[] twoSum(int[] numbers, int target) {

    // Initialize the low pointer to the beginning of the array and the high pointer to the end of the array.
    int low = 0, high = numbers.length - 1;

    // Initialize the sum to -1, this will be used to store the sum of the numbers at low and high pointers.
    int sum = -1;

    // Use the two-pointer technique to search for the required numbers.
    while(low <= high) {

        // Calculate the sum of the numbers at the low and high indices.
        sum = numbers[low] + numbers[high];

        // If the sum is less than the target value, move the low pointer to the next index.
        if(sum < target)
            low++;

        // If the sum is greater than the target value, move the high pointer to the previous index.
        else if(sum > target)
            high--;

        // If the sum is equal to the target value, we have found the required numbers.
        else
            break;
    }

    // Return an array of indices of the two numbers whose sum equals the target value.
    return new int[]{ low + 1, high + 1 };
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Excel Sheet Column Number
## Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->

This code is a method named `titleToNumber` that takes a string `columnTitle` as input and returns an integer.

The purpose of this method is to convert an *Excel column title* (e.g., "A", "B", "C", ..., "Z", "AA", "AB", "AC", ..., "ZZ", "AAA", ...) into its *corresponding numeric value*.

**Here's a step-by-step explanation of how the code works:**

1. It first checks the length of the columnTitle string (`N`). If the length is `0` or if the columnTitle is null, it *returns `0`, indicating an invalid input*.

2. It initializes an integer variable `out` to `0`. This variable will store *the final numeric value of the column title*.

3. The code then enters a loop that iterates over each character of the `columnTitle` string.

4. Within the loop, it retrieves the character at the current position (`i`) using the `charAt()` method and converts it to uppercase using `Character.toUpperCase()`. This ensures that both lowercase and uppercase letters can be handled.

5. The code then performs a series of calculations to convert the character into its corresponding numeric value. It multiplies the current value of `out` by `26` (*since there are 26 letters in the English alphabet*), and then adds the difference between the ASCII value of the character and the ASCII value of 'A' plus 1. The expression `c - 'A' + 1` calculates the numeric value of the character, where 'A' represents 1, 'B' represents 2, and so on.

6. After the loop has iterated over all characters in the `columnTitle` string, the final numeric value is stored in the out variable.

7. Finally, the method returns the value of `out`, which represents *the converted numeric value of the column title*.

**Character to Numeric Value Conversion Explanation**

The expression `c - 'A' + 1` is used to calculate the numeric value of the variable `c` of type `char` relative to the letter 'A'.

In ASCII representation, the character 'A' has a decimal value of 65. By subtracting the ASCII value of 'A' from the ASCII value of `c`, you obtain the offset or the distance between the character `c` and 'A'.

For example, if `c` is 'B', the ASCII value of 'B' is 66. By subtracting the ASCII value of 'A' (65) from the ASCII value of 'B' (66), you get 1. This result represents the distance between 'B' and 'A' in the alphabet.

However, in this case, we want the mapping to be 'A' = 1, 'B' = 2, 'C' = 3, and so on. That's why we add 1 to the offset. So, when `c` is 'B', the offset is 1, and adding 1 gives us the desired numeric value of 2 for 'B'.

In summary, the expression `c - 'A' + 1` adjusts the ASCII-based offset of the character `c` relative to 'A' to obtain the corresponding numeric value in the range of 1 to 26, where 'A' represents 1, 'B' represents 2, and so on.

## Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

## Code
``` java []
class Solution {
    public int titleToNumber(String columnTitle) {
        int N = columnTitle.length(), out = 0;
        if(N == 0 || columnTitle == null)
            return out;
        
        for(int i = 0; i < N; i++) {
            char c = Character.toUpperCase(columnTitle.charAt(i));
            out *= 26;
            out += c - 'A' + 1;
        }
        return out;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Rotate Array
## Intuition & Approach
This code is a Java implementation of an algorithm that rotates the elements of an integer array `nums` to the right by `k` positions. The purpose of this code is to modify the input array in place, without using any additional memory, to achieve the desired rotation.

The approach used in this code is based on the idea of reversing portions of the input array. Specifically, the code divides the input array into three parts: the first `len - k` elements, the next `k` elements, and the remaining elements. It then reverses each of these three parts using the reverse helper method.

The `reverse` method takes an array `nums` and two indices `i` and `j`, and reverses the subarray `nums[i:j]` in place. It does this using a *bitwise XOR swap*, which swaps two elements of an array without using additional memory.

The **bitwise XOR swap algorithm** works by exploiting the properties of the XOR operator to swap two values without needing a temporary variable.

To understand how the rotation works, consider the example input $$[1, 2, 3, 4, 5]$$ and $$k=2$$. First, the code calculates `len=5` and `k=2%5=2`. Then, it *reverses the first* `len-k=3` elements of the array, resulting in $$[3, 2, 1, 4, 5]$$. Next, it *reverses the next* `k=2` elements of the array, resulting in $$[3, 2, 5, 4, 1]$$. Finally, it *reverses the entire array*, resulting in $$[1, 4, 5, 2, 3]$$, which is *the original array rotated to the right by `k` positions.*

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Overall, this algorithm has a time complexity of O(n), where n is the length of the input array, and a space complexity of O(1), since it modifies the input array in place without using any additional memory.

## Code
``` java []
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length, startIndex = 0, endIndex = (len - 1);
        k %= len;

        reverse(nums, startIndex, endIndex - k);
        reverse(nums, len - k, endIndex);
        reverse(nums, startIndex, endIndex);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}
```
## DOC Code
``` java []
class Solution {
    public void rotate(int[] nums, int k) {
        // Get the length of the input array and the starting and ending indices of the array
        int len = nums.length, startIndex = 0, endIndex = (len - 1);

        // Reduce the rotation amount by the length of the array to handle cases where k is larger than len
        k %= len;

        // Reverse the first len - k elements of the array
        reverse(nums, startIndex, endIndex - k);

        // Reverse the next k elements of the array
        reverse(nums, len - k, endIndex);

        // Reverse the entire array to get the final rotated array
        reverse(nums, startIndex, endIndex);
    }

    // Reverse the subarray nums[i:j] in place using a bitwise XOR swap
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Happy Number
## Intuition & Approach
The given code is an implementation of the `Happy Number` problem in Java.

A happy number is a number that eventually reaches 1 when replaced by the sum of the square of each digit in the number, and this process is repeated with the resulting sum until the number either equals 1 or the process loops endlessly in a cycle that does not include 1.

The approach used in this code is to repeatedly square the digits of the given number, until either 1 is reached or the process loops endlessly in a cycle.

If the given number is less than 10, the code checks if it's either 1 or 7, as any number less than 10 can only be a happy number if it's either 1 or 7.

If the given number is not less than 10, the code starts by initializing a variable `op` to zero, and then repeatedly squares each digit of the number (by using modulo operator and integer division) and adds it to the variable `op` until there are no digits left (i.e., until n becomes zero).

The resulting sum, `op`, is then recursively passed back to the isHappy() function to repeat the process until either 1 is reached or the process loops endlessly in a cycle.

## Complexity
- Time complexity: $$O(k*logn)$$ where `k` is the number of recursive calls made by the function.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(k)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```java []
class Solution {

    public boolean isHappy(int n) {
        if(n < 10)
            return (n == 1 || n == 7);
        
        int op = 0;

        do {
            op += (n % 10) * (n % 10);
            n /= 10;
        } while(n != 0);

        return isHappy(op);
    }
}
```

## DOC Code
``` java []
// Defines a public method called "isHappy" that takes an integer parameter "n" and returns a boolean value.
public boolean isHappy(int n) {    

    // Checks if the input number is less than 10.
    if(n < 10)                    
        return (n == 1 || n == 7); // Returns true if the input number is equal to 1 or 7, and false otherwise.
    
    // Initializes a new integer variable "op" with the value 0.
    int op = 0;                   

    do {                          
    // Enters a do-while loop that executes at least once.
        op += (n % 10) * (n % 10);
        // Computes the square of the last digit of the input number and adds it to "op".
        n /= 10;                  
        // Removes the last digit of the input number by dividing it by 10.
    } while(n != 0);              
    // Continues looping until all digits of the input number have been processed.

    // Recursively calls the "isHappy" method with the new value of "op".
    return isHappy(op);           
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# First Bad Version
## Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->
The given code implements the binary search algorithm to find the first bad version in a given range of versions.

The function takes an integer `n` as input which represents the total number of versions available. It starts by initializing two variables, `low` and `mid`, where `low` is set to 1 (the first version) and `mid` is set to -1 (an initial value to be updated later).

The while loop runs until `low` is less than or equal to `n`. In each iteration, the value of `mid` is updated as the middle version between `low` and `n`, using the formula `(low + (n - low) / 2)`. This is done to **avoid integer overflow**, as using `(low + n) / 2` can cause overflow if the sum of `low` and `n` is greater than the maximum integer value.

The `isBadVersion()` function is called on the `mid` version. If it returns true, then the function updates `n` to `mid - 1`, indicating that the first bad version is on the left side of the `mid` version. If `isBadVersion()` returns false, then the function updates low to `mid + 1`, indicating that the first bad version is on the right side of the `mid` version.

The loop continues until `low` becomes greater than `n`, at which point the function returns `low`, which represents *the index of the first bad version*.

In summary, the function uses the **binary search algorithm** to efficiently *find the first bad version* in a given range by dividing the range in half at each iteration and updating the search range accordingly based on the result of calling the `isBadVersion()` function.

# Complexity
- Time complexity: $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, mid = -1;
        while(low <= n) {
            mid = low + ((n - low) / 2);
            if(isBadVersion(mid))
                n = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
```
## DOC Java
``` java []
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Initialize the lower bound of the search range to the first version
        int low = 1, 
        // Initialize the middle version to -1 (an initial value to be updated later)
            mid = -1;
        // Loop until the lower bound is less than or equal to the upper bound
        while(low <= n) {
            // Calculate the middle version between the lower and upper bounds, avoiding integer overflow
            mid = low + ((n - low) / 2);
            // Check if the middle version is a bad version, if true update the upper bound to search for the first bad version on the left side of mid
            if(isBadVersion(mid))
                n = mid - 1;
            // If the middle version is not a bad version, update the lower bound to search for the first bad version on the right side of mid
            else
                low = mid + 1;
        }
        // Return the index of the first bad version, which is equal to the lower bound
        return low;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Count Complete Tree Nodes
## Intuition & Approach
`countNodes` method checks whether the current node is null or not. If it is null, it returns `0` because there are no nodes to count. Otherwise, it recursively counts the nodes in the left subtree and right subtree and adds 1 to account for the current node.
<!-- Describe your first thoughts on how to solve this problem. -->

##### Main Concepts
**Recursion:** The code uses a recursive approach to count the nodes in the binary tree. It breaks down the problem into smaller subproblems by recursively calling the countNodes function on the left and right subtrees.

**Binary Tree Traversal:** The code traverses the binary tree in a depth-first manner, visiting each node once.

## Complexity
- Time complexity: $$O(n)$$

The *time complexity* of this algorithm is `O(n)`, where `n` is the number of nodes in the binary tree. This is because the code **visits each node exactly once**, performing a constant amount of work at each node.

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The *space complexity* is determined by the recursive calls. In the worst case, when the tree is skewed and has a height of `n`, the space complexity becomes `O(n)` due to the recursion stack. This is because the recursive calls will be made for each node in the longest path from the root to a leaf. In the best case, when the tree is perfectly balanced, the space complexity is `O(log n)`, where `n` is the number of nodes.

## Code
``` Java []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        return (root == null) ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```
``` java []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root = null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Lowest Common Ancestor of a Binary Search Tree
## Intuition & Approach
This code is an implementation of the ***Lowest Common Ancestor of a Binary Search Tree*** problem. It find the lowest common ancestor of two nodes, `p`, and `q`, in a binary search tree (BST). The lowest common ancestor is *the deepest node in the tree that is an ancestor of both `p` and  `q`*.

**Here's step-by-step explanations of the code:**

1. The code begins by checking if the `root` node or either `p` or `q` is null. If any of them is `null`, it means we have *reached the end of a branch* or *one of the nodes is not present in the tree*, so we return the `root` itself. This is the base case for the recursive traversal of binary search tree.

2. Next, the code checks if both `p` and `q` are greater than the value of the `root` node. If so, it means *both nodes are located in the right subtree of the current `root`*. In this case, we recursively call the `lowestCommonAncestor` function, passing the right child of the `root` as the new `root`, `p`, and `q` as a parameters. This effectively moves the search to the right subtree.

3. Similary, if both `p` and `q` are smaller than the value of the `root` node. If so, it means *both nodes are located in the left subtree of the current `root`*. In this case, we recursively calls the `lowestCommonAncestor` function, passing the left child of the `root` as the new `root`, `p`, and `q` as a parameters. This effectively moves the search to the left subtree.

4. If neither of the above conditions is `true`, it means that `p` and `q` are located in different subtrees of the current `root`, or one of them is equal to the `root` node itself. In either case, the current `root` is the lowest common ancestor, so we return `root`.

The code utilizes the properties of a BST, *where all nodes in the left subtree are less than the root, and all nodes in the right subtree are greater than root*. By recursively traversing the BST and narrowing down the search based on the values of `p` and `q` relative to the current `root`, the code effectively finds and returns the lowest common ancestor of the two nodes.

The code follows the principles of recursion and leverages the BST structure to optimize the search process.

## Complexity
- Time complexity (BCS): $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity (BCS): $$O(logn)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The space and time complexity of the `lowestCommonAncestor` is $$O(logn)$$ on average and $$O(n)$$ in the worst case, where `n` is the number of nodes in the binary search tree.

*In the best case scenario*, when the tree is perfectly balanaced, each recursive call of `lowestCommonAncestor` reduces the search space by half, similar to a binary search and due to the recursive calls, the space required for the recursive call stack grows with the height of the BST.

*In the worst case scenario*, when the tree is skewed and resembles a linked list, each recursive call traverses the entire height of the tree, resulting in `n` recursive calls. Therefore, the time and soace complexity becomes O(n) as the height of the tree can be equal to the number of nodes in the tree.

## Code
``` java []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null | q == null)
            return root;
        
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        return root;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Move Zeroes
## Intuition & Approach
This code implements *Two Pointers technique* to solve the *"**move zeroes**"* problem, which requires moving all the zeros in an array to the end of the array, while keeping the order of non-zero elements unchanged. Here are the line-by-line explanations:

- `int dest = 0, i = 0, swap = Integer.MIN_VALUE;`: Initialize three variables - `dest` represents the index of *the first available position to put a non-zero number*, `i` represents the *current index*, and `swap` is a *placeholder variable for swapping elements*.

- `do { ... } while(++i < nums.length);`: Loop through the array until the end is reached. The loop continues as long as the `i` index is less than the length of the input array.

- `if(nums[i] == 0) continue;`: If the current element at index `i` is zero, **skip** to the next iteration of the loop.

- `swap = nums[dest]; nums[dest++] = nums[i]; nums[i] = swap;`: If the current element is not zero, **swap** it with the element at the `dest` index, which represents the first available position to put a non-zero number. Then, increment `dest` by one, so that the next non-zero element will be placed in the next available position. Finally, assign the previous value of `nums[dest]` in the current element.

The end result is that all non-zero elements are moved to the beginning of the array, in the original order, and all zeros are moved to the end of the array.

## Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

## Code
``` java []
class Solution {
    public void moveZeroes(int[] nums) {
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        do {
            if(nums[i] == 0) continue;
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;
        } while(++i < nums.length);

    }
}
```
## DOC Java
``` java[]
class Solution {
    public void moveZeroes(int[] nums) {
        // initialize variables for tracking destination index of the first available position to put a non-zero number, current index, and a placeholder value for swaping.
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        // iterate through the array
        do {
            if(nums[i] == 0) continue; // if the current element is 0, skip to the next iteration

            // swap the current element with the element at the destination index
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;

        } while(++i < nums.length); // continue the loop while the current index is less than the length of the array
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Game of Life
## Intuition & Approach
###### $$Runtime:$$ *100% (0 ms)*, $$Memory:$$ *94.98% (40.6 MB)*, $$T/C:$$ *O(M * N)*

The given code implements the ***Game of Life*** algorithm. 
> *The Game of Life is a cellular automaton devised by the mathematician John Conway. It consists of a grid of cells, where each cell can be either alive (represented by 1) or dead (represented by 0). The state of each cell in the grid evolves over time based on a set of rules*.

**The algorithm works as follows:**

1. The `gameOfLife` method takes a 2D array representing the initial state of the game and modifies it to the next state.

2. It initializes variables `M` and `N` to store the dimensions of the `board`, and `x` to keep track of the row index in the source array.

3. It creates a new 2D array called `source` and copies the initial state of the game into it using the clone method. This serves as a source of truth for the current state of the game while updating the `board`.

4. It iterates over each cell in the `board` using a single loop and applies the `applyRules` method on each cell.

5. The `applyRules` method takes the `grid = board`, `source`, and the current indices `i` and `j` as parameters.

6. It counts the number of live neighbors around the current cell by calling the `countLiveNeighbors` method.

7. If the current cell is alive `(grid[i][j] == 1)` and has exactly 2 or 3 live neighbors, it *remains alive in the next state*. Otherwise, it *dies* `(grid[i][j] = 0)`.

8. If the current cell is dead `(grid[i][j] == 0)` and has exactly 3 live neighbors, it *becomes alive in the next state*. Otherwise, it *remains dead*.

9. The `countLiveNeighbors` method recursively counts the number of live neighbors around the given cell.

10. It checks the boundary conditions and returns `0` if the cell is outside the grid.

11. If `skip` is `true`, it counts the number of live neighbors by recursively calling `countLiveNeighbors` on each adjacent cell using the `dx` and `dy` arrays. The `skip` parameter is used to *avoid counting the center cell as a neighbor of itself*.

12. The final `count` of live neighbors is returned.

## Complexity
- Time complexity: $$O(M * N)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(M * N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Let `M` be the number of rows and `N` be the number of columns in the grid.
The `gameOfLife` method iterates over all `M * N` cells, resulting in a time complexity of `O(M * N)`.
The `applyRules` method and `countLiveNeighbors` method both have a constant time complexity since they perform a fixed number of opreations.
The space complexity of the algorithm is `O(M * N)` because it craetes a new 2D array (`source`) of the same size as the input grid.

## Code
``` java []
class Solution {
    private final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public void gameOfLife(int[][] board) {
        int M = board.length, N = board[0].length, x = 0;
        int[][] source = new int[M][N];

        for (int[] v : board)
            source[x++] = v.clone();
        
        for(int i = 0; i < M * N; applyRules(board, source, i / N, i++ % N));
    }

    private void applyRules(int[][] grid, int[][] source, int i, int j) {
        int neighbors = countLiveNeighbors(source, i, j, true);

        if(neighbors == 3)
            grid[i][j] = 1;
        else if(neighbors != 2)
            grid[i][j] = 0;
    }

    private int countLiveNeighbors(int[][] grid, int i, int j, boolean skip) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        
        if(!skip)
            return grid[i][j] == 1 ? 1 : 0;
        
        int count = 0;
        for (int k = 0; k < dx.length; count += countLiveNeighbors(grid, i + dx[k], j + dy[k++], false));
        
        return count;
    }
}
```
``` java []
    // potentially more efficient
    private int countLiveNeighbors(int[][] grid, int i, int j) {
        int count = 0;

        for(int k = 0; k < dx.length; k++) {
            int r = i + dx[k];
            int c = j + dy[k];
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                continue;
            
            count += grid[r][c];
        }

        return count;
    }
}
````

**The code is designed to be beginner-friendly, and it can be further optimized for efficiency by considering the following optimizations:**

- Use an in-place update strategy: Rather than updating the cells directly in the grid array while iterating over them, you can use a marking strategy. Mark the cells that need to be updated with a specific value to represent a transitioning from dead to alive and vice versa. After marking all the cells, perform a second pass to apply the updates based on the marked values. This reduces the possibility of overwriting values prematurely during the iteration. this strategy requires a bit of additional logic that expresses the previous value of the cell. This strategy eliminates the need for extra memory allocation and the overhead of copying the entire data, and simply avoid creating a separate `source` array for cloning the original state.

- Optimize neighbor counting: The current implementation uses recursion to count live neighbors, which can be computationally expensive. You can optmize this process by counting live neighbors iteratively. Instead of recursively traversing all eight neighboring cells, you can directly check the eight adjacent cells and count the live ones. This avoids unnecessary function calls and improves performance

- You can going the extra mile and specify the amount of iterations that are performed in the `countLiveNeighbors` method according to the coordinates. for example, in any `M * N` matrix - first we find the maximal `K` (represent the maximum possible number of neighboors, easily can result by manipulating the middlemost cell considering the parity of the number of rows and columns, for example if `N` and `M` are odd so the middlemost is `(M / 2, N / 2)`), and then we will make an adjustment according to the cell coordinates. (for ex., for each cell in a frame, there will be at most `(K / 2) + 1` neighbors). In general, the maximum value for `K` for any matrix is 8, and the minimum value is 3 so there is no effect in terms of complexity analysis (we typically ignore constant factors because they do not affect the overall growth rate of the algorithm as the input size increases, `T(N*M*K)=O(N*M) where K is constant`).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Power of Three
## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The code divides the problem of determining if `n` is a power of three into smaller sub-problems by recursively multiplying 3 to itself and comparing the intermediate results with `n`. This approach ensures that the code executes in logarithmic time complexity and solves the problem efficiently.

## Approach
<!-- Describe your approach to solving the problem. -->
The code uses a recursive approach to solve the problem. The method `isPowerOfThree` takes two arguments - `n` and `k`. `n` is the original number passed as an argument to the first method, and `k` is the intermediate result obtained by multiplying 3 to itself repeatedly.

Initially, the first method checks if the given number `n` is less than 3. If `n` is less than 3, it directly returns `true` if `n` equals 1 (as 3^0=1), else it returns `false`.

If `n` is greater than or equal to 3, the control is passed to the second method `isPowerOfThree`, where `n` and `k` are passed as arguments.

In each recursive call, the method multiplies `k` by 3 until `k` becomes equal to or greater than `n`. If `k` becomes equal to `n`, then it returns `true`, as `n` can be represented as a power of 3. If `k` exceeds `n`, then it returns `false`, as `n` cannot be represented as a power of 3.

## Complexity
- Time complexity: $$O(log₃n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of this function is O(log<sub>3</sub>n), where `n` is the given integer. This is because the function uses a recursive approach, in which the value of `k` is multiplied by 3 in each recursive call until `k` becomes equal to or greater than `n`. Since the function recursively divides the problem into smaller sub-problems, the time complexity can be expressed as the logarithm of the input size to the base 3.

- Space complexity: $$O(log₃n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of this function is also O(log<sub>3</sub>n), which is equivalent to the time complexity. This is because the function uses a recursive approach, and each recursive call requires additional memory on the call stack to store the function`s arguments and return address. As the recursion depth is proportional to the logarithm of the input size, the space complexity is also logarithmic in the input size.

In summary, the given function has a time complexity of O(log<sub>3</sub>n) and a space complexity of O(log<sub>3</sub>n), where `n` is the given integer.

## Code
```java []
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        return isPowerOfThree((long)n, 1);
    }

    public boolean isPowerOfThree(long n, long k) {
        if(k >= n)
            return (k == n);
        
        return isPowerOfThree(n, k * 3);
    }
}
```
```java []
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        return isPowerOfThree((long)n, 1);
    }

    public boolean isPowerOfThree(long n, long k) {
        if(k == n)
            return true;

        else if(k > n)
            return false;
        
        return isPowerOfThree(n, k * 3);
    }
}
```


## DOC Code
``` java []
// Checks if the given integer is a power of three.
class Solution {
    // If n is less than 3, check if it is equal to 1. 
    // If yes, then it is a power of 3, else not.
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        // Otherwise, call the overloaded function with long integers.
        return isPowerOfThree((long)n, 1);
    }

    // Overloaded function to handle long integers.
    // Recursively checks if k^3 is equal to n or greater than n, if not, calls itself with k^3 and n.
    public boolean isPowerOfThree(long n, long k) {
        if(k == n)
            return true;

        else if(k > n)
            return false;

        return isPowerOfThree(n, k * 3);
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Reverse String
## Intuition & Approach

This code snippet implements a function called ***reverseString*** which takes a char array `s` as input, and reverses it in place. The function uses a two-pointer approach to reverse the string efficiently.

The function starts by initializing a variable `k` to the index of the last character in the input array. It then uses a for loop to iterate over the first half of the array (up to but not including the middle character).

For each iteration of the loop, the function checks if the character at the current index `i` is different from the character at the corresponding index `k-i` (i.e., the character on the opposite end of the string). If these characters are different, the `swap` method is called to swap the two characters.

The ***swap*** method simply exchanges the values of two elements in the array, given their indices.

This process continues until the loop reaches the middle of the array, at which point the entire string has been reversed in place.

## Complexity
- Time complexity: $$O(n)$$, for accuracy: $$O(\frac{n}{2})$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public void reverseString(char[] s) {
        int k = s.length - 1;
        for(int i = 0; i < ((k + 1) / 2); i++)
            if(s[i] != s[k - i]) 
                swap(s, i, k - i);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
```
## DOC Java
``` java []
// The function takes a char array 's' and reverses it in place
public void reverseString(char[] s) {
    // Initialize variable 'k' to the index of the last character in the input array
    int k = s.length - 1;
    // Loop through the first half of the array (up to but not including the middle character)
    for(int i = 0; i < ((k + 1) / 2); i++)
        // If the character at index 'i' is different from the character at the corresponding index 'k-i'
        // in order to avoid unnecessary swaps
        if(s[i] != s[k - i]) 
            // Swap the characters at indices 'i' and 'k-i'
            swap(s, i, k - i);
}

// Helper function to swap two elements in a char array given their indices
private void swap(char[] c, int i, int j) {
    // Store the value of the element at index 'i' in a temporary variable
    char temp = c[i];
    // Assign the value of the element at index 'j' to the element at index 'i'
    c[i] = c[j];
    // Assign the value of the temporary variable to the element at index 'j'
    c[j] = temp;
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Insert Delete GetRandom
## Intuition & Approach
The given code implements a data structure called **RandomizedSet**, which maintains a set of unique integers. It supports three main operations: inserting an element, removing an element, and getting a random element from the set.

The class utilizes two primary data structures: a *HashSet* named `randomizedSet` and an *ArrayList* named `elementsList`. The `randomizedSet` stores the unique integers, while the `elementsList` maintains the order of insertion and enables efficient random access.

To insert an element into the set, the `insert` method is called with the value to be inserted. This method checks if the element already exists in the set by calling the private `exist` method. If the element doesn't exist, it adds the element to both the `randomizedSet` and `elementsList` using their respective add methods. Additionally, the `counter` variable is incremented to keep track of the number of elements in the set. *The method returns `true` if the element was successfully inserted*.

The `remove` method is responsible for removing an element from the set. It first checks if the element exists in the set using the `exist` method. If the element is found, it removes the element from both the `randomizedSet` and `elementsList` using their respective remove methods. The `counter` variable is decremented to reflect the updated number of elements. *The method returns `true` if the element was successfully removed*.

The `getRandom` method returns a random element from the set. It achieves this by generating a random index within the range of the current number of elements (`counter`). The `elementsList` is then accessed using this random index, and *the corresponding element is returned*.

The `exist` method simply checks if an element exists in the `randomizedSet` by calling its `contains` method.

## Complexity
- Time complexity: $$O(1)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
this implementation provides constant time complexity for insertion, removal, and getting a random element (`O(1)`). The *HashSet* and *ArrayList* operations used in the implementation have efficient lookup and modification time complexities, enabling the `RandomizedSet` to maintain its functionality effectively.

The space complexity of the given `RandomizedSet` implementation is `O(n)`, where `n` is the number of elements stored in the set.
The space usage is primarily attributed to two data structures: the *HashSet* (`randomizedSet`) and the *ArrayList* (*elementsList*).
The *HashSet* `randomizedSet` stores the unique elements inserted into the set. In the worst case, if all elements are unique, the *HashSet* would require `O(n)` space to store them.
The *ArrayList* *elementsList* maintains the order of insertion and allows for efficient random access. It stores the elements in the same order as they are inserted. Hence, it also requires `O(n)` space to store all the elements.
Additionally, there are a few integer variables (*counter*) used to keep track of the number of elements, which require constant space.
Therefore, considering the space requirements of the *HashSet*, *ArrayList*, and integer variables, the overall space complexity is `O(n)`.

## Code
```Java []

class RandomizedSet {
    private Set<Integer> randomizedSet;
    private List<Integer> elementsList;
    private int counter;

    public RandomizedSet() {
        this.randomizedSet = new HashSet<Integer>();
        this.elementsList = new ArrayList<Integer>();
        this.counter = 0;
    }
    
    public boolean insert(int val) {
        return !exist(val) && randomizedSet.add(val) && elementsList.add(val) && (counter++) >= 0;
    }

    public boolean remove(int val) {
        return exist(val) && randomizedSet.remove(val) && elementsList.remove(Integer.valueOf(val)) && (counter--) >= 0;
    }
    
    public int getRandom() {
        return elementsList.get((int) Math.floor(Math.random() * (counter)));
    }

    private boolean exist(int val) {
        return randomizedSet.contains(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```
```Java []
class RandomizedSet {
    private Set<Integer> randomizedSet; // Set to store unique integers
    private List<Integer> elementsList; // List to maintain insertion order
    private int counter; // Counter to keep track of number of elements

    public RandomizedSet() {
        this.randomizedSet = new HashSet<Integer>(); // Initialize the set
        this.elementsList = new ArrayList<Integer>(); // Initialize the list
        this.counter = 0; // Initialize counter to 0
    }
    
    public boolean insert(int val) {
        return !exist(val) && randomizedSet.add(val) && elementsList.add(val) && (counter++) >= 0;
        // Insert an element if it doesn't exist, update set, list, and counter
    }

    public boolean remove(int val) {
        return exist(val) && randomizedSet.remove(val) && elementsList.remove(Integer.valueOf(val)) && (counter--) >= 0;
        // Remove an element if it exists, update set, list, and counter
    }
    
    public int getRandom() {
        return elementsList.get((int) Math.floor(Math.random() * (counter)));
        // Get a random element from the list
    }

    private boolean exist(int val) {
        return randomizedSet.contains(val); // Check if an element exists in the set
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# 01 Matrix
## Intuition & Approach

The given code implements a method called `updateMatrix` that takes a two-dimensional matrix `mat` as input and returns a new matrix `T` with updated values. The goal is to update the matrix such that each cell contains the minimum distance to the nearest zero cell in `mat`.

The code takes advantage of the ***forward and backward passes*** to iteratively compute the minimum distance, using the previously updated values in `T` to determine distances for subsequent cells.

The approach used in the code is ***dynamic programming***, as it breaks down the problem into smaller subproblems and solves them in at optimized manner by reusing previously computed results.


****Here's a step-by-step explanation of how the code works:****

* Initialize variables `N` and `M` representing *the number of rows and columns* in the input matrix `mat`.

* Check if `mat` is `null`, empty, or a single-cell matrix. If so, return `mat` as it is.

* Create a new matrix `T` to store the updated values, with the same size as `mat`.
* Iterate through each cell in `mat`:

    * If the current cell is zero, *continue to the next iteration*.

    * If the current cell is non-zero, initialize the corresponding cell in `T` with a maximum possible distance (`N + M`).

    * Update the cell in `T` by considering the minimum distance from the above neighbor (if it exists) and the left neighbor (if it exists)
    
* Iterate through each cell in `mat` in ***reverse order***:

    * If the current cell is zero, *continue to the next iteration*.
    
    * Update the cell in `T` by considering the minimum distance from the below neighbor (if it exists) and the right neighbor (if it exists).

* Return the updated matrix `T` containing the minimum distances to the nearest zero cells.

Conceptually, the code first performs an initial pass to calculate the minimum distances from the above and left neighbors. Then, it performs a second pass in reverse order to update the distances based on the below and right neighbors. By combining the information from both passes, it determines the minimum distance from each cell to the nearest zero cell.

## Complexity
- Time complexity: $$O(N*M)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(N*M)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        
        if(mat == null || mat.length == 0 || mat[0].length == 0 || (N == 1 && M == 1))
            return mat;

        int[][] T = new int[N][M];

        for(int i = 0; i < N * M; i++) {
            int r = i / M, c = i % M;
            if(mat[r][c] == 0)
                continue;

            T[r][c] = (N + M);
            if(r > 0)
                T[r][c] = Math.min(T[r][c], T[r - 1][c] + 1);
            if(c > 0)
                T[r][c] = Math.min(T[r][c], T[r][c - 1] + 1);
        }

        for(int i = N * M - 1; i >= 0; i--) {
            int r = i / M, c = i % M;
            if(mat[r][c] == 0)
                continue;
            
            if(r < N - 1)
                T[r][c] = Math.min(T[r][c], T[r + 1][c] + 1);
            if(c < M - 1)
                T[r][c] = Math.min(T[r][c], T[r][c + 1] + 1);
        }

        return T;
    }
}
```

## DOC Code
``` java []
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        
        // Check if mat is null, empty, or a single cell matrix, return mat as it is
        if(mat == null || mat.length == 0 || mat[0].length == 0 || (N == 1 && M == 1))
            return mat;

        // Create a new matrix T to store the updated values
        int[][] T = new int[N][M];

        // Loop through each cell in mat
        for(int i = 0; i < N * M; i++) {
            int r = i / M, c = i % M;
            // If the current cell is 0, continue to the next iteration
            if(mat[r][c] == 0)
                continue;

            // Initialize the value in T[r][c] with a large value (N + M)
            T[r][c] = (N + M);
            
            // Calculate the minimum distance to the current cell from its neighbors above and to the left
            if(r > 0)
                T[r][c] = Math.min(T[r][c], T[r - 1][c] + 1);
            if(c > 0)
                T[r][c] = Math.min(T[r][c], T[r][c - 1] + 1);
        }

        // Loop through each cell in mat in reverse order
        for(int i = N * M - 1; i >= 0; i--) {
            int r = i / M, c = i % M;
            // If the current cell is 0, continue to the next iteration
            if(mat[r][c] == 0)
                continue;
            
            // Calculate the minimum distance to the current cell from its neighbors below and to the right
            if(r < N - 1)
                T[r][c] = Math.min(T[r][c], T[r + 1][c] + 1);
            if(c < M - 1)
                T[r][c] = Math.min(T[r][c], T[r][c + 1] + 1);
        }

        // Return the updated matrix T
        return T;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Letter Case Permutation
## Intuition & Approach
The `letterCasePermutation` function is a recursive algorithm that generates all possible permutations of a given string, considering different letter case combinations. It uses a ***depth-first search*** approach to explore all possible paths in the permutation space.

The function takes the original string, an empty string to store the current permutation, an index indicating the current character being processed, and a list to store the generated permutations.

The algorithm works as follows:

* If the current index is equal to the length of the original string, it means that a complete permutation has been generated. The current permutation is added to the result list.
* If the current character is a letter, the algorithm makes two recursive calls:
  * One call with the current character converted to uppercase, appending it to the current permutation.
  * Another call with the current character converted to lowercase, also appending it to the current permutation.
In both cases, the algorithm increments the index to process the next character.
* If the current character is a digit, the algorithm makes a single recursive call, appending the digit to the current permutation and incrementing the index.
* The algorithm continues this process, exploring different combinations of letter cases and digits until it reaches the base case.
* Finally, the algorithm returns the list of generated permutations.
The algorithm efficiently generates all possible letter case permutations by leveraging the recursive nature of the problem. It avoids redundant calculations by using backtracking and pruning unnecessary branches in the search space.

Key techniques utilized in this algorithm include recursion, backtracking, string manipulation, and list manipulation. The algorithm exhibits a time complexity of $$O(2^n)$$, where n is the length of the input string, as it explores all possible combinations of letter cases.

## Complexity
- Time complexity: $$O(2^n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(2^n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java[]
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(s, "", 0, result);
        
        return result;
    }
    private void letterCasePermutation(String source, String current, int i, List<String> result) {
        if(i == source.length()) {
            result.add(current);
            return ;
        }
        char ch = source.charAt(i);
        if(!Character.isDigit(ch)) {
            letterCasePermutation(source, current + Character.toUpperCase(ch), i + 1, result);
            letterCasePermutation(source, current + Character.toLowerCase(ch), i + 1, result);
        } else
            letterCasePermutation(source, current + ch, i + 1, result);
    }
}
```
## DOC Code
```java []
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>(); // Create a new ArrayList to store the resulting permutations
        
        letterCasePermutation(s, "", 0, result); // Call the overload recursive function to generate permutations
        
        return result; // Return the list of permutations
    }
    private void letterCasePermutation(String source, String current, int i, List<String> result) {
        if (i == source.length()) { // Base case: if the index reaches the end of the source string
            result.add(current); // Add the current permutation to the result list
            return; // Exit the recursive function
        }
        char ch = source.charAt(i); // Get the character at the current index
        if (!Character.isDigit(ch)) { // If the character is not a digit
            letterCasePermutation(source, current + Character.toUpperCase(ch), i + 1, result); // Recursively call the function with the uppercase version of the character
            letterCasePermutation(source, current + Character.toLowerCase(ch), i + 1, result); // Recursively call the function with the lowercase version of the character
        } else {
            letterCasePermutation(source, current + ch, i + 1, result); // If the character is a digit, recursively call the function without changing the character
        }
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Squares of a Sorted Array
## Intuition & Approach
This function takes an array of integers `nums` as input and *returns a new array with the squares of each element in* `nums`, sorted in **non-decreasing order**.

The approach used by this function is to start with **two pointers**, one at the beginning of `nums` and the other at the end. These pointers move towards each other, comparing the absolute values of the elements they are pointing to at each step. The larger absolute value is squared and placed in the result array in **reverse order** (*starting from the end*), until all elements have been processed.

Since the original array `nums` can contain both positive and negative numbers, the absolute values are used to ensure that the resulting array is sorted in **non-decreasing order**. This is because the square of a negative number is positive, and squares of positive numbers are always non-negative.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
	public int[] sortedSquares(int[] nums) {
		int len = nums.length, low = 0, high = len - 1, n, k;
		int[] res = new int[len];
		
		for(int i = len - 1; i >= 0; i--) {
			n = nums[low];
			k = nums[high];
			
			if(Math.abs(n) > Math.abs(k)) {
				res[i] = n*n;
				low++;
			} else {
				res[i] = k*k;
				high--;
			}
		}

		return res;
	}
}
```
## DOC Java
``` java []
class Solution {
    // Takes an array of integers as input and returns a new array with the squares of each element, sorted in non-decreasing order
    public int[] sortedSquares(int[] nums) {
        int len = nums.length, low = 0, high = len - 1, n, k;
        int[] res = new int[len]; // Initialize result array with the same length as nums
        
        // Traverse nums in reverse order
        for(int i = len - 1; i >= 0; i--) {
            n = nums[low]; // Pointer to the start of nums
            k = nums[high]; // Pointer to the end of nums
            
            // Compare absolute values of the elements at n and k
            if(Math.abs(n) > Math.abs(k)) {
                res[i] = n*n; // Square the element at n and add to result array
                low++; // Move the pointer at n to the right
            } else {
                res[i] = k*k; // Square the element at k and add to result array
                high--; // Move the pointer at k to the left
            }
        }

        return res; // Return the sorted squares array
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Maximum 69 Number
## Intuition & Approach

This code takes an integer `num` as input and returns the maximum possible number that can be obtained by changing at most one digit in the given number `num` from 6 to 9.

The code first converts the input number to a character array `arr` using the `valueOf` and `toCharArray` methods of the String class.

Then, the code iterates through the array from left to right using a do-while loop. For each element of the array, the code checks if it is equal to '6'. If it is, the code changes the element to '9' and converts the updated array back to an integer using the `parseInt` and `valueOf` methods of the Integer and String classes, respectively. The resulting integer is then returned as the output.

If the loop completes without finding any '6' digits in the array, the original input number is returned as the output since no digit could be changed to increase the value of the number.

Overall, this algorithm finds the leftmost '6' digit in the input number and changes it to '9' to get the maximum possible number that can be obtained by changing at most one digit.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `maximum69Number` function is O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array and then iterate through each digit of the array to find the leftmost '6' digit. The conversion takes O(n) time, and the loop takes O(n) time in the worst case scenario where the '6' digit is at the end of the array.

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the function is also O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array, which requires creating a new array of length n to store the characters. Additionally, the function creates a string representation of the modified array and then parses it back into an integer, which requires additional memory.

Overall, the function has a linear time complexity and space complexity, which is optimal for this problem since it requires iterating through each digit of the input integer to find the leftmost '6' digit.

## Code
```java []
class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int i = 0;
        
        do {
            if(arr[i] == '6') {
                arr[i] = '9';
                return Integer.parseInt(String.valueOf(arr));
            }
            i++;
        } while(i < arr.length);

        return num;
    }
}
```

## DOC Code
```java []
class Solution {
    public int maximum69Number (int num) {
        // Convert the input integer to a character array
        char[] arr = String.valueOf(num).toCharArray();

        // Initialize a variable to keep track of the current index in the array
        int i = 0;

        // Loop through the array from left to right
        do {
            // Check if the current digit is '6'
            if(arr[i] == '6') {
                // If the current digit is '6', replace it with '9' to maximize the number and return it
                arr[i] = '9';
                return Integer.parseInt(String.valueOf(arr));
            }
            // Move to the next digit
            i++;
        } while(i < arr.length);

        // If no digit can be changed, return the original number
        return num;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Matrix Diagonal Sum
## Intuition & Approach
The ***diagonalSum*** function takes a *square matrix* `mat` as input and returns the sum of the diagonals of the matrix.

The function first initializes a variable `diagonalSum` to 0. It then loops through each row of the matrix using the variable `i` as the row index.

For each row, the function adds the value of the elements at the indices (`i`, `i`) and (`i`, `N - 1 - i`) to the `diagonalSum` variable. These indices correspond to the main diagonal and the secondary diagonal of the matrix, respectively.

Finally, the function subtracts the value of the element at the center of the matrix if the matrix has an odd number of rows and columns. This is because the element at the center is added twice to the `diagonalSum` variable, so we need to subtract one instance of it.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int diagonalSum(int[][] mat) {
        int N = mat.length, diagonalSum = 0;
        for(int i = 0; i < N; i++)
            diagonalSum += mat[i][i] + mat[i][N - 1 - i];
        
        return diagonalSum - ((N % 2 != 0) ? mat[N / 2][N / 2] : 0);
    }
}
```

## DOC Code
``` java []
class Solution {
    public int diagonalSum(int[][] mat) {
        // Get the size of the matrix.
        int N = mat.length;
        // Initialize the sum of the diagonals to 0.
        int diagonalSum = 0;
        // Loop through each row of the matrix.
        for(int i = 0; i < N; i++) {
            // Add the value of the elements at the indices (i, i) and (i, N - 1 - i) to the diagonal sum.
            diagonalSum += mat[i][i] + mat[i][N - 1 - i];
        }
        // If the matrix has an odd number of rows and columns, subtract the value of the element at the center of the matrix.
        if (N % 2 != 0) {
            diagonalSum -= mat[N / 2][N / 2];
        }
        // Return the sum of the diagonals.
        return diagonalSum;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# The K Weakest Rows in a Matrix
## Intuition & Approach
The `kWeakestRows` function is a solution to the problem of finding the `k` weakest rows in a matrix. Each row represents a group of soldiers, and the number of soldiers in each row is counted. The rows are then sorted based on the number of soldiers and their index, in ascending order. Finally, the indices of the `k` weakest rows are stored in an array and returned as the result.

**Here's a step-by-step explanation of how the code works:**

1. The code starts by initializing the variables `N` and `M`, where `N` represents *the number of rows in the matrix* and `M` represents *the number of columns*. It also creates a 2D array called `rowAndSoldiers`, which will store *the number of soldiers and the index for each row*.

2. The code enters a loop that iterates over each row of the matrix. For each row, it counts the number of soldiers using the `countSoldiers` method. This method uses binary search to find *the index of the rightmost soldier* in the row by checking the middle element of the row and adjusting the search range accordingly.

3. So on, the row number and the count of soldiers for each row are stored in the `rowAndSoldiers` array.

4. The `rowAndSoldiers` array is then sorted using a custom comparator. The comparator compares rows based on their soldier counts. If two rows have the same soldier count, it compares their indices. The purpose of this sorting is to arrange the rows in ascending order of soldier count and, in case of a tie, in ascending order of row index.

5. An integer array called `kWeakestRows` is created to store *the indices of the `k` weakest rows*.

6. The code enters another loop that iterates `k` times. In each iteration, it retrieves the row index from the sorted `rowAndSoldiers` array and stores it in the `kWeakestRows` array.

7. Finally, the `kWeakestRows` array containing *the indices of the k weakest rows* is returned as the result.

Overall, the code efficiently solves the problem by counting the soldiers in each row, sorting the rows based on their counts and indices, and returning the indices of the k weakest rows.

## Complexity
- Time complexity: $$O(N*logN)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the given code is $$O(N*M + N*logN + k)$$ where N is the number of rows, M is the number of columns and `k` is the target weakest rows.

Counting the soldiers in each row requires visiting each element in the matrix, resulting in a time complexity of $$O(N * M)$$. Sorting the `rowAndSoldiers` array using `Arrays.sort` has a time complexity of $$O(N*logN)$$ because it based on the *TimSort algorithm*.
Finally ,the loop the populates the `kWeakestRows` array runs `k` times, resulting in a time complexity of $$O(k)$$.
There fore, the overall time complexity is dominated by the sorting step, resulting in $$O(N*logN)$$

- Space complexity: $$O(N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The space complexity of the code is $$O(N)$$, where `N` is the number of rows in the matrix, this is because the `rowAndSoldiers` array is created to store the soldier counts and indices for each row. The space required for this array is proportional to the number of rows, which is `N`. The additional space used by other vars and arrays is constant and does not scale with the input size.

## Code
``` java []
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int N = mat.length, M = mat[0].length;
        int[][] rowAndSoldiers = new int[N][2];
        for(int i = 0; i < N; i++)
            rowAndSoldiers[i] = new int[] { countSoldiers(mat[i]), i};
        Arrays.sort(rowAndSoldiers, (x, y) ->
            (x[0] == y[0]) ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));
        int[] kWeakestRows = new int[k];
        for(int i = 0; i < k; i++)
            kWeakestRows[i] = rowAndSoldiers[i][1];
        
        return kWeakestRows;
    }
    private int countSoldiers(int[] v) {
        int low = 0, high = v.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(v[mid] > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Special Array with X Elements Greater Than or Equal X
## Intuition & Approach
The `specialArray` function implements a solution to *find a "special" integer within an array*. Here's an intuition and approach for how the code works:

1. The `specialArray` method takes an array of integers `nums` as input and returns an integer.

2. It initializes `low` and `high` variables to define *the range of possible values for the special integer*. `low` is initially set to `0`, and `high` is set to *the length of the input array*.

3. The code enters a while loop that *continues as long as `low` is less than or equal to `high`*. This loop uses a **binary search algorithm** to efficiently narrow down the range and find the special integer.

4. Inside the loop, it calculates the midpoint `mid` of the current range. This midpoint represents the value being checked for its special property.

5. The `countGreaterOrEqual` method is called, passing the array nums and the current midpoint `mid` as arguments. This method iterates over the array and *counts the number of elements that are greater than or equal to mid*.

6. If the count `cgoe` is equal to `mid`, it means that `mid` is the special integer. In this case, the method returns `mid` as the result.

7. If `cgoe` is greater than `mid`, it implies that there are more than `mid` elements in `nums` that are greater than or equal to `mid`. Therefore, the special integer should be in the range `[mid + 1, high]`. Consequently, `low` is updated to `mid + 1` to search in the higher range.

8. If `cgoe` is less than mid, it indicates that there are fewer than `mid` elements in `nums` that are greater than or equal to `mid`. Thus, the special integer should be in the range `[low, mid - 1]`. Consequently, `high` is updated to `mid - 1` to search in the lower range.

9. If the while loop completes without finding the special integer, the method returns `-1` to indicate that there is no special integer in the array.

The ***binary search algorithm*** employed in this code allows for efficient searching in the array. It repeatedly divides the search range in half, reducing the search space by half with each iteration. This approach results in a time complexity of $$O(log n)$$, where n is the size of the input array (within each iteration of the binary search, it calls the `countGreaterOrEqual` method, which has a time complexity of $$O(n)$$ due to the loop iterating over the entire array).

Additionally, the code uses the ***principle of breaking down*** a complex problem into smaller subproblems. By dividing the search range and counting the number of elements greater than or equal to a particular value, the algorithm progressively narrows down the search space until the special integer is found or the search range is exhausted.

## Complexity
- Time complexity: $$O(n*logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int specialArray(int[] nums) {
        int low = 0, high = nums.length;
        while(low <= high) {
            int mid = low + (high - low) / 2, 
                cgoe = countGreaterOrEqual(nums, mid);
                
            if(cgoe == mid)
                return mid;
            else if(cgoe > mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    private int countGreaterOrEqual(int[] m, int v) {
        int c = 0;
        for(int i = 0; i < m.length; i++)
            if(m[i] >= v)
                c++;
        
        return c;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Determine the Winner of a Bowling Game
## Intuition & Approach

The function `isWinner` takes two integer arrays, `player1` and `player2`, representing the number of pins knocked down by each player in their sequence of rolls. The function then calculates the final scores of both players and returns the result of the game as follows:

- If the scores are equal, return 0, indicating a tie.
- If the score of player 1 is higher, return 1, indicating player 1 wins.
- If the score of player 2 is higher, return 2, indicating player 2 wins.

The calculation of the final score is done using a while loop that iterates through both player's rolls, keeping track of the current and previous rolls for each player. If a player scores a strike (knocking down all ten pins in one roll), the next two rolls are counted twice towards their score. If a player scores a spare (knocking down all ten pins in two rolls), the next roll is counted twice towards their score.

Overall, the code is a simple implementation of a scoring system for the game of Bowling, and it assumes that the input arrays player1 and player2 have the same length and are well-formed.

## Complexity
- Time complexity: $$O(n)$$ where `n` indicates how many turns.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = player1[0], s2 = player2[0], i = 1,
            p1 = player1[i - 1], p2 = player2[i - 1],
            pp1 = -1, pp2 = -1;

        while(i < player1.length) {
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            pp1 = p1;
            pp2 = p2;
            p1 = player1[i];
            p2 = player2[i];

            i++;
        }

        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```
``` python []
class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        s1, s2, p1, p2 = player1[0], player2[0], -1, -1

        for i in range(1, len(player1)):
            s1 += (2 * player1[i]) if (player1[i - 1] == 10 or p1 == 10) else player1[i]
            s2 += (2 * player2[i]) if (player2[i - 1] == 10 or p2 == 10) else player2[i]
            p1, p2 = player1[i - 1], player2[i - 1]

        return 0 if s1 == s2 else 1 if s1 > s2 else 2
    
```
``` javascript []
/**
 * @param {number[]} player1
 * @param {number[]} player2
 * @return {number}
 */
var isWinner = function(player1, player2) {
    let s1 = player1[0], s2 = player2[0], i = 1,
        p1 = player1[i - 1], p2 = player2[i - 1],
        pp1 = -1, pp2 = -1;
    
    while(i < player1.length) {
        s1 += isTen(p1, pp1) ? 2 * player1[i] : player1[i];
        s2 += isTen(p2, pp2) ? 2 * player2[i] : player2[i];

        pp1 = p1;
        pp2 = p2;
        p1 = player1[i];
        p2 = player2[i++];
    }

    return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
};

const isTen = (n1, n2) => n1 === 10 || n2 === 10;
```
## DOC Java Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
            // Declare and initialize variables for the total score of each player and the frame number
        int s1 = player1[0], s2 = player2[0], i = 1,
            // Initialize variables for the current score and the previous score for each player
            p1 = player1[i - 1], p2 = player2[i - 1],
            // Initialize variables for the previous previous score for each player (default to -1)
            pp1 = -1, pp2 = -1;

        // Loop through each frame in the players' score arrays
        while(i < player1.length) {
            // Calculate the score for each player for the current frame, taking into account any bonuses
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            // Update the previous-previous scores for each player
            pp1 = p1;
            pp2 = p2;
            
            // Update the current scores to be previous scores for each player
            p1 = player1[i];
            p2 = player2[i];

            // Increment the frame number
            i++;
        }

        // Compare the total scores of the two players and return a result indicating the winner
        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>
