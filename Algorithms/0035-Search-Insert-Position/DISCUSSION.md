*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
The given code implements the binary search algorithm to find the index where a `target` value should be inserted into a sorted array of integers.

The function takes two inputs: an integer array `nums`, which is the sorted array of integers, and an integer `target`, which is the value that needs to be inserted into the array. It starts by initializing three variables, `low`, `high`, and `i`, where `low` is set to `0` (*the first index of the array*), `high` is set to `nums.length - 1` (*the last index of the array*), and `i` is set to `-1` (*an initial value to be updated later*).

The while loop runs until `low` is less than or equal to `high`. In each iteration, the value of `i` is updated as the middle index between `low` and `high`, using the formula `(low + (high - low) / 2)`. This is done to **avoid integer overflow**, as using `(low + high) / 2` can cause overflow if the sum of `low` and `high` is greater than the maximum integer value.

The code then checks whether the value at the i<sup>th</sup> index of the array is equal to the target. If it is, the function *returns the index* `i`.

If the value at the i<sup>th</sup> index is less than the target, the code updates the value of `low` to `i + 1`, indicating that the target value should be inserted to the right of the i<sup>th</sup> index.

If the value at the i<sup>th</sup> index is greater than the target, the code updates the value of `high` to `i - 1`, indicating that the target value should be inserted to the left of the i<sup>th</sup> index.

The loop continues until `low` becomes greater than `high`, at which point the function returns the value of `low`, which represents *the index where the target value should be inserted into the sorted array*.

In summary, the function uses the **binary search algorithm** to efficiently find the index where a target value should be inserted into a sorted array by dividing the array in half at each iteration and updating the search range accordingly based on the result of comparing the value at the middle index to the target value.

# Complexity
- Time complexity: $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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
# DOC Java
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
