class Solution {
    public int minFlips(int a, int b, int c) {
        int out = 0;

        while(a != 0 || b != 0 || c != 0) {
            if((c % 2) != ((a % 2) | (b % 2)))
                out += (c % 2 == 0) ? (a % 2) + (b % 2) : 1;
            
            a /= 2;
            b /= 2;
            c /= 2;
        }

        return out;
    }
}
