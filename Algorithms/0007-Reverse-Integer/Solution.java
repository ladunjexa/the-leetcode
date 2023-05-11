class Solution {
    public int reverse(int x) {
        long reversed = 0;

        while(x != 0) {
            int last_digit = x % 10;
            reversed += last_digit;
            reversed *= 10;
            x = x / 10;
        }

        reversed /= 10;

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
            return 0;
        
        return (int)(x < 0 ? (-1 * reversed) : (reversed));
    }
}