# Intuition & Approach

This code snippet implements a function called ***reverseString*** which takes a char array `s` as input, and reverses it in place. The function uses a two-pointer approach to reverse the string efficiently.

The function starts by initializing a variable `k` to the index of the last character in the input array. It then uses a for loop to iterate over the first half of the array (up to but not including the middle character).

For each iteration of the loop, the function checks if the character at the current index `i` is different from the character at the corresponding index `k-i` (i.e., the character on the opposite end of the string). If these characters are different, the `swap` method is called to swap the two characters.

The ***swap*** method simply exchanges the values of two elements in the array, given their indices.

This process continues until the loop reaches the middle of the array, at which point the entire string has been reversed in place.

# Complexity
- Time complexity: $$O(n)$$, for accuracy: $$O(\frac{n}{2})$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public void reverseString(char[] s) {
        int k = s.length - 1;
        for(int i = 0; i < ((k + 1) / 2); i++)
            if(s[i] != s[k - i]) 
                swap(s, i, k - i);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
```
# DOC Java
``` java []
// The function takes a char array 's' and reverses it in place
public void reverseString(char[] s) {
    // Initialize variable 'k' to the index of the last character in the input array
    int k = s.length - 1;
    // Loop through the first half of the array (up to but not including the middle character)
    for(int i = 0; i < ((k + 1) / 2); i++)
        // If the character at index 'i' is different from the character at the corresponding index 'k-i'
        // in order to avoid unnecessary swaps
        if(s[i] != s[k - i]) 
            // Swap the characters at indices 'i' and 'k-i'
            swap(s, i, k - i);
}

// Helper function to swap two elements in a char array given their indices
private void swap(char[] c, int i, int j) {
    // Store the value of the element at index 'i' in a temporary variable
    char temp = c[i];
    // Assign the value of the element at index 'j' to the element at index 'i'
    c[i] = c[j];
    // Assign the value of the temporary variable to the element at index 'j'
    c[j] = temp;
}
```
