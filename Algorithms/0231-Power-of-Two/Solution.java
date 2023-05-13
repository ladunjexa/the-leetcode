class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        
        return isPowerOfTwo(n, 1);
    }

    private boolean isPowerOfTwo(int n, long current) {
        if(current >= n)
            return (current == n);

        return isPowerOfTwo(n, current*2);
    }
}
