class Solution {
    public boolean isUgly(int n) {
        return (n <= 0) ? false : isUglyHelper(n);
    }

    private boolean isUglyHelper(int n) {
        return (n % 2 == 0) ? isUglyHelper(n / 2) : (n % 3 == 0) ? isUglyHelper(n / 3) : (n % 5 == 0) ? isUglyHelper(n / 5) : (n == 1);
    }
}