# Intuition & Approach

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

# Complexity
- Time complexity: $$O(N*M)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(N*M)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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
# DOC Code
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
