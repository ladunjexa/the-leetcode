<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT LOGO -->
# LeetCode Published Discussions

This .md file contains discussions of many questions from leetcode I've published.

_Read source-code by Programming Languages:_
[_Java_](https://github.com/ladunjexa/leetcode/search?l=java),
[_C#_](https://github.com/ladunjexa/leetcode/search?l=c%23),
[_Python_](https://github.com/ladunjexa/leetcode/search?l=python),
[_JavaScript_](https://github.com/ladunjexa/leetcode/search?l=javascript),
[_TypeScript_](https://github.com/ladunjexa/leetcode/search?l=typescript)

*☝ Note that this project is meant to be used for learning and researching purposes
only, and it is **not** meant to be used for production.*

# :information_source: Contents

### Table of Discussions
* [35. Search Insert Position](#search-insert-position)
* [36. Valid Sudoku](#valid-sudoku)
* [74. Search a 2D Matrix](#search-a-2d-matrix)
* [118. Pascal's Triangle](#pascal's-triangle)
* [119. Pascal's Triangle II](#pascal's-triangle-ii)
* [167. Two Sum II - Input Array Is Sorted](#two-sum-ii)
* [189. Rotate Array](#rotate-array)
* [202. Happy Number](#happy-number)
* [278. First Bad Version](#first-bad-version)
* [283. Move Zeroes](#move-zeroes)
* [326. Power of Three](#power-of-three)
* [344. Reverse String](#reverse-string)
* [977. Squares of a Sorted Array](#squares-of-a-sorted-array)
* [1323. Maximum 69 Number](#maximum-69-number)
* [1572. Matrix Diagonal Sum](#matrix-diagonal-sum)
* [2660. Determine the Winner of a Bowling Game](#determine-the-winner-of-a-bowling-game)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Search Insert Position
## Intuition & Approach
The given code implements the binary search algorithm to find the index where a `target` value should be inserted into a sorted array of integers.

The function takes two inputs: an integer array `nums`, which is the sorted array of integers, and an integer `target`, which is the value that needs to be inserted into the array. It starts by initializing three variables, `low`, `high`, and `i`, where `low` is set to `0` (*the first index of the array*), `high` is set to `nums.length - 1` (*the last index of the array*), and `i` is set to `-1` (*an initial value to be updated later*).

The while loop runs until `low` is less than or equal to `high`. In each iteration, the value of `i` is updated as the middle index between `low` and `high`, using the formula `(low + (high - low) / 2)`. This is done to **avoid integer overflow**, as using `(low + high) / 2` can cause overflow if the sum of `low` and `high` is greater than the maximum integer value.

The code then checks whether the value at the i<sup>th</sup> index of the array is equal to the target. If it is, the function *returns the index* `i`.

If the value at the i<sup>th</sup> index is less than the target, the code updates the value of `low` to `i + 1`, indicating that the target value should be inserted to the right of the i<sup>th</sup> index.

If the value at the i<sup>th</sup> index is greater than the target, the code updates the value of `high` to `i - 1`, indicating that the target value should be inserted to the left of the i<sup>th</sup> index.

The loop continues until `low` becomes greater than `high`, at which point the function returns the value of `low`, which represents *the index where the target value should be inserted into the sorted array*.

In summary, the function uses the **binary search algorithm** to efficiently find the index where a target value should be inserted into a sorted array by dividing the array in half at each iteration and updating the search range accordingly based on the result of comparing the value at the middle index to the target value.

## Complexity
- Time complexity: $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, i = -1;

        while(low <= high) {
            i = low + ((high - low) / 2);
            if(nums[i] == target)
                return i;
            if(nums[i] < target)
                low = i + 1;
            else
                high = i - 1;
        }

        return low;
    }
}
```
## DOC Java
``` java []
class Solution {
    public int firstBadVersion(int n) {
        // Initialize the lower bound of the search range to the first version
        int low = 1, 
        // Initialize the middle version to -1 (an initial value to be updated later)
            mid = -1;
        // Loop until the lower bound is less than or equal to the upper bound
        while(low <= n) {
            // Calculate the middle version between the lower and upper bounds, avoiding integer overflow
            mid = low + ((n - low) / 2);
            // Check if the middle version is a bad version, if true update the upper bound to search for the first bad version on the left side of mid
            if(isBadVersion(mid))
                n = mid - 1;
            // If the middle version is not a bad version, update the lower bound to search for the first bad version on the right side of mid
            else
                low = mid + 1;
        }
        // Return the index of the first bad version, which is equal to the lower bound
        return low;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Valid Sudoku
## Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->

This function checks if a given 9x9 Sudoku board is valid or not. The function first checks if the input board is valid, which means it is not null and has a length and width of 9. If the board is not valid, it returns false.

If the board is valid, the function iterates through each cell in the board and checks if it contains a digit. If it contains a digit, the function calls the `isValidSudoku` helper function to check if the digit is valid in its row, column, and 3x3 square.

The `isValidSudoku` helper function checks if the digit at the given cell is valid in its row and column by iterating through all the cells in the same row and column and checking if any of them contain the same digit. It also checks if the digit is valid in the 3x3 square by calculating the starting row and column of the 3x3 square and iterating through all the cells in the square and checking if any of them contain the same digit.

If the digit is valid in its row, column, and 3x3 square, the `isValidSudoku` helper function returns true. If the digit is not valid in any of those locations, it returns false.

If the $$isValidSudoku$$ helper function returns false, the main function immediately returns false because the board is not valid. If the function completes the iteration over all the cells and none of them are invalid, it returns true because the board is valid.

## Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `isValidSudoku` function is O(1) because it always checks the same number of cells (i.e., 27 cells) regardless of the size of the input board. The time complexity of the `isValidSudoku` function called within the main function is O(n<sup>2</sup>) where n is the size of the input board. This is because the `isValidSudoku` function iterates over each row, column, and 3x3 square once.

The time complexity of the main function `isValidSudoku` is O(n<sup>2</sup>) because it iterates over each cell in the input board once and calls the `isValidSudoku` helper function once for each cell. Therefore, the total time complexity is O(n<sup>2</sup>).

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the isValidSudoku function is O(1) because it uses a constant amount of space to store variables to check for valid digits. The space complexity of the main function isValidSudoku is also O(1) because it uses only a constant amount of space for its variables. Therefore, the total space complexity is O(1).

## Code
```java []
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.' && !isValidSudoku(board, i, j))
                    return false;

        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int i, int j) {
        for(int k = 0; k < 9; k++)
            if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j]))
                return false;

        int row = (i / 3) * 3, col = (j / 3) * 3;
        for(int k = row; k < row + 3; k++)
            for(int n = col; n < col + 3; n++)
                if(i != k && n != j && board[i][j] == board[k][n])
                    return false;

        return true;
    }
}
```

## DOC Code
```java []
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check if board is null or not 9x9
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        // Check if each cell in the board is valid
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                // Check if cell contains a digit and if the digit is valid in its row, column, and 3x3 square
                if (board[i][j] != '.' && !isValidSudoku(board, i, j))
                    return false;

        // Return true if all cells are valid
        return true;
    }
    
    // Check if the digit in the given cell is valid in its row, column, and 3x3 square
    private boolean isValidSudoku(char[][] board, int i, int j) {
        // Check row and column for duplicate digits
        for(int k = 0; k < 9; k++)
            if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j]))
                return false;

        // Check 3x3 square for duplicate digits
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int k = row; k < row + 3; k++)
            for(int n = col; n < col + 3; n++)
                if(i != k && n != j && board[i][j] == board[k][n])
                    return false;

        // Return true if digit is valid in its row, column, and 3x3 square
        return true;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Search a 2D Matrix
## Intuition & Approach
The `searchMatrix` function takes a `m x n` integer matrix `matrix` that is sorted row-rise and a integer value `target` as input and returns `true` if `target` is in `matrix` or `false` otherwise.

The approach taken by this code is to use a **modified binary search algorithm**. The binary search is applied to two phases in the algorithm:
* Finding the row that potentially contains the target element
* Searching the potential row for the target element

In the first phase, we apply binary search to search for the row in which the `target` value could be found. We start with the middle row and compare the minimum and maximum values in that row with the `target` value. If the `target` is within the range of the minimum and maximum values, then we perform a binary search on that row to find the `target` value. If the `target` is greater than the minimum value of the middle row, then we know that *the `target` value is in the upper half of the matrix*. Similary, if the `target` is less than the minimum value of the middle row, then we know that *the target value is the lower half of the matrix*.

In the second phase, we apply a *standard implementation of the binary search algorithm* on the potential row to search for the target element, which searches for a `target` value in a sorted array by repeatedly *diving the search interval in half*.

The *time complexity* of the algorithm is $$T(log(m) + log(n)) = T(log(m * n)) = O(log(m * n))$$, where `m` and `n` are the number of rows and columns in the matrix respectively. The *space complexity* is $$O(1)$$ since we are using constant extra space for the variable.

## Complexity
- Time complexity: $$O(log(m * n))$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Pascal's Triangle
## Intuition & Approach
The problem of the `generate` function is to to generate the first `numRows` of Pascal's triangle and return *it as a list of lists of integers*.

**Pascal's triangle** is a triangular array of numbers in which the first and last elements of each row are `1`, and each of the other elements is the sum of the two elements directly above it.

To solve this problem, we can use two lists: `current` and `previous`. We start by adding the first row, which is simply the number 1. Then, we iterate from the second row to the `numRows-th` row, adding the first and last elements of each row as `1` and calculating the other elements as the sum of the corresponding elements in the `previous` row. We use the `previous` list to access the elements of the previous row and the `current` list to store the elements of the current row. we add each `current` list to the `pascalTriangle` list as we calculate it.

After calculating each row, we set `previous` equal to `current` and create a new empty `current` list to calculate the next row. Finally, we return *the pascalTriangle list containing all the rows of Pascal's triangle*.

This approach uses **dynamic programming** to store the values of the previous row and avoid unnecessary calculations.

## Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n^2)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The time complexity of this algorithm is $$O(n^2)$$, as we need to calculate each element of each row, and the space complexity is $$O(n^2)$$, as we need to store all the elements of Pascal's triangle, because, number of elements in **i<sup>th</sup>** row is `(i + 1)`, if so, to ***find the number of elements in Pascal's triangle of n rows***, we can sum of the first n natural numbers using the formula: $$n\frac{(n+1)}{2}$$. hence, space complexity is: 
$$n\frac{(n+1)}{2}=\frac{(n^2+n)}{2}=S(\frac{n^2}{2}+\frac{n}{2})=S(\frac{n^2}{2})=O(n^2)$$

## Code
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
## DOC Java
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Pascal's Triangle II
## Intuition & Approach
The `getRow` function takes an integer `rowIndex` as input and returns *the `rowIndex`th row of Pascal's triangle as a list of integers*.

To generate the row, the function iterates over each element in the row, starting from the first element (index 0) up to the `rowIndex`th element. For each element in the row, the function calculates the binomial coefficient `C(rowIndex, k)`, where `k` is the index of the current element.

The binomial coefficient `C(rowIndex, k)` is computed using the formula: 
$$C(n, k) = \frac{n!}{k! * (n - k)!}$$ where `n` is the `rowIndex` and `k` is the *index of the current element in the row*.

To compute `C(rowIndex, k)`, the function initializes a variable `coeff` to `1` and iterates over all values of `j` from 1 to `k`. For each value of j, it multiplies `coeff` by the expression `(rowIndex - k + j) / j` and rounds the result to the nearest integer using `Math.round`.

After computing the binomial coefficient for the current element, the function adds it to a list representing the current row of Pascal's triangle. Once all elements in the row have been computed, the function returns the list representing the row.

This implementation uses **double-precision floating-point arithmetic** to compute the binomial coefficients and then rounds the result to the nearest integer to ensure accuracy.

In terms of optimization, we can note that we are computing the binomial coefficient using multiplication and division. For larger values of `rowIndex`, this computation can become computationally expensive. However, we can optimize this by using the fact that `C(n, k) = C(n, k-1) * (n-k+1) / k`. This allows us to compute each binomial coefficient in `O(1)` time by using the previously computed value, which reduces the time complexity to `O(rowIndex)` - *optimized code below*.

## Complexity
- Time complexity: $$O(n^2)$$ and optimized version is $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$ for both versions
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
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
## DOC Java
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Two Sum II
## Intuition & Approach
The purpose of the `twoSum` function is to find the indices of two numbers in the given `numbers` array whose **sum equals the given `target` value**. It uses the *two-pointer technique* to efficiently search for the required numbers.

The *two-pointer technique* involves initializing two pointers, `low` and `high`, to the beginning and end of the array, respectively. Then, at each step of the loop, the sum of the numbers at the `low` and `high` indices is calculated and compared to the `target` value. If the sum is **less than** the `target`, the `low` pointer is **incremented** to search for a larger number. If the sum is **greater than** the `target`, the `high` pointer is **decremented** to search for a smaller number. If the sum is equal to the `target`, the indices of the two numbers are returned as an array.

Finally, the function returns an array containing the indices of the two numbers whose sum equals the `target`. The two indices are stored in a new array with the `low` and `high` pointers incremented by 1, since the problem specifies that the indices should be **1-indexed** instead of 0-indexed.


## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1, sum = -1;

        while(low <= high) {
            sum = numbers[low] + numbers[high];
            if(sum < target)
                low++;
            else if(sum > target)
                high--;
            else
                break;
        }

        return new int[]{ low + 1, high + 1 };
    }
}
```

## DOC Code
``` java []
public int[] twoSum(int[] numbers, int target) {

    // Initialize the low pointer to the beginning of the array and the high pointer to the end of the array.
    int low = 0, high = numbers.length - 1;

    // Initialize the sum to -1, this will be used to store the sum of the numbers at low and high pointers.
    int sum = -1;

    // Use the two-pointer technique to search for the required numbers.
    while(low <= high) {

        // Calculate the sum of the numbers at the low and high indices.
        sum = numbers[low] + numbers[high];

        // If the sum is less than the target value, move the low pointer to the next index.
        if(sum < target)
            low++;

        // If the sum is greater than the target value, move the high pointer to the previous index.
        else if(sum > target)
            high--;

        // If the sum is equal to the target value, we have found the required numbers.
        else
            break;
    }

    // Return an array of indices of the two numbers whose sum equals the target value.
    return new int[]{ low + 1, high + 1 };
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Rotate Array
## Intuition & Approach
This code is a Java implementation of an algorithm that rotates the elements of an integer array `nums` to the right by `k` positions. The purpose of this code is to modify the input array in place, without using any additional memory, to achieve the desired rotation.

The approach used in this code is based on the idea of reversing portions of the input array. Specifically, the code divides the input array into three parts: the first `len - k` elements, the next `k` elements, and the remaining elements. It then reverses each of these three parts using the reverse helper method.

The `reverse` method takes an array `nums` and two indices `i` and `j`, and reverses the subarray `nums[i:j]` in place. It does this using a *bitwise XOR swap*, which swaps two elements of an array without using additional memory.

The **bitwise XOR swap algorithm** works by exploiting the properties of the XOR operator to swap two values without needing a temporary variable.

To understand how the rotation works, consider the example input $$[1, 2, 3, 4, 5]$$ and $$k=2$$. First, the code calculates `len=5` and `k=2%5=2`. Then, it *reverses the first* `len-k=3` elements of the array, resulting in $$[3, 2, 1, 4, 5]$$. Next, it *reverses the next* `k=2` elements of the array, resulting in $$[3, 2, 5, 4, 1]$$. Finally, it *reverses the entire array*, resulting in $$[1, 4, 5, 2, 3]$$, which is *the original array rotated to the right by `k` positions.*

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Overall, this algorithm has a time complexity of O(n), where n is the length of the input array, and a space complexity of O(1), since it modifies the input array in place without using any additional memory.

## Code
``` java []
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length, startIndex = 0, endIndex = (len - 1);
        k %= len;

        reverse(nums, startIndex, endIndex - k);
        reverse(nums, len - k, endIndex);
        reverse(nums, startIndex, endIndex);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}
```
## DOC Code
``` java []
class Solution {
    public void rotate(int[] nums, int k) {
        // Get the length of the input array and the starting and ending indices of the array
        int len = nums.length, startIndex = 0, endIndex = (len - 1);

        // Reduce the rotation amount by the length of the array to handle cases where k is larger than len
        k %= len;

        // Reverse the first len - k elements of the array
        reverse(nums, startIndex, endIndex - k);

        // Reverse the next k elements of the array
        reverse(nums, len - k, endIndex);

        // Reverse the entire array to get the final rotated array
        reverse(nums, startIndex, endIndex);
    }

    // Reverse the subarray nums[i:j] in place using a bitwise XOR swap
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Happy Number
## Intuition & Approach
The given code is an implementation of the `Happy Number` problem in Java.

A happy number is a number that eventually reaches 1 when replaced by the sum of the square of each digit in the number, and this process is repeated with the resulting sum until the number either equals 1 or the process loops endlessly in a cycle that does not include 1.

The approach used in this code is to repeatedly square the digits of the given number, until either 1 is reached or the process loops endlessly in a cycle.

If the given number is less than 10, the code checks if it's either 1 or 7, as any number less than 10 can only be a happy number if it's either 1 or 7.

If the given number is not less than 10, the code starts by initializing a variable `op` to zero, and then repeatedly squares each digit of the number (by using modulo operator and integer division) and adds it to the variable `op` until there are no digits left (i.e., until n becomes zero).

The resulting sum, `op`, is then recursively passed back to the isHappy() function to repeat the process until either 1 is reached or the process loops endlessly in a cycle.

## Complexity
- Time complexity: $$O(k*logn)$$ where `k` is the number of recursive calls made by the function.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(k)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```java []
class Solution {

    public boolean isHappy(int n) {
        if(n < 10)
            return (n == 1 || n == 7);
        
        int op = 0;

        do {
            op += (n % 10) * (n % 10);
            n /= 10;
        } while(n != 0);

        return isHappy(op);
    }
}
```

## DOC Code
``` java []
// Defines a public method called "isHappy" that takes an integer parameter "n" and returns a boolean value.
public boolean isHappy(int n) {    

    // Checks if the input number is less than 10.
    if(n < 10)                    
        return (n == 1 || n == 7); // Returns true if the input number is equal to 1 or 7, and false otherwise.
    
    // Initializes a new integer variable "op" with the value 0.
    int op = 0;                   

    do {                          
    // Enters a do-while loop that executes at least once.
        op += (n % 10) * (n % 10);
        // Computes the square of the last digit of the input number and adds it to "op".
        n /= 10;                  
        // Removes the last digit of the input number by dividing it by 10.
    } while(n != 0);              
    // Continues looping until all digits of the input number have been processed.

    // Recursively calls the "isHappy" method with the new value of "op".
    return isHappy(op);           
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# First Bad Version
## Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->
The given code implements the binary search algorithm to find the first bad version in a given range of versions.

The function takes an integer `n` as input which represents the total number of versions available. It starts by initializing two variables, `low` and `mid`, where `low` is set to 1 (the first version) and `mid` is set to -1 (an initial value to be updated later).

The while loop runs until `low` is less than or equal to `n`. In each iteration, the value of `mid` is updated as the middle version between `low` and `n`, using the formula `(low + (n - low) / 2)`. This is done to **avoid integer overflow**, as using `(low + n) / 2` can cause overflow if the sum of `low` and `n` is greater than the maximum integer value.

The `isBadVersion()` function is called on the `mid` version. If it returns true, then the function updates `n` to `mid - 1`, indicating that the first bad version is on the left side of the `mid` version. If `isBadVersion()` returns false, then the function updates low to `mid + 1`, indicating that the first bad version is on the right side of the `mid` version.

The loop continues until `low` becomes greater than `n`, at which point the function returns `low`, which represents *the index of the first bad version*.

In summary, the function uses the **binary search algorithm** to efficiently *find the first bad version* in a given range by dividing the range in half at each iteration and updating the search range accordingly based on the result of calling the `isBadVersion()` function.

# Complexity
- Time complexity: $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, mid = -1;
        while(low <= n) {
            mid = low + ((n - low) / 2);
            if(isBadVersion(mid))
                n = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
```
## DOC Java
``` java []
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Initialize the lower bound of the search range to the first version
        int low = 1, 
        // Initialize the middle version to -1 (an initial value to be updated later)
            mid = -1;
        // Loop until the lower bound is less than or equal to the upper bound
        while(low <= n) {
            // Calculate the middle version between the lower and upper bounds, avoiding integer overflow
            mid = low + ((n - low) / 2);
            // Check if the middle version is a bad version, if true update the upper bound to search for the first bad version on the left side of mid
            if(isBadVersion(mid))
                n = mid - 1;
            // If the middle version is not a bad version, update the lower bound to search for the first bad version on the right side of mid
            else
                low = mid + 1;
        }
        // Return the index of the first bad version, which is equal to the lower bound
        return low;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Move Zeroes
## Intuition & Approach
This code implements *Two Pointers technique* to solve the *"**move zeroes**"* problem, which requires moving all the zeros in an array to the end of the array, while keeping the order of non-zero elements unchanged. Here are the line-by-line explanations:

- `int dest = 0, i = 0, swap = Integer.MIN_VALUE;`: Initialize three variables - `dest` represents the index of *the first available position to put a non-zero number*, `i` represents the *current index*, and `swap` is a *placeholder variable for swapping elements*.

- `do { ... } while(++i < nums.length);`: Loop through the array until the end is reached. The loop continues as long as the `i` index is less than the length of the input array.

- `if(nums[i] == 0) continue;`: If the current element at index `i` is zero, **skip** to the next iteration of the loop.

- `swap = nums[dest]; nums[dest++] = nums[i]; nums[i] = swap;`: If the current element is not zero, **swap** it with the element at the `dest` index, which represents the first available position to put a non-zero number. Then, increment `dest` by one, so that the next non-zero element will be placed in the next available position. Finally, assign the previous value of `nums[dest]` in the current element.

The end result is that all non-zero elements are moved to the beginning of the array, in the original order, and all zeros are moved to the end of the array.

## Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

## Code
``` java []
class Solution {
    public void moveZeroes(int[] nums) {
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        do {
            if(nums[i] == 0) continue;
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;
        } while(++i < nums.length);

    }
}
```
## DOC Java
``` java[]
class Solution {
    public void moveZeroes(int[] nums) {
        // initialize variables for tracking destination index of the first available position to put a non-zero number, current index, and a placeholder value for swaping.
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        // iterate through the array
        do {
            if(nums[i] == 0) continue; // if the current element is 0, skip to the next iteration

            // swap the current element with the element at the destination index
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;

        } while(++i < nums.length); // continue the loop while the current index is less than the length of the array
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Power of Three
## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The code divides the problem of determining if `n` is a power of three into smaller sub-problems by recursively multiplying 3 to itself and comparing the intermediate results with `n`. This approach ensures that the code executes in logarithmic time complexity and solves the problem efficiently.

## Approach
<!-- Describe your approach to solving the problem. -->
The code uses a recursive approach to solve the problem. The method `isPowerOfThree` takes two arguments - `n` and `k`. `n` is the original number passed as an argument to the first method, and `k` is the intermediate result obtained by multiplying 3 to itself repeatedly.

Initially, the first method checks if the given number `n` is less than 3. If `n` is less than 3, it directly returns `true` if `n` equals 1 (as 3^0=1), else it returns `false`.

If `n` is greater than or equal to 3, the control is passed to the second method `isPowerOfThree`, where `n` and `k` are passed as arguments.

In each recursive call, the method multiplies `k` by 3 until `k` becomes equal to or greater than `n`. If `k` becomes equal to `n`, then it returns `true`, as `n` can be represented as a power of 3. If `k` exceeds `n`, then it returns `false`, as `n` cannot be represented as a power of 3.

## Complexity
- Time complexity: $$O(log₃n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of this function is O(log<sub>3</sub>n), where `n` is the given integer. This is because the function uses a recursive approach, in which the value of `k` is multiplied by 3 in each recursive call until `k` becomes equal to or greater than `n`. Since the function recursively divides the problem into smaller sub-problems, the time complexity can be expressed as the logarithm of the input size to the base 3.

- Space complexity: $$O(log₃n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of this function is also O(log<sub>3</sub>n), which is equivalent to the time complexity. This is because the function uses a recursive approach, and each recursive call requires additional memory on the call stack to store the function`s arguments and return address. As the recursion depth is proportional to the logarithm of the input size, the space complexity is also logarithmic in the input size.

In summary, the given function has a time complexity of O(log<sub>3</sub>n) and a space complexity of O(log<sub>3</sub>n), where `n` is the given integer.

## Code
```java []
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        return isPowerOfThree((long)n, 1);
    }

    public boolean isPowerOfThree(long n, long k) {
        if(k >= n)
            return (k == n);
        
        return isPowerOfThree(n, k * 3);
    }
}
```
```java []
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        return isPowerOfThree((long)n, 1);
    }

    public boolean isPowerOfThree(long n, long k) {
        if(k == n)
            return true;

        else if(k > n)
            return false;
        
        return isPowerOfThree(n, k * 3);
    }
}
```


## DOC Code
``` java []
// Checks if the given integer is a power of three.
class Solution {
    // If n is less than 3, check if it is equal to 1. 
    // If yes, then it is a power of 3, else not.
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        // Otherwise, call the overloaded function with long integers.
        return isPowerOfThree((long)n, 1);
    }

    // Overloaded function to handle long integers.
    // Recursively checks if k^3 is equal to n or greater than n, if not, calls itself with k^3 and n.
    public boolean isPowerOfThree(long n, long k) {
        if(k == n)
            return true;

        else if(k > n)
            return false;

        return isPowerOfThree(n, k * 3);
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Reverse String
## Intuition & Approach

This code snippet implements a function called ***reverseString*** which takes a char array `s` as input, and reverses it in place. The function uses a two-pointer approach to reverse the string efficiently.

The function starts by initializing a variable `k` to the index of the last character in the input array. It then uses a for loop to iterate over the first half of the array (up to but not including the middle character).

For each iteration of the loop, the function checks if the character at the current index `i` is different from the character at the corresponding index `k-i` (i.e., the character on the opposite end of the string). If these characters are different, the `swap` method is called to swap the two characters.

The ***swap*** method simply exchanges the values of two elements in the array, given their indices.

This process continues until the loop reaches the middle of the array, at which point the entire string has been reversed in place.

## Complexity
- Time complexity: $$O(n)$$, for accuracy: $$O(\frac{n}{2})$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public void reverseString(char[] s) {
        int k = s.length - 1;
        for(int i = 0; i < ((k + 1) / 2); i++)
            if(s[i] != s[k - i]) 
                swap(s, i, k - i);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
```
## DOC Java
``` java []
// The function takes a char array 's' and reverses it in place
public void reverseString(char[] s) {
    // Initialize variable 'k' to the index of the last character in the input array
    int k = s.length - 1;
    // Loop through the first half of the array (up to but not including the middle character)
    for(int i = 0; i < ((k + 1) / 2); i++)
        // If the character at index 'i' is different from the character at the corresponding index 'k-i'
        // in order to avoid unnecessary swaps
        if(s[i] != s[k - i]) 
            // Swap the characters at indices 'i' and 'k-i'
            swap(s, i, k - i);
}

// Helper function to swap two elements in a char array given their indices
private void swap(char[] c, int i, int j) {
    // Store the value of the element at index 'i' in a temporary variable
    char temp = c[i];
    // Assign the value of the element at index 'j' to the element at index 'i'
    c[i] = c[j];
    // Assign the value of the temporary variable to the element at index 'j'
    c[j] = temp;
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Squares of a Sorted Array
## Intuition & Approach
This function takes an array of integers `nums` as input and *returns a new array with the squares of each element in* `nums`, sorted in **non-decreasing order**.

The approach used by this function is to start with **two pointers**, one at the beginning of `nums` and the other at the end. These pointers move towards each other, comparing the absolute values of the elements they are pointing to at each step. The larger absolute value is squared and placed in the result array in **reverse order** (*starting from the end*), until all elements have been processed.

Since the original array `nums` can contain both positive and negative numbers, the absolute values are used to ensure that the resulting array is sorted in **non-decreasing order**. This is because the square of a negative number is positive, and squares of positive numbers are always non-negative.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
``` java []
class Solution {
	public int[] sortedSquares(int[] nums) {
		int len = nums.length, low = 0, high = len - 1, n, k;
		int[] res = new int[len];
		
		for(int i = len - 1; i >= 0; i--) {
			n = nums[low];
			k = nums[high];
			
			if(Math.abs(n) > Math.abs(k)) {
				res[i] = n*n;
				low++;
			} else {
				res[i] = k*k;
				high--;
			}
		}

		return res;
	}
}
```
## DOC Java
``` java []
class Solution {
    // Takes an array of integers as input and returns a new array with the squares of each element, sorted in non-decreasing order
    public int[] sortedSquares(int[] nums) {
        int len = nums.length, low = 0, high = len - 1, n, k;
        int[] res = new int[len]; // Initialize result array with the same length as nums
        
        // Traverse nums in reverse order
        for(int i = len - 1; i >= 0; i--) {
            n = nums[low]; // Pointer to the start of nums
            k = nums[high]; // Pointer to the end of nums
            
            // Compare absolute values of the elements at n and k
            if(Math.abs(n) > Math.abs(k)) {
                res[i] = n*n; // Square the element at n and add to result array
                low++; // Move the pointer at n to the right
            } else {
                res[i] = k*k; // Square the element at k and add to result array
                high--; // Move the pointer at k to the left
            }
        }

        return res; // Return the sorted squares array
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Maximum 69 Number
## Intuition & Approach

This code takes an integer `num` as input and returns the maximum possible number that can be obtained by changing at most one digit in the given number `num` from 6 to 9.

The code first converts the input number to a character array `arr` using the `valueOf` and `toCharArray` methods of the String class.

Then, the code iterates through the array from left to right using a do-while loop. For each element of the array, the code checks if it is equal to '6'. If it is, the code changes the element to '9' and converts the updated array back to an integer using the `parseInt` and `valueOf` methods of the Integer and String classes, respectively. The resulting integer is then returned as the output.

If the loop completes without finding any '6' digits in the array, the original input number is returned as the output since no digit could be changed to increase the value of the number.

Overall, this algorithm finds the leftmost '6' digit in the input number and changes it to '9' to get the maximum possible number that can be obtained by changing at most one digit.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `maximum69Number` function is O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array and then iterate through each digit of the array to find the leftmost '6' digit. The conversion takes O(n) time, and the loop takes O(n) time in the worst case scenario where the '6' digit is at the end of the array.

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the function is also O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array, which requires creating a new array of length n to store the characters. Additionally, the function creates a string representation of the modified array and then parses it back into an integer, which requires additional memory.

Overall, the function has a linear time complexity and space complexity, which is optimal for this problem since it requires iterating through each digit of the input integer to find the leftmost '6' digit.

## Code
```java []
class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int i = 0;
        
        do {
            if(arr[i] == '6') {
                arr[i] = '9';
                return Integer.parseInt(String.valueOf(arr));
            }
            i++;
        } while(i < arr.length);

        return num;
    }
}
```

## DOC Code
```java []
class Solution {
    public int maximum69Number (int num) {
        // Convert the input integer to a character array
        char[] arr = String.valueOf(num).toCharArray();

        // Initialize a variable to keep track of the current index in the array
        int i = 0;

        // Loop through the array from left to right
        do {
            // Check if the current digit is '6'
            if(arr[i] == '6') {
                // If the current digit is '6', replace it with '9' to maximize the number and return it
                arr[i] = '9';
                return Integer.parseInt(String.valueOf(arr));
            }
            // Move to the next digit
            i++;
        } while(i < arr.length);

        // If no digit can be changed, return the original number
        return num;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Matrix Diagonal Sum
## Intuition & Approach
The ***diagonalSum*** function takes a *square matrix* `mat` as input and returns the sum of the diagonals of the matrix.

The function first initializes a variable `diagonalSum` to 0. It then loops through each row of the matrix using the variable `i` as the row index.

For each row, the function adds the value of the elements at the indices (`i`, `i`) and (`i`, `N - 1 - i`) to the `diagonalSum` variable. These indices correspond to the main diagonal and the secondary diagonal of the matrix, respectively.

Finally, the function subtracts the value of the element at the center of the matrix if the matrix has an odd number of rows and columns. This is because the element at the center is added twice to the `diagonalSum` variable, so we need to subtract one instance of it.

## Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
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

## DOC Code
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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Determine the Winner of a Bowling Game
## Intuition & Approach

The function `isWinner` takes two integer arrays, `player1` and `player2`, representing the number of pins knocked down by each player in their sequence of rolls. The function then calculates the final scores of both players and returns the result of the game as follows:

- If the scores are equal, return 0, indicating a tie.
- If the score of player 1 is higher, return 1, indicating player 1 wins.
- If the score of player 2 is higher, return 2, indicating player 2 wins.

The calculation of the final score is done using a while loop that iterates through both player's rolls, keeping track of the current and previous rolls for each player. If a player scores a strike (knocking down all ten pins in one roll), the next two rolls are counted twice towards their score. If a player scores a spare (knocking down all ten pins in two rolls), the next roll is counted twice towards their score.

Overall, the code is a simple implementation of a scoring system for the game of Bowling, and it assumes that the input arrays player1 and player2 have the same length and are well-formed.

## Complexity
- Time complexity: $$O(n)$$ where `n` indicates how many turns.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = player1[0], s2 = player2[0], i = 1,
            p1 = player1[i - 1], p2 = player2[i - 1],
            pp1 = -1, pp2 = -1;

        while(i < player1.length) {
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            pp1 = p1;
            pp2 = p2;
            p1 = player1[i];
            p2 = player2[i];

            i++;
        }

        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```
``` python []
class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        s1, s2, p1, p2 = player1[0], player2[0], -1, -1

        for i in range(1, len(player1)):
            s1 += (2 * player1[i]) if (player1[i - 1] == 10 or p1 == 10) else player1[i]
            s2 += (2 * player2[i]) if (player2[i - 1] == 10 or p2 == 10) else player2[i]
            p1, p2 = player1[i - 1], player2[i - 1]

        return 0 if s1 == s2 else 1 if s1 > s2 else 2
    
```
``` javascript []
/**
 * @param {number[]} player1
 * @param {number[]} player2
 * @return {number}
 */
var isWinner = function(player1, player2) {
    let s1 = player1[0], s2 = player2[0], i = 1,
        p1 = player1[i - 1], p2 = player2[i - 1],
        pp1 = -1, pp2 = -1;
    
    while(i < player1.length) {
        s1 += isTen(p1, pp1) ? 2 * player1[i] : player1[i];
        s2 += isTen(p2, pp2) ? 2 * player2[i] : player2[i];

        pp1 = p1;
        pp2 = p2;
        p1 = player1[i];
        p2 = player2[i++];
    }

    return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
};

const isTen = (n1, n2) => n1 === 10 || n2 === 10;
```
## DOC Java Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
            // Declare and initialize variables for the total score of each player and the frame number
        int s1 = player1[0], s2 = player2[0], i = 1,
            // Initialize variables for the current score and the previous score for each player
            p1 = player1[i - 1], p2 = player2[i - 1],
            // Initialize variables for the previous previous score for each player (default to -1)
            pp1 = -1, pp2 = -1;

        // Loop through each frame in the players' score arrays
        while(i < player1.length) {
            // Calculate the score for each player for the current frame, taking into account any bonuses
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            // Update the previous-previous scores for each player
            pp1 = p1;
            pp2 = p2;
            
            // Update the current scores to be previous scores for each player
            p1 = player1[i];
            p2 = player2[i];

            // Increment the frame number
            i++;
        }

        // Compare the total scores of the two players and return a result indicating the winner
        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>
