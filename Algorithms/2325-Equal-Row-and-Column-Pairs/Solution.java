class Solution {
    public int equalPairs(int[][] grid) {
        int N = grid.length, P = 0;
        
        for(int i = 0; i < N * N; i++)
            if(compare(grid[i / N], grid, i % N))
                P++;
                
        return P;
    }

    private boolean compare(int[] v, int[][] g, int pos) {
        for(int i = 0; i < v.length; i++)
            if(v[i] != g[i][pos])
                return false;
        
        return true;
    }
}
