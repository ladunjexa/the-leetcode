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
