class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE, N = piles.length, k = -1;

        for(int i = 0; i < N; i++)
            high = Math.max(high, piles[i]);
            
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(!minEatingSpeed(piles, mid, h))
                low = mid + 1;
            else {
                high = mid - 1;
                k = mid;
            }
        }

        return k;
    }

    private boolean minEatingSpeed(int[] piles, int s, int h) {
        int t = 0;
        for(int i = 0; i < piles.length && t <= h; t += piles[i] / s, i++)
            if(piles[i] % s != 0)
                t++;

        return (t > h) ? false : true;
    }
}
