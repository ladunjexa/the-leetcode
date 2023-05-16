# Intuition & Approach
The `letterCasePermutation` function is a recursive algorithm that generates all possible permutations of a given string, considering different letter case combinations. It uses a ***depth-first search*** approach to explore all possible paths in the permutation space.

The function takes the original string, an empty string to store the current permutation, an index indicating the current character being processed, and a list to store the generated permutations.

The algorithm works as follows:

* If the current index is equal to the length of the original string, it means that a complete permutation has been generated. The current permutation is added to the result list.
* If the current character is a letter, the algorithm makes two recursive calls:
  * One call with the current character converted to uppercase, appending it to the current permutation.
  * Another call with the current character converted to lowercase, also appending it to the current permutation.
In both cases, the algorithm increments the index to process the next character.
* If the current character is a digit, the algorithm makes a single recursive call, appending the digit to the current permutation and incrementing the index.
* The algorithm continues this process, exploring different combinations of letter cases and digits until it reaches the base case.
* Finally, the algorithm returns the list of generated permutations.
The algorithm efficiently generates all possible letter case permutations by leveraging the recursive nature of the problem. It avoids redundant calculations by using backtracking and pruning unnecessary branches in the search space.

Key techniques utilized in this algorithm include recursion, backtracking, string manipulation, and list manipulation. The algorithm exhibits a time complexity of $$O(2^n)$$, where n is the length of the input string, as it explores all possible combinations of letter cases.

# Complexity
- Time complexity: $$O(2^n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(2^n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
``` java[]
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        letterCasePermutation(s, "", 0, result);
        
        return result;
    }

    private void letterCasePermutation(String source, String current, int i, List<String> result) {
        if(i == source.length()) {
            result.add(current);
            return ;
        }

        char ch = source.charAt(i);

        if(!Character.isDigit(ch)) {
            letterCasePermutation(source, current + Character.toUpperCase(ch), i + 1, result);
            letterCasePermutation(source, current + Character.toLowerCase(ch), i + 1, result);
        } else
            letterCasePermutation(source, current + ch, i + 1, result);
    }
}
```
# DOC Code
```java []
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>(); // Create a new ArrayList to store the resulting permutations
        
        letterCasePermutation(s, "", 0, result); // Call the overload recursive function to generate permutations
        
        return result; // Return the list of permutations
    }

    private void letterCasePermutation(String source, String current, int i, List<String> result) {
        if (i == source.length()) { // Base case: if the index reaches the end of the source string
            result.add(current); // Add the current permutation to the result list
            return; // Exit the recursive function
        }

        char ch = source.charAt(i); // Get the character at the current index

        if (!Character.isDigit(ch)) { // If the character is not a digit
            letterCasePermutation(source, current + Character.toUpperCase(ch), i + 1, result); // Recursively call the function with the uppercase version of the character
            letterCasePermutation(source, current + Character.toLowerCase(ch), i + 1, result); // Recursively call the function with the lowercase version of the character
        } else {
            letterCasePermutation(source, current + ch, i + 1, result); // If the character is a digit, recursively call the function without changing the character
        }
    }
}
```
