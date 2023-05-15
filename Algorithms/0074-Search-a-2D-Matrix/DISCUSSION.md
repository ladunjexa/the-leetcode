# Intuition & Approach
The `searchMatrix` function takes a `m x n` integer matrix `matrix` that is sorted row-rise and a integer value `target` as input and returns `true` if `target` is in `matrix` or `false` otherwise.

The approach taken by this code is to use a **modified binary search algorithm**. The binary search is applied to two phases in the algorithm:
* Finding the row that potentially contains the target element
* Searching the potential row for the target element

In the first phase, we apply binary search to search for the row in which the `target` value could be found. We start with the middle row and compare the minimum and maximum values in that row with the `target` value. If the `target` is within the range of the minimum and maximum values, then we perform a binary search on that row to find the `target` value. If the `target` is greater than the minimum value of the middle row, then we know that *the `target` value is in the upper half of the matrix*. Similary, if the `target` is less than the minimum value of the middle row, then we know that *the target value is the lower half of the matrix*.

In the second phase, we apply a *standard implementation of the binary search algorithm* on the potential row to search for the target element, which searches for a `target` value in a sorted array by repeatedly *diving the search interval in half*.

The *time complexity* of the algorithm is $$T(log(m) + log(n)) = T(log(m * n)) = O(log(m * n))$$, where `m` and `n` are the number of rows and columns in the matrix respectively. The *space complexity* is $$O(1)$$ since we are using constant extra space for the variable.

# Complexity
- Time complexity: $$O(log(m * n))$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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
