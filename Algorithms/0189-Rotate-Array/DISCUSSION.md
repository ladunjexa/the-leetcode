*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
This code is a Java implementation of an algorithm that rotates the elements of an integer array `nums` to the right by `k` positions. The purpose of this code is to modify the input array in place, without using any additional memory, to achieve the desired rotation.

The approach used in this code is based on the idea of reversing portions of the input array. Specifically, the code divides the input array into three parts: the first `len - k` elements, the next `k` elements, and the remaining elements. It then reverses each of these three parts using the reverse helper method.

The `reverse` method takes an array `nums` and two indices `i` and `j`, and reverses the subarray `nums[i:j]` in place. It does this using a *bitwise XOR swap*, which swaps two elements of an array without using additional memory.

The **bitwise XOR swap algorithm** works by exploiting the properties of the XOR operator to swap two values without needing a temporary variable.

To understand how the rotation works, consider the example input $$[1, 2, 3, 4, 5]$$ and $$k=2$$. First, the code calculates `len=5` and `k=2%5=2`. Then, it *reverses the first* `len-k=3` elements of the array, resulting in $$[3, 2, 1, 4, 5]$$. Next, it *reverses the next* `k=2` elements of the array, resulting in $$[3, 2, 5, 4, 1]$$. Finally, it *reverses the entire array*, resulting in $$[1, 4, 5, 2, 3]$$, which is *the original array rotated to the right by `k` positions.*

# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Overall, this algorithm has a time complexity of O(n), where n is the length of the input array, and a space complexity of O(1), since it modifies the input array in place without using any additional memory.

# Code
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
# DOC Code
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
