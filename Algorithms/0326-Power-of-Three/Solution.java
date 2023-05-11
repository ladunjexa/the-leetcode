class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return (n == 1);

        return isPowerOfThree((long)n, 1);
    }

    public boolean isPowerOfThree(long n, long k) {
        if(k == n)
            return true;

        else if(k > n)
            return false;
        
        return isPowerOfThree(n, k * 3);
    }
}