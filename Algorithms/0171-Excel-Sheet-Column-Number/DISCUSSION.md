*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach
<!-- Describe your first thoughts on how to solve this problem. -->

This code is a method named `titleToNumber` that takes a string `columnTitle` as input and returns an integer.

The purpose of this method is to convert an *Excel column title* (e.g., "A", "B", "C", ..., "Z", "AA", "AB", "AC", ..., "ZZ", "AAA", ...) into its *corresponding numeric value*.

**Here's a step-by-step explanation of how the code works:**

1. It first checks the length of the columnTitle string (`N`). If the length is `0` or if the columnTitle is null, it *returns `0`, indicating an invalid input*.

2. It initializes an integer variable `out` to `0`. This variable will store *the final numeric value of the column title*.

3. The code then enters a loop that iterates over each character of the `columnTitle` string.

4. Within the loop, it retrieves the character at the current position (`i`) using the `charAt()` method and converts it to uppercase using `Character.toUpperCase()`. This ensures that both lowercase and uppercase letters can be handled.

5. The code then performs a series of calculations to convert the character into its corresponding numeric value. It multiplies the current value of `out` by `26` (*since there are 26 letters in the English alphabet*), and then adds the difference between the ASCII value of the character and the ASCII value of 'A' plus 1. The expression `c - 'A' + 1` calculates the numeric value of the character, where 'A' represents 1, 'B' represents 2, and so on.

6. After the loop has iterated over all characters in the `columnTitle` string, the final numeric value is stored in the out variable.

7. Finally, the method returns the value of `out`, which represents *the converted numeric value of the column title*.

**Character to Numeric Value Conversion Explanation**

The expression `c - 'A' + 1` is used to calculate the numeric value of the variable `c` of type `char` relative to the letter 'A'.

In ASCII representation, the character 'A' has a decimal value of 65. By subtracting the ASCII value of 'A' from the ASCII value of `c`, you obtain the offset or the distance between the character `c` and 'A'.

For example, if `c` is 'B', the ASCII value of 'B' is 66. By subtracting the ASCII value of 'A' (65) from the ASCII value of 'B' (66), you get 1. This result represents the distance between 'B' and 'A' in the alphabet.

However, in this case, we want the mapping to be 'A' = 1, 'B' = 2, 'C' = 3, and so on. That's why we add 1 to the offset. So, when `c` is 'B', the offset is 1, and adding 1 gives us the desired numeric value of 2 for 'B'.

In summary, the expression `c - 'A' + 1` adjusts the ASCII-based offset of the character `c` relative to 'A' to obtain the corresponding numeric value in the range of 1 to 26, where 'A' represents 1, 'B' represents 2, and so on.

# Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

# Code
``` java []
class Solution {
    public int titleToNumber(String columnTitle) {
        int N = columnTitle.length(), out = 0;

        if(N == 0 || columnTitle == null)
            return out;
        
        for(int i = 0; i < N; i++) {
            char c = Character.toUpperCase(columnTitle.charAt(i));
            out *= 26;
            out += c - 'A' + 1;
        }

        return out;
    }
}
```
