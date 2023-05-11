public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int total = 0;

        do {
            total += n & 1;
            n >>>= 1;
        } while(n != 0);

        return total;
    }
}