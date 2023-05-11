class Solution {
    public double myPow(double x, int n) {
        if((x < -10000 || x > 10000) || (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE))
            return 0;
        
        if(n == 0) return 1; // X^0 is 1 for every X
        if(n < 0) { // X^-n can be represented as (1/X)^n
            n = -n;
            x = 1 / x;
        }

        // if n is even, denote 2k=n so the calculation is X^2k that can be represented as (X^2)^k where k is n/2
        return (n % 2 == 0) ? (myPow(x * x, n / 2)) : (x * myPow(x, n- 1));
    }
}
