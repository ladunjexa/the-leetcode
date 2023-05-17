class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0, high = (long) Math.sqrt(c);

        while(low <= high) {
            long sq = (low * low) + (high * high);
            if(sq == c)
                return true;
            else if(sq < c)
                low++;
            else
                high--;
        }

        return false;
    }
}
