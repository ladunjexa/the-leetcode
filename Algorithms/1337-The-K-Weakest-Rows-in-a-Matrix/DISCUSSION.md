# Intuition & Approach
The `kWeakestRows` function is a solution to the problem of finding the `k` weakest rows in a matrix. Each row represents a group of soldiers, and the number of soldiers in each row is counted. The rows are then sorted based on the number of soldiers and their index, in ascending order. Finally, the indices of the `k` weakest rows are stored in an array and returned as the result.

**Here's a step-by-step explanation of how the code works:**

1. The code starts by initializing the variables `N` and `M`, where `N` represents *the number of rows in the matrix* and `M` represents *the number of columns*. It also creates a 2D array called `rowAndSoldiers`, which will store *the number of soldiers and the index for each row*.

2. The code enters a loop that iterates over each row of the matrix. For each row, it counts the number of soldiers using the `countSoldiers` method. This method uses binary search to find *the index of the rightmost soldier* in the row by checking the middle element of the row and adjusting the search range accordingly.

3. So on, the row number and the count of soldiers for each row are stored in the `rowAndSoldiers` array.

4. The `rowAndSoldiers` array is then sorted using a custom comparator. The comparator compares rows based on their soldier counts. If two rows have the same soldier count, it compares their indices. The purpose of this sorting is to arrange the rows in ascending order of soldier count and, in case of a tie, in ascending order of row index.

5. An integer array called `kWeakestRows` is created to store *the indices of the `k` weakest rows*.

6. The code enters another loop that iterates `k` times. In each iteration, it retrieves the row index from the sorted `rowAndSoldiers` array and stores it in the `kWeakestRows` array.

7. Finally, the `kWeakestRows` array containing *the indices of the k weakest rows* is returned as the result.

Overall, the code efficiently solves the problem by counting the soldiers in each row, sorting the rows based on their counts and indices, and returning the indices of the k weakest rows.

# Complexity
- Time complexity: $$O(N*logN)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the given code is $$O(N*M + N*logN + k)$$ where N is the number of rows, M is the number of columns and `k` is the target weakest rows.

Counting the soldiers in each row requires visiting each element in the matrix, resulting in a time complexity of $$O(N * M)$$. Sorting the `rowAndSoldiers` array using `Arrays.sort` has a time complexity of $$O(N*logN)$$ because it based on the *TimSort algorithm*.
Finally ,the loop the populates the `kWeakestRows` array runs `k` times, resulting in a time complexity of $$O(k)$$.
There fore, the overall time complexity is dominated by the sorting step, resulting in $$O(N*logN)$$

- Space complexity: $$O(N)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The space complexity of the code is $$O(N)$$, where `N` is the number of rows in the matrix, this is because the `rowAndSoldiers` array is created to store the soldier counts and indices for each row. The space required for this array is proportional to the number of rows, which is `N`. The additional space used by other vars and arrays is constant and does not scale with the input size.

# Code
``` java []
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int N = mat.length, M = mat[0].length;
        int[][] rowAndSoldiers = new int[N][2];

        for(int i = 0; i < N; i++)
            rowAndSoldiers[i] = new int[] { countSoldiers(mat[i]), i};

        Arrays.sort(rowAndSoldiers, (x, y) ->
            (x[0] == y[0]) ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));

        int[] kWeakestRows = new int[k];

        for(int i = 0; i < k; i++)
            kWeakestRows[i] = rowAndSoldiers[i][1];
        
        return kWeakestRows;
    }

    private int countSoldiers(int[] v) {
        int low = 0, high = v.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(v[mid] > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}
```
