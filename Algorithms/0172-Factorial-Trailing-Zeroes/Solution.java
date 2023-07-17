class Solution {
    public int trailingZeroes(int n) {
        int out = 0;

        for(int ptr = n; ptr > 0; ptr /= 5, out += ptr);

        return out;
    }
}
