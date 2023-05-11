*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
This code implements *Two Pointers technique* to solve the *"**move zeroes**"* problem, which requires moving all the zeros in an array to the end of the array, while keeping the order of non-zero elements unchanged. Here are the line-by-line explanations:

- `int dest = 0, i = 0, swap = Integer.MIN_VALUE;`: Initialize three variables - `dest` represents the index of *the first available position to put a non-zero number*, `i` represents the *current index*, and `swap` is a *placeholder variable for swapping elements*.

- `do { ... } while(++i < nums.length);`: Loop through the array until the end is reached. The loop continues as long as the `i` index is less than the length of the input array.

- `if(nums[i] == 0) continue;`: If the current element at index `i` is zero, **skip** to the next iteration of the loop.

- `swap = nums[dest]; nums[dest++] = nums[i]; nums[i] = swap;`: If the current element is not zero, **swap** it with the element at the `dest` index, which represents the first available position to put a non-zero number. Then, increment `dest` by one, so that the next non-zero element will be placed in the next available position. Finally, assign the previous value of `nums[dest]` in the current element.

The end result is that all non-zero elements are moved to the beginning of the array, in the original order, and all zeros are moved to the end of the array.

# Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

# Code
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
# DOC Java
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
