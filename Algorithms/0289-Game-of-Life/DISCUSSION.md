# Intuition & Approach
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

# Complexity
- Time complexity: $$O(M * N)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(M * N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Let `M` be the number of rows and `N` be the number of columns in the grid.
The `gameOfLife` method iterates over all `M * N` cells, resulting in a time complexity of `O(M * N)`.
The `applyRules` method and `countLiveNeighbors` method both have a constant time complexity since they perform a fixed number of opreations.
The space complexity of the algorithm is `O(M * N)` because it craetes a new 2D array (`source`) of the same size as the input grid.

# Code
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
