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
