class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        
        int N = candies.length, max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) 
            max = Math.max(max, candies[i]);
        
        for(int i = 0; i < N; i++) 
            result.add(candies[i] + extraCandies >= max);

        return result;
    }
}
