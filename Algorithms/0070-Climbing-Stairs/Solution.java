class Solution {
    public int climbStairs(int n) {
        return fiboClimbStairs(n + 1, 0, 1);
    }

    public int fiboClimbStairs(int n, int x, int y) {
        if(n == 1)
            return y;
                
        int curr = x + y;
        x = y;
        y = curr;

        return fiboClimbStairs(n - 1, x, y);
    }
}    