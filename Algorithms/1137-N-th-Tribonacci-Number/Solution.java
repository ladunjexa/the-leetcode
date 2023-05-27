class Solution {
    public int tribonacci(int n) {
        return tribonacci(n, new int[n + 1]);
    }

    public int tribonacci(int n, int[] memo) {
        if(n <= 0)
            return 0;

        if(n == 1 || n == 2)
            return 1;

        if(memo[n] == 0)
            memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        
        return memo[n];
    }
}
