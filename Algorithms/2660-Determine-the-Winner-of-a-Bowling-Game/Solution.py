class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        s1, s2, pp1, pp2 = player1[0], player2[0], -1, -1
        
        for i in range(1, len(player1)):
            s1 += (2 * player1[i]) if (player1[i - 1] == 10 or pp1 == 10) else player1[i]
            s2 += (2 * player2[i]) if (player2[i - 1] == 10 or pp2 == 10) else player2[i]
            pp1, pp2 = player1[i - 1], player2[i - 1]

        return 0 if s1 == s2 else 1 if s1 > s2 else 2
    
