class Solution {
    public int arrangeCoins(int n) {
        if(n == 1)
            return 1;
        
        return arrangeCoins(n, 1);
    }

    private int arrangeCoins(int n, int line) {
        if(n < 0)
            return (line - 2);
        else if(n == 0)
            return (line - 1);
        else
            return arrangeCoins(n - line, line + 1);
    }
}
