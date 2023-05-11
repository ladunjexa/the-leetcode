class Solution {
    public boolean isPowerOfFour(int n) {
        if(n < 4)
            return (n == 1);

        return isPowerOfFour((long)n, 1);
    }

    private boolean isPowerOfFour(long n, long k) {
        if(k >= n)
            return (k == n);

        return isPowerOfFour(n, k * 4);
    }
}