# Intuition & Approach
The problem of the `generate` function is to to generate the first `numRows` of Pascal's triangle and return *it as a list of lists of integers*.

**Pascal's triangle** is a triangular array of numbers in which the first and last elements of each row are `1`, and each of the other elements is the sum of the two elements directly above it.

To solve this problem, we can use two lists: `current` and `previous`. We start by adding the first row, which is simply the number 1. Then, we iterate from the second row to the `numRows-th` row, adding the first and last elements of each row as `1` and calculating the other elements as the sum of the corresponding elements in the `previous` row. We use the `previous` list to access the elements of the previous row and the `current` list to store the elements of the current row. we add each `current` list to the `pascalTriangle` list as we calculate it.

After calculating each row, we set `previous` equal to `current` and create a new empty `current` list to calculate the next row. Finally, we return *the pascalTriangle list containing all the rows of Pascal's triangle*.

This approach uses **dynamic programming** to store the values of the previous row and avoid unnecessary calculations.

# Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n^2)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The time complexity of this algorithm is $$O(n^2)$$, as we need to calculate each element of each row, and the space complexity is $$O(n^2)$$, as we need to store all the elements of Pascal's triangle, because, number of elements in **i<sup>th</sup>** row is `(i + 1)`, if so, to ***find the number of elements in Pascal's triangle of n rows***, we can sum of the first n natural numbers using the formula: $$n\frac{(n+1)}{2}$$. hence, space complexity is: 
$$n\frac{(n+1)}{2}=\frac{(n^2+n)}{2}=S(\frac{n^2}{2}+\frac{n}{2})=S(\frac{n^2}{2})=O(n^2)$$

# Code
``` java []
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        List<Integer> current = new ArrayList<>(), previous = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++)
                if(i != 0 && j > 0 && j < i)
                    current.add(previous.get(j - 1) + previous.get(j));
                else
                    current.add(1);
            
            pascalTriangle.add(current);
            previous = current;
            current = new ArrayList<>();
        }
        
        return pascalTriangle;
    }
}
```
# DOC Java
``` java []
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Initialize the list of lists that will hold the Pascal's triangle
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Initialize the current and previous rows as empty lists
        List<Integer> current = new ArrayList<>(), previous = new ArrayList<>();

        // Loop through each row of the Pascal's triangle
        for(int i = 0; i < numRows; i++) {
            // Loop through each element of the current row
            for(int j = 0; j <= i; j++) {
                // If the element is not in the first or last column of the row,
                // add the sum of the two elements directly above it to the current row
                if(i != 0 && j > 0 && j < i) {
                    current.add(previous.get(j - 1) + previous.get(j));
                } 
                // Otherwise, add 1 to the current row
                else {
                    current.add(1);
                }
            }
            // Add the current row to the Pascal's triangle
            pascalTriangle.add(current);
            // Set the previous row to be the current row for the next iteration
            previous = current;
            // Clear the current row for the next iteration
            current = new ArrayList<>();
        }
        
        // Return the completed Pascal's triangle
        return pascalTriangle;
    }
}
```
