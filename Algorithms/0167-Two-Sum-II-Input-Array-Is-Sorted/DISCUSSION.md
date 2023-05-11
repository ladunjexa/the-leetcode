*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
The purpose of the `twoSum` function is to find the indices of two numbers in the given `numbers` array whose **sum equals the given `target` value**. It uses the *two-pointer technique* to efficiently search for the required numbers.

The *two-pointer technique* involves initializing two pointers, `low` and `high`, to the beginning and end of the array, respectively. Then, at each step of the loop, the sum of the numbers at the `low` and `high` indices is calculated and compared to the `target` value. If the sum is **less than** the `target`, the `low` pointer is **incremented** to search for a larger number. If the sum is **greater than** the `target`, the `high` pointer is **decremented** to search for a smaller number. If the sum is equal to the `target`, the indices of the two numbers are returned as an array.

Finally, the function returns an array containing the indices of the two numbers whose sum equals the `target`. The two indices are stored in a new array with the `low` and `high` pointers incremented by 1, since the problem specifies that the indices should be **1-indexed** instead of 0-indexed.


# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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

# DOC Code
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
