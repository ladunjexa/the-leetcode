# Intuition & Approach
The `getRow` function takes an integer `rowIndex` as input and returns *the `rowIndex`th row of Pascal's triangle as a list of integers*.

To generate the row, the function iterates over each element in the row, starting from the first element (index 0) up to the `rowIndex`th element. For each element in the row, the function calculates the binomial coefficient `C(rowIndex, k)`, where `k` is the index of the current element.

The binomial coefficient `C(rowIndex, k)` is computed using the formula: 
$$C(n, k) = \frac{n!}{k! * (n - k)!}$$ where `n` is the `rowIndex` and `k` is the *index of the current element in the row*.

To compute `C(rowIndex, k)`, the function initializes a variable `coeff` to `1` and iterates over all values of `j` from 1 to `k`. For each value of j, it multiplies `coeff` by the expression `(rowIndex - k + j) / j` and rounds the result to the nearest integer using `Math.round`.

After computing the binomial coefficient for the current element, the function adds it to a list representing the current row of Pascal's triangle. Once all elements in the row have been computed, the function returns the list representing the row.

This implementation uses **double-precision floating-point arithmetic** to compute the binomial coefficients and then rounds the result to the nearest integer to ensure accuracy.

In terms of optimization, we can note that we are computing the binomial coefficient using multiplication and division. For larger values of `rowIndex`, this computation can become computationally expensive. However, we can optimize this by using the fact that `C(n, k) = C(n, k-1) * (n-k+1) / k`. This allows us to compute each binomial coefficient in `O(1)` time by using the previously computed value, which reduces the time complexity to `O(rowIndex)` - *optimized code below*.

# Complexity
- Time complexity: $$O(n^2)$$ and optimized version is $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$ for both versions
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int k = 0; k <= rowIndex; k++) {
            int coeff = 1;
            // Calculate C(rowIndex, k)
            for(int j = 1; j <= k; j++)
                coeff = (int) Math.round((double) coeff * (rowIndex - k + j) / j);
            
            row.add(coeff);
        }

        return row;
    }
}
```
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long coeff = 1;

        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) coeff);
            coeff = coeff * (rowIndex - k) / (k + 1);
        }

        return row;
    }
}
```
# DOC Java
The **naive solution** implementation uses a nested loop to calculate the binomial coefficients for each index in the row. The outer loop iterates over the row indices, while the inner loop calculates each coefficient using the formula $$C(rowIndex, k) = (rowIndex choose k) = (rowIndex! / (k! * (rowIndex - k)!))$$. The calculation is performed using a variant of the formula that avoids computing large factorials, as described in the earlier.

The coefficients are added to the row list, which is then returned as the final output of the function.
``` java []
public List<Integer> getRow(int rowIndex) {
    // Create a new list to store the row
    List<Integer> row = new ArrayList<>();

    // Iterate over the row and calculate each coefficient
    for (int k = 0; k <= rowIndex; k++) {
        // Set the initial value of the coefficient to 1
        int coeff = 1;

        // Calculate the binomial coefficient C(rowIndex, k)
        for (int j = 1; j <= k; j++) {
            // Multiply the coefficient by (rowIndex - k + j) / j
            // Note: we use Math.round to handle floating-point errors
            coeff = (int) Math.round((double) coeff * (rowIndex - k + j) / j);
        }
        
        // Add the coefficient to the row
        row.add(coeff);
    }

    // Return the completed row
    return row;
}
```
``` java []
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long coeff = 1; // Initialize coefficient to 1

        for (int k = 0; k <= rowIndex; k++) { // Iterate from 0 to rowIndex
            row.add((int) coeff); // Add coefficient to the current row
            coeff = coeff * (rowIndex - k) / (k + 1); // Calculate next coefficient
        }

        return row; // Return the row
    }
}
```
