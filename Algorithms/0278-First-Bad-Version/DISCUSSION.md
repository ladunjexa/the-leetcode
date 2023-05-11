*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
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

# Code
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
# DOC Java
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
