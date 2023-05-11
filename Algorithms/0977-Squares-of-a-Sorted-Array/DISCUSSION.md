*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
This function takes an array of integers `nums` as input and *returns a new array with the squares of each element in* `nums`, sorted in **non-decreasing order**.

The approach used by this function is to start with **two pointers**, one at the beginning of `nums` and the other at the end. These pointers move towards each other, comparing the absolute values of the elements they are pointing to at each step. The larger absolute value is squared and placed in the result array in **reverse order** (*starting from the end*), until all elements have been processed.

Since the original array `nums` can contain both positive and negative numbers, the absolute values are used to ensure that the resulting array is sorted in **non-decreasing order**. This is because the square of a negative number is positive, and squares of positive numbers are always non-negative.

# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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
# DOC Java
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
