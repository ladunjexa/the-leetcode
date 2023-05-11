class Solution {
    public boolean isHappy(int n) {
        if(n < 10)
            return (n == 1 || n == 7);
        
        int op = 0;

        do {
            op += (n % 10) * (n % 10);
            n /= 10;
        } while(n != 0);

        return isHappy(op);
    }
}