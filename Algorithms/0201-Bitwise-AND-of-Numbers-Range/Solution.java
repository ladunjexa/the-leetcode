class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        for(; left < right; right &= right - 1);
        return right;
    }
}
