# Intuition & Approach
The ***diagonalSum*** function takes a *square matrix* `mat` as input and returns the sum of the diagonals of the matrix.

The function first initializes a variable `diagonalSum` to 0. It then loops through each row of the matrix using the variable `i` as the row index.

For each row, the function adds the value of the elements at the indices (`i`, `i`) and (`i`, `N - 1 - i`) to the `diagonalSum` variable. These indices correspond to the main diagonal and the secondary diagonal of the matrix, respectively.

Finally, the function subtracts the value of the element at the center of the matrix if the matrix has an odd number of rows and columns. This is because the element at the center is added twice to the `diagonalSum` variable, so we need to subtract one instance of it.

# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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

# DOC Code
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
