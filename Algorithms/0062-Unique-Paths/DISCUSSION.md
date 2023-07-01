# Intuition
The solution utilizes ***dynamic programming*** to solve the problem efficiently. It uses a recursive approach with memoization to avoid redundant calculations. The function `uniquePaths` takes the dimensions of the grid, the current position `(i, j)`, and a memoization table `dp` as parameters.

# Approach
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

# Complexity
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

# Code
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

# DOC Code
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
