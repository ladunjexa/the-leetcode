*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach

This code takes an integer `num` as input and returns the maximum possible number that can be obtained by changing at most one digit in the given number `num` from 6 to 9.

The code first converts the input number to a character array `arr` using the `valueOf` and `toCharArray` methods of the String class.

Then, the code iterates through the array from left to right using a do-while loop. For each element of the array, the code checks if it is equal to '6'. If it is, the code changes the element to '9' and converts the updated array back to an integer using the `parseInt` and `valueOf` methods of the Integer and String classes, respectively. The resulting integer is then returned as the output.

If the loop completes without finding any '6' digits in the array, the original input number is returned as the output since no digit could be changed to increase the value of the number.

Overall, this algorithm finds the leftmost '6' digit in the input number and changes it to '9' to get the maximum possible number that can be obtained by changing at most one digit.

# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the `maximum69Number` function is O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array and then iterate through each digit of the array to find the leftmost '6' digit. The conversion takes O(n) time, and the loop takes O(n) time in the worst case scenario where the '6' digit is at the end of the array.

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the function is also O(n), where n is the number of digits in the input integer `num`. This is because the function needs to convert the input integer to a character array, which requires creating a new array of length n to store the characters. Additionally, the function creates a string representation of the modified array and then parses it back into an integer, which requires additional memory.

Overall, the function has a linear time complexity and space complexity, which is optimal for this problem since it requires iterating through each digit of the input integer to find the leftmost '6' digit.

# Code
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

# DOC Code
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
