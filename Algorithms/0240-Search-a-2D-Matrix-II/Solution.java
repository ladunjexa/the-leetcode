class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        
        int M = matrix.length - 1, N = matrix[0].length - 1, i = M, j = 0;
        
        while(i >= 0 && j <= N)
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                j++;
            else
                i--;

        return false;
    }
}
