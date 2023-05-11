*[View](https://github.com/ladunjexa/the-leetcode) my github's repository of leetcode problems' solutions and explanations.*

# Intuition & Approach

The function `isWinner` takes two integer arrays, `player1` and `player2`, representing the number of pins knocked down by each player in their sequence of rolls. The function then calculates the final scores of both players and returns the result of the game as follows:

- If the scores are equal, return 0, indicating a tie.
- If the score of player 1 is higher, return 1, indicating player 1 wins.
- If the score of player 2 is higher, return 2, indicating player 2 wins.

The calculation of the final score is done using a while loop that iterates through both player's rolls, keeping track of the current and previous rolls for each player. If a player scores a strike (knocking down all ten pins in one roll), the next two rolls are counted twice towards their score. If a player scores a spare (knocking down all ten pins in two rolls), the next roll is counted twice towards their score.

Overall, the code is a simple implementation of a scoring system for the game of Bowling, and it assumes that the input arrays player1 and player2 have the same length and are well-formed.

# Complexity
- Time complexity: $$O(n)$$ where `n` indicates how many turns.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = player1[0], s2 = player2[0], i = 1,
            p1 = player1[i - 1], p2 = player2[i - 1],
            pp1 = -1, pp2 = -1;

        while(i < player1.length) {
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            pp1 = p1;
            pp2 = p2;
            p1 = player1[i];
            p2 = player2[i];

            i++;
        }

        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```
``` python []
class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        s1, s2, p1, p2 = player1[0], player2[0], -1, -1

        for i in range(1, len(player1)):
            s1 += (2 * player1[i]) if (player1[i - 1] == 10 or p1 == 10) else player1[i]
            s2 += (2 * player2[i]) if (player2[i - 1] == 10 or p2 == 10) else player2[i]
            p1, p2 = player1[i - 1], player2[i - 1]

        return 0 if s1 == s2 else 1 if s1 > s2 else 2
    
```
``` javascript []
/**
 * @param {number[]} player1
 * @param {number[]} player2
 * @return {number}
 */
var isWinner = function(player1, player2) {
    let s1 = player1[0], s2 = player2[0], i = 1,
        p1 = player1[i - 1], p2 = player2[i - 1],
        pp1 = -1, pp2 = -1;
    
    while(i < player1.length) {
        s1 += isTen(p1, pp1) ? 2 * player1[i] : player1[i];
        s2 += isTen(p2, pp2) ? 2 * player2[i] : player2[i];

        pp1 = p1;
        pp2 = p2;
        p1 = player1[i];
        p2 = player2[i++];
    }

    return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
};

const isTen = (n1, n2) => n1 === 10 || n2 === 10;
```
# DOC Java Code
```java []
class Solution {
    public int isWinner(int[] player1, int[] player2) {
            // Declare and initialize variables for the total score of each player and the frame number
        int s1 = player1[0], s2 = player2[0], i = 1,
            // Initialize variables for the current score and the previous score for each player
            p1 = player1[i - 1], p2 = player2[i - 1],
            // Initialize variables for the previous previous score for each player (default to -1)
            pp1 = -1, pp2 = -1;

        // Loop through each frame in the players' score arrays
        while(i < player1.length) {
            // Calculate the score for each player for the current frame, taking into account any bonuses
            s1 += (p1 == 10 || pp1 == 10) ? 2 * player1[i] : player1[i];
            s2 += (p2 == 10 || pp2 == 10) ? 2 * player2[i] : player2[i];

            // Update the previous-previous scores for each player
            pp1 = p1;
            pp2 = p2;
            
            // Update the current scores to be previous scores for each player
            p1 = player1[i];
            p2 = player2[i];

            // Increment the frame number
            i++;
        }

        // Compare the total scores of the two players and return a result indicating the winner
        return (s1 == s2) ? 0 : s1 > s2 ? 1 : 2;
    }
}
```
