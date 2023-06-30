class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int N = spells.length, M = potions.length;
        int[] pairs = new int[N];

        Arrays.sort(potions);
        
        for(int i = 0, low = 0, high = M; i < N; i++, low = 0, high = M) {

            while(low < high) {
                int mid = low + (high - low) / 2;
                long x = (long) spells[i] * (long) potions[mid];
                if(x >= success)
                    high = mid;
                else
                    low = mid + 1;
            }

            pairs[i] = M - low;
        }

        return pairs;
    }
}
