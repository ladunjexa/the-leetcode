# Intuition & Approach
> `isInterleave` method aims to determine whether a string `s3` can be formed by interleaving characters from strings `s1` and `s2` while preserving the relative order of characters from both strings.

The `isInterleave` function is the main entry point, which initializes the lengths of `s1`, `s2`, and `s3` as `M`, `N`, and `K`, respectively. If the sum of the lengths of `s1` and `s2` is not equal to the length of `s3`, it immediately returns `false`.

Otherwise, it calls the private isInterleave helper function with additional parameters: `s1`, `s2`, `s3`, current indices `i` and `j`, and a memoization array `memo`.

The isInterleave helper function checks whether characters from `s1` and `s2` can be interleaved to form `s3` starting from indices `i` and `j`, respectively. It uses memoization to avoid redundant computations.

The function first checks if the sum of indices `i` and `j` is equal to the length of `s3`. If it is, that means all the characters of `s3` have been formed successfully, so it returns `true`.

Next, it checks if the memoization array already contains a value for the current indices `i` and `j`. If it does, it directly returns the memoized value.

If the above conditions are not met, the function retrieves the character ch from `s3` at the current indices `i` and `j`. It then recursively checks two possibilities:

1. If i is within the bounds of `s1`, the character at index i in `s1` matches ch, and the remaining characters in `s1` can be interleaved to form the remaining characters of `s3`. This is checked by calling isInterleave with incremented `i` and the same `j`. If this condition is satisfied, the function sets the corresponding flag to `true`.

2. If `j` is within the bounds of `s2`, the character at index `j` in `s2` matches `ch`, and the remaining characters in `s2` can be interleaved to form the remaining characters of `s3`. This is checked by calling isInterleave with the same `i` and incremented `j`. If this condition is satisfied, the function sets the corresponding flag to `true`.

Finally, the function assigns the *logical OR* of both `flags` to the current memoization entry `memo[i][j]` and returns it.

# Complexity
- Time complexity: $$O(M * N)$$

The **time complexity** of this solution is `O(M * N)`, where `M` is the length of string `s1` and `N` is the length of string `s2`. This is because each combination of `i` and `j` is visited once, and there are `M * N` possible combinations.

- Space complexity: $$O(M * N)$$

The **space complexity** is `O(M * N)` as well. This is due to the memoization array `memo`, which has dimensions `(M + 1) x (N + 1)` to account for the possible values of `i` and `j`.

# Code
```java
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int M = s1.length(), N = s2.length(), K = s3.length();

        if(N + M != K)
            return false;
        
        return isInterleave(s1, s2, s3, 0, 0, new Boolean[M + 1][N + 1]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if(i + j == s3.length())
            return true;
        
        if(memo[i][j] != null)
            return memo[i][j];

        char ch = s3.charAt(i + j);
        
        boolean[] flags = {
            i < s1.length() && s1.charAt(i) == ch && isInterleave(s1, s2, s3, i + 1, j, memo), 
            j < s2.length() && s2.charAt(j) == ch && isInterleave(s1, s2, s3, i, j + 1, memo)
        };
        
        return memo[i][j] = (flags[0] || flags[1]);
    }
}
```
