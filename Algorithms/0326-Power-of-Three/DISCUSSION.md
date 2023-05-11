*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The code divides the problem of determining if `n` is a power of three into smaller sub-problems by recursively multiplying 3 to itself and comparing the intermediate results with `n`. This approach ensures that the code executes in logarithmic time complexity and solves the problem efficiently.

# Approach
<!-- Describe your approach to solving the problem. -->
The code uses a recursive approach to solve the problem. The method `isPowerOfThree` takes two arguments - `n` and `k`. `n` is the original number passed as an argument to the first method, and `k` is the intermediate result obtained by multiplying 3 to itself repeatedly.

Initially, the first method checks if the given number `n` is less than 3. If `n` is less than 3, it directly returns `true` if `n` equals 1 (as 3^0=1), else it returns `false`.

If `n` is greater than or equal to 3, the control is passed to the second method `isPowerOfThree`, where `n` and `k` are passed as arguments.

In each recursive call, the method multiplies `k` by 3 until `k` becomes equal to or greater than `n`. If `k` becomes equal to `n`, then it returns `true`, as `n` can be represented as a power of 3. If `k` exceeds `n`, then it returns `false`, as `n` cannot be represented as a power of 3.

# Complexity
- Time complexity: $$O(log₃n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of this function is O(log<sub>3</sub>n), where `n` is the given integer. This is because the function uses a recursive approach, in which the value of `k` is multiplied by 3 in each recursive call until `k` becomes equal to or greater than `n`. Since the function recursively divides the problem into smaller sub-problems, the time complexity can be expressed as the logarithm of the input size to the base 3.

- Space complexity: $$O(log₃n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of this function is also O(log<sub>3</sub>n), which is equivalent to the time complexity. This is because the function uses a recursive approach, and each recursive call requires additional memory on the call stack to store the function`s arguments and return address. As the recursion depth is proportional to the logarithm of the input size, the space complexity is also logarithmic in the input size.

In summary, the given function has a time complexity of O(log<sub>3</sub>n) and a space complexity of O(log<sub>3</sub>n), where `n` is the given integer.

# Code
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


# DOC Code
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
