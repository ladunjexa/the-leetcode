class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        for(int i = 0; i < N; i++)
            for(int j = i; j < N; j++)
                transposeSwap(matrix, i, j);
        
        for(int i = 0; i < N; i++)
            reverse(matrix[i]);
    }

    private void reverse(int[] vec) {
        int i = 0, j = vec.length - 1;

        while(i < j)
            swap(vec, i++, j--);
    }
    
    private void swap(int[] vec, int i, int j) {
        int temp = vec[i];
        vec[i] = vec[j];
        vec[j] = temp;
    }
    
    private void transposeSwap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
}
