# Intuition & Approach
The `uniquePathsWithObstacles` function uses a **recursive approach with memoization** to solve the problem of finding the number of unique paths in an obstacle grid. The memoization technique is used *to avoid redundant computations and improve the efficiency of the function*.

The main function `uniquePathsWithObstacles` takes the obstacle grid as input and initializes a memoization array `memo` of the same size as the grid. The function then calls the helper function (*method overloading*) `uniquePathsWithObstacles` with the initial parameters `(0, 0)` representing the *starting position of the robot*.

The helper function `uniquePathsWithObstacles` recursively calculates the number of unique paths from the current position `(i, j)` to the bottom-right corner. It checks three base cases:

1. If the current position is out of bounds or contains an obstacle, the path is invalid, so it *returns `0`*.

2. If the current position is at the bottom-right corner, it means a valid path has been found, so it *returns `1`*.

3. If the result for the current position has already been calculated and stored in the memoization array, it directly *returns the stored result*.

If none of the base cases are met, the function calculates the number of unique paths by recursively moving to the right `(i, j + 1)` and down `(i + 1, j)` from the current position and summing up the results. It stores the result in the memoization array for future use and *returns the result*.

The `isOutOfBounds` function is a helper function that checks if a given position `(i, j)` is *outside the bounds of the grid*.

Overall, the solution efficiently solves the problem of finding the number of unique paths in an obstacle grid by using memoization to avoid redundant computations.

# Complexity
- Time complexity: $$O(M x N)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(M x N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The time complexity of `uniquePathsWithObstacles` function depends on the size of the grid, given by `M x N`. Since each position in the grid is computed once and stored in the memoization array, the time complexity can be considered as `O(M x N)`.

The space complexity of the solution is also `O(M x N)` because of the memoization array, which has the same size as the grid. Additionally, the recursion stack will occupy space proportional to the maximum depth of the recursion, which is equal to the sum of `M` and `N` in the worst case. However, since the solution states that the answer will be less than or equal to `2 * 10^9`, the recursion depth will not exceed a large value.

# Code
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
